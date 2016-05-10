package com.nucleus.Model;

import java.util.ArrayList;
import java.util.List;

public class Level implements com.nucleus.Model.ILevel {
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float dummyUpdateVariable = 1;

    private com.nucleus.Model.INucleonGun gun;
    private List<com.nucleus.Model.INucleon> airborneNucleons = new ArrayList<com.nucleus.Model.INucleon>();
    private com.nucleus.Model.IMolecule molecule;

    private CollisionHandler collisionHandler = new CollisionHandler();
    private boolean gameIsLost = false;

    public Level(int width, int height, com.nucleus.Model.INucleonGun gun, com.nucleus.Model.IMolecule molecule){
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
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
    public void addAirborneNucleon(com.nucleus.Model.INucleon nucleon){
        airborneNucleons.add(nucleon);
    }

    public void outOfBoundsCheck(){ // checks if any nucleons in airborne Nucleons is out of bounds
        for (int i=0; i<airborneNucleons.size(); i++){
            com.nucleus.Model.INucleon nucleon = airborneNucleons.get(i);
            float x = nucleon.getPosition().getX();
            float y = nucleon.getPosition().getY();
            if (x - nucleon.getRadius()>=width || x + nucleon.getRadius()<=0 ||
                    y - nucleon.getRadius()>=height || y + nucleon.getRadius()<=0){
                airborneNucleons.remove(i);
                i--;
            }
        }
    }

    //TODO: check if nucleon is proton or neutron and add the correct sort to the gluon point
    public void gluonCollisionCheck(){
        for (int i = 0; i < airborneNucleons.size(); i++) {
            for (int j  = 0; j < molecule.getNrOfGluonPoint(); j++){
                if (collisionHandler.collision(molecule.getGluonPoint(j), airborneNucleons.get(i))) {
                    airborneNucleons.remove(i); // removes a nucleon which has collided with a gluon point
                    if (molecule.getGluonPoint(j).isFull()){ //checks if the collided gluon was all ready full, REMOVE THIS AND ALLWAYS CHECK IN THE "update(float delta)" METHOD?
                        gameIsLost = true;
                    } else {
                        if (true) { // check if nucleon is proton
                            molecule.getGluonPoint(j).addProton();
                        } else { // or neutron
                            molecule.getGluonPoint(j).addNeutron();
                        }
                    }
                }
            }
        }
    }

    //TODO: add difficulty multiplier which alters how often the gun shoots and how fast the nucleons fly
    //TODO: add a win check (molecule.isFull()) and after, a loss check (airborneNucleons is empty and gun is empty)
    public void update(float delta){
        runTime += delta;

        if(runTime - lastUpdateTime >= dummyUpdateVariable && !gun.isEmpty()) {
            lastUpdateTime = runTime;
            airborneNucleons.add(gun.shoot());
        }
        for(com.nucleus.Model.INucleon nucleon : airborneNucleons){
            nucleon.update(delta);
        }
        gluonCollisionCheck();
        outOfBoundsCheck();
    }
}