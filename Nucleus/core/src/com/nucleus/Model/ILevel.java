package com.nucleus.Model;

import java.util.List;

public interface ILevel  {

    int getLevelNumber();
    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    List<INucleon> getAirborneNucleons();
    IMolecule getMolecule();
    IGluonPoint[] getGluons();
    void addAirborneNucleon(INucleon nucleon);
    void removeOutOfBoundsNucleons();
    void pause();
    void resume();
    void update(float delta);

}
