package com.nucleus.Model;

import java.util.List;

public interface ILevel {

    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    List<INucleon> getAirborneNucleons();
     IMolecule getMolecule();
    void addAirborneNucleon(INucleon nucleon);
    void removeNeutron();
    void update(float delta);
    IGluonPoint[] getGluons();


}
