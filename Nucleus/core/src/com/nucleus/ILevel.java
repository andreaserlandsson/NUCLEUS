package com.nucleus;

import java.util.List;

public interface ILevel {

    List<INucleon> getAirborneNucleons();
    void addAirborneNucleon(INucleon nucleon);
    INucleonGun getNucleonGun();
    void outOfBoundsCheck();


}
