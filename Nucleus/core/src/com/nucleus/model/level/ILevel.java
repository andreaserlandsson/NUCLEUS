package com.nucleus.model.level;

import com.nucleus.model.molecule.IMolecule;
import com.nucleus.model.nucleusObservers.IObservable;
import com.nucleus.model.particles.INucleon;

import java.util.List;

public interface ILevel<E extends Enum<E>> extends IObservable {

    int getLevelNumber();
    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    IShield getShield();
    List<INucleon> getAirborneNucleons();
    IMolecule getMolecule();
    boolean isOutOfBoundsCheck(INucleon nucleon);
    void removeOutOfBoundsNucleons();
    void pause();
    void resume();
    void update(float delta);
    E getCurrentState();

}
