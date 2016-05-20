package com.nucleus.Model;

import java.util.List;

public interface ILevel {

    boolean isGameLost();
    boolean isGameWon();

    boolean isGamePaused();

    int getWidth();
    int getHeight();
    INucleonGun getNucleonGun();
    List<INucleon> getAirborneNucleons();
     IMolecule getMolecule();
    void addAirborneNucleon(INucleon nucleon);
    void removeOutOfBoundsNucleons();
    void update(float delta);
    IGluonPoint[] getGluons();

    void pause();
    void resume();
}
