package com.nucleus.model.level;

import com.nucleus.model.collision.CollisionHandler;
import com.nucleus.model.collision.ICollidable;
import com.nucleus.model.molecule.IGluonPoint;
import com.nucleus.model.molecule.IMolecule;
import com.nucleus.model.nucleusObservers.IObserver;
import com.nucleus.model.particles.INucleon;
import com.nucleus.model.particles.Proton;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int levelNumber;
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float updateInterval;

    private ObservableHelper<GameState> obsHelper = new ObservableHelper<GameState>();

    /**
     * Enum for the four different states the game can be in.
     */
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

    /**
     * The parameters each level is built of.
     * @param levelNumber The level number.
     * @param width the width of the game.
     * @param height the height of the game.
     * @param gun the gun used to shoot in nucleons.
     * @param molecule the molecule we want to build.
     * @param obs the observers that observed the level.
     */

    public Level(int levelNumber, int width, int height, INucleonGun gun, IMolecule molecule, ObservableHelper<GameState> obs){
        this.levelNumber = levelNumber;
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
        this.obsHelper = obs;
        this.updateInterval = 1;
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

    /*Function should probably be removed*/
    public void addAirborneNucleon(INucleon nucleon){
        airborneNucleons.add(nucleon);
    }

    /**
     * Checks if a nucleon is out of bounds, that is off the screen.
     * @param nucleon The nucleon to check.
     * @return Returs true if the nucleon is indeed off screen.
     */
    public boolean isOutOfBoundsCheck(INucleon nucleon){
        float x = nucleon.getPosition().getX();
        float y = nucleon.getPosition().getY();
        float bufferSize = 50;
        return x - nucleon.getRadius()>=width+bufferSize || x + nucleon.getRadius()<=0-bufferSize ||
                y - nucleon.getRadius()>=height+bufferSize || y + nucleon.getRadius()<=0-bufferSize;
    }

    /**
     * Remove all nucleons that are out of bounds.
     */
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

    /**
     * Checks the positions of all nucleons and gluonPoints if there has been a collision.
     * If a collision has occurred, add the said nucleon to the gluon point, and check
     * win and lose conditions.
     */
    private void checkAllNucleonsStatus(){
        INucleon collidingNucleon = null;
        for (IGluonPoint gluon : molecule.getGluons()) {
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