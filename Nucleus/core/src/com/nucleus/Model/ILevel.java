package com.nucleus.Model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Views.libGDXGraphics.Screens.GameScreen;

import java.util.List;

public interface ILevel  {

    boolean isGameLost();
    boolean isGameWon();
    void checkWinGame();
    void loseGame();

    boolean isGamePaused();

    int getLevelNumber();
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
