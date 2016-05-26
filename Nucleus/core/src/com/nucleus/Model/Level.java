package com.nucleus.Model;

import com.nucleus.Model.Collisions.CollisionHandler;
import com.nucleus.Model.Collisions.ICollidable;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int levelNumber;
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float updateInterval = 1;

    private ObservableHelper<GameState> obsHelper = new ObservableHelper<GameState>();

    public enum GameState{
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
        this.obsHelper = new ObservableHelper();
    }

    @Override
    public void addObserver(IObserver o) {
        obsHelper.addObserver(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        obsHelper.removeObserver(o);
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

    public GameState getCurrentState(){
        return currentState;
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
            currentState = GameState.PAUSEDWIN;
            obsHelper.update(this, currentState);
        } else if (gun.isEmpty() && airborneNucleons.isEmpty()) {
            loseGame();
        }
    }

    private void loseGame(){
        currentState = GameState.PAUSEDLOSE;
        obsHelper.update(this, currentState);
    }

    private void checkAllNucleonsStatus(){
        INucleon collidingNucleon = null;
        for (IGluonPoint gluon : gluons) {
            for (INucleon nucleon : airborneNucleons){
                if (CollisionHandler.collision((ICollidable) gluon, (ICollidable) nucleon)) {
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
        obsHelper.update(this, currentState);
    }

    public void resume(){
        currentState = GameState.RUNNING;
        obsHelper.update(this, currentState);
    }

    public void update(float delta){
        if(currentState==GameState.RUNNING) {
            checkWinGame();
            runTime += delta;
            checkAllNucleonsStatus();
            if (runTime - lastUpdateTime >= updateInterval && !gun.isEmpty()) {
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