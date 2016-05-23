package com.nucleus.Model;

import com.nucleus.Collisions.ICollidable;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int levelNumber;
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float updateTime = 1;

    private boolean gameWon = false;
    private boolean gameLost = false;

    private boolean gamePaused = false;


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
    
    private IProgressTracker progressTracker;


    public Level(int levelNumber, int width, int height, INucleonGun gun, IMolecule molecule, IGluonPoint[] gluons, IProgressTracker pT) {
        this.levelNumber = levelNumber;
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
        this.gluons = gluons;
        this.progressTracker = pT;
        //System.out.println(pT);
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

    public boolean isGameWon() { //this is used in GameScreen to check if the game is paused
        return gameWon;
    }

    public boolean isGameLost() { //this is used in GameScreen to check if the game is paused
        return  gameLost;
    }

    public boolean isGamePaused() {
        return gamePaused;
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
                progressTracker.writeCompletedLevels(levelNumber);
                gameWon = true;
                currentState = GameState.PAUSEDWIN;
        } else if (gun.isEmpty() && airborneNucleons.isEmpty()) {
            loseGame();
        }
    }

    private void loseGame(){
        gameLost = true;
        currentState = GameState.PAUSEDLOSE;
    }

    public void collisionCheck(){
        INucleon collidingNucleon = null;

        for (IGluonPoint gluon : gluons) {
            for (INucleon nucleon : airborneNucleons){
                if (com.nucleus.Collisions.CollisionHandler.collision((ICollidable) gluon, (ICollidable) nucleon)) {

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

    public void pause(){
        currentState = GameState.PAUSED;
        gamePaused = true; //this is used in GameScreen to check if the game is paused

    }

    public void resume(){
        currentState = GameState.RUNNING;
        gamePaused = false; //this is used in GameScreen to check if the game is paused

    }

    public void update(float delta){
        if(currentState==GameState.RUNNING) {
            checkWinGame();
            runTime += delta;
            collisionCheck();
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