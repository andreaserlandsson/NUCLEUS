package com.nucleus.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;

import java.util.List;

public interface ILevel  {

    boolean isGameLost();
    boolean isGameWon();
    boolean isGamePaused();
    void setGamePaused();

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
