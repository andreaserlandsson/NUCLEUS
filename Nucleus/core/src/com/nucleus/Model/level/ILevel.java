package com.nucleus.Model.level;

import com.nucleus.Model.collisions.IObservable;
import com.nucleus.Model.molecule.IGluonPoint;
import com.nucleus.Model.molecule.IMolecule;
import com.nucleus.Model.particles.INucleon;

import java.util.List;

public interface ILevel<E extends Enum<E>> extends IObservable {

    int getLevelNumber();
    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    List<INucleon> getAirborneNucleons();
    IMolecule getMolecule();
    IGluonPoint[] getGluons();
    void addAirborneNucleon(INucleon nucleon);
    boolean isOutOfBoundsCheck(INucleon nucleon);
    void removeOutOfBoundsNucleons();
    void pause();
    void resume();
    void update(float delta);
    E getCurrentState();

}
