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

    public void outOfBoundsCheck(){ // checks if any nucleons in airborne Nucleons is out of bounds
        for (int i=0; i<airborneNucleons.size(); i++){
            INucleon nucleon = airborneNucleons.get(i);
            float x = nucleon.getPosition().getX();
            float y = nucleon.getPosition().getY();
            if (x - nucleon.getRadius()>=width || x + nucleon.getRadius()<=0 ||
                    y - nucleon.getRadius()>=height || y + nucleon.getRadius()<=0){
                airborneNucleons.remove(i);
                i--;
            }
        }
    }
    private void removeNuc(INucleon nuc){
        airborneNucleons.remove(nuc);
    }
    //TODO: add difficulty multiplier which alters how often the gun shoots and how fast the nucleons fly
    //TODO: add a collision check that also evaluates which gluon point to fill
    //TODO: add a win check (molecule.isFull()) and after, a loss check (airborneNucleons is empty and gun is empty)
    INucleon rem;
    public void update(float delta){
        runTime += delta;
        for (IGluonPoint gluon : gluons) {
            for (INucleon nucleon:airborneNucleons){
                if (CollisionHandler.collision(gluon,nucleon)) {
                        if (nucleon.getClass().equals(Proton.class)) {
                            gluon.addProton();
                            nucleon.setVelocity(0,0);
                             rem = nucleon;

                        } else {
                            gluon.addNeutron();
                            nucleon.setVelocity(0,0);
                             rem = nucleon;

                        }
                }
            }
        }
        //removeNuc(rem);

        if(runTime - lastUpdateTime >= dummyUpdateVariable && !gun.isEmpty()) {
            lastUpdateTime = runTime;
            airborneNucleons.add(gun.shoot());
        }
        for(INucleon nucleon : airborneNucleons){
            nucleon.update(delta);
        }
        outOfBoundsCheck();
    }


}