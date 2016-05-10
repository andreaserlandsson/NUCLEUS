package com.nucleus.Model;

import java.util.ArrayList;
import java.util.List;

public class Level implements ILevel {
    private int width;
    private int height;

    private float runTime = 0;
    private float lastUpdateTime = 0;
    private float dummyUpdateVariable = 1;

    private INucleonGun gun;
    private List<INucleon> airborneNucleons = new ArrayList<INucleon>();
    private IMolecule molecule;
    private IGluonPoint[] gluons;


    public Level(int width, int height, INucleonGun gun, IMolecule molecule, IGluonPoint[] gluons){
        this.width = width;
        this.height = height;
        this.gun = gun;
        this.molecule = molecule;
        this.gluons = gluons;
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
        return x - nucleon.getRadius()>=width || x + nucleon.getRadius()<=0 ||
                y - nucleon.getRadius()>=height || y + nucleon.getRadius()<=0;

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

    private void removeNucleon(INucleon nuc){
        airborneNucleons.remove(nuc);
    }

    //TODO: add difficulty multiplier which alters how often the gun shoots and how fast the nucleons fly

    private void winGame() {
        System.out.println("YOU HAVE WON YAY!!");
    }

    private void loseGame(){
        System.out.println("You lost :(((");
    }

    public void update(float delta){

        INucleon collidingNucleon = null;
        runTime += delta;

        for (IGluonPoint gluon : gluons) {
            for (INucleon nucleon : airborneNucleons){
                if (CollisionHandler.collision(gluon, nucleon)) {

                        if (nucleon.getClass().equals(Proton.class)) {
                            if (gluon.getProtonsNeeded() > 0){
                                gluon.addProton();
                                collidingNucleon = nucleon;
                                System.out.println("\nAte proton! " + gluon.getProtonsNeeded() + " Protons left");
                            }
                            else {
                                System.out.println("NOT HUNGRY");
                            }
                        }


                        else {
                            if (gluon.getNeutronsNeeded() > 0){
                                gluon.addNeutron();
                                collidingNucleon = nucleon;
                                System.out.println("\nAte proton! " + gluon.getNeutronsNeeded() + " Neutrons left" );
                            }
                            else {
                                System.out.println("NOT HUNGRY");
                            }
                        }
                }
            }
        }

        if (collidingNucleon != null){
            removeNucleon(collidingNucleon);
        }


        if(runTime - lastUpdateTime >= dummyUpdateVariable && !gun.isEmpty()) {
            lastUpdateTime = runTime;
            airborneNucleons.add(gun.shoot());
        }

        for(INucleon nucleon : airborneNucleons){
            nucleon.update(delta);
        }

        removeOutOfBoundsNucleons();
    }


}