package com.nucleus.Model;

import com.badlogic.gdx.Gdx;
import com.nucleus.Model.Collisions.ICollidable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Level extends Observable implements ILevel {
    private int levelNumber;
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float updateTime = 1;

    private enum GameState{
        RUNNING,
        PAUSED,
        PAUSEDWIN,
        PAUSEDLOSE
    }

    private GameState currentState = GameState.RUNNING;

    private INucleonGun gun;
    private List<INucleon> airborneNucleons = new ArrayList<INucleon>();
    private IMolecule molecule;
    private IGluonPoint[] gluons;

    public Level(int levelNumber, int width, int height, INucleonGun gun, IMolecule molecule, IGluonPoint[] gluons){
        this.levelNumber = levelNumber;
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
        this.gluons = gluons;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public boolean isGameWon() {
        return currentState==GameState.PAUSEDWIN;
    }

    public boolean isGameLost() {
        return currentState==GameState.PAUSEDLOSE;
    }

    public boolean isGamePaused() { return currentState==GameState.PAUSED; }

    public void setGamePaused() {
        currentState = GameState.PAUSED;
    }

    public INucleonGun getNucleonGun(){
        return gun;
    }

    public List<INucleon> getAirborneNucleons(){
        return airborneNucleons;
    }

    public IMolecule getMolecule(){
        return molecule;
    }

    //Possible obsolete, required for bugtesting at the moment
    public IGluonPoint[] getGluons() {
        return gluons;
    }

    /*Function should probably be removed*/
    public void addAirborneNucleon(INucleon nucleon){
        airborneNucleons.add(nucleon);
    }

    public boolean isOutOfBoundsCheck(INucleon nucleon){
        float x = nucleon.getPosition().getX();
        float y = nucleon.getPosition().getY();
        float bufferSize = 50; //nucleons aren't considered out of bounds until their "trails" are completely off-screen
        return x - nucleon.getRadius()>=width+bufferSize || x + nucleon.getRadius()<=0-bufferSize ||
                y - nucleon.getRadius()>=height+bufferSize || y + nucleon.getRadius()<=0-bufferSize;
    }

    //TODO: Check so this still works correctly with tests
    public void removeOutOfBoundsNucleons(){ // checks if any nucleons in airborne Nucleons is out of bounds
        for (int i=0; i<airborneNucleons.size(); i++){
            INucleon nucleon = airborneNucleons.get(i);
            if (isOutOfBoundsCheck(nucleon)){
                removeNucleon(nucleon);
                i--;
            }
        }
    }

    private void removeNucleon(INucleon nucleon){
        airborneNucleons.remove(nucleon);
    }

    //TODO: add difficulty multiplier which alters how often the gun shoots and how fast the nucleons fly

    private void checkWinGame() {
        if (molecule.isFull()) {
                setChanged();
                notifyObservers("won");
                currentState = GameState.PAUSEDWIN;
        } else if (gun.isEmpty() && airborneNucleons.isEmpty()) {
            loseGame();
        }
    }

    private void loseGame(){
        currentState = GameState.PAUSEDLOSE;
        setChanged();
        notifyObservers("lost");
    }

    private void checkAllNucleonsStatus(){
        INucleon collidingNucleon = null;
        for (IGluonPoint gluon : gluons) {
            for (INucleon nucleon : airborneNucleons){
                if (com.nucleus.Model.Collisions.CollisionHandler.collision((ICollidable) gluon, (ICollidable) nucleon)) {
                    if (nucleon.getClass().equals(Proton.class)) {
                        if (gluon.getProtonsNeeded() > 0){
                            gluon.addProton();
                            collidingNucleon = nucleon;
                            checkWinGame();
                        } else {
                            loseGame();
                        }
                    }
                    else {
                        if (gluon.getNeutronsNeeded() > 0){
                            gluon.addNeutron();
                            collidingNucleon = nucleon;
                            checkWinGame();
                        } else {
                            loseGame();
                        }
                    }
                }
            }
            if (collidingNucleon != null) {
                removeNucleon(collidingNucleon);
            }
        }
        if (collidingNucleon != null){
            removeNucleon(collidingNucleon);
        }
    }

    public void pause() {
        currentState = GameState.PAUSED;
        setChanged();
        notifyObservers("pause");
    }

    public void resume(){
        currentState = GameState.RUNNING;
        setChanged();
        notifyObservers("resume");
        setChanged();
    }

    public void update(float delta){
        if(currentState==GameState.RUNNING) {
            checkWinGame();
            runTime += delta;
            checkAllNucleonsStatus();
            if (runTime - lastUpdateTime >= updateTime && !gun.isEmpty()) {
                lastUpdateTime = runTime;
                airborneNucleons.add(gun.shoot());
            }
            for (INucleon nucleon : airborneNucleons) {
                nucleon.update(delta);
            }
            removeOutOfBoundsNucleons();
        }
    }
}