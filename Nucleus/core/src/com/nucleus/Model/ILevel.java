package com.nucleus.Model;

import java.util.List;

public interface ILevel {

    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    List<INucleon> getAirborneNucleons();
    public IMolecule getMolecule();
    void addAirborneNucleon(INucleon nucleon);
    void outOfBoundsCheck();
    void update(float delta);


}
