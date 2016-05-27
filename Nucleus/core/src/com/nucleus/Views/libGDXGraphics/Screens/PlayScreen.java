package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Screen;
import com.nucleus.Model.level.ILevel;

/**
 * Created by Quaxi on 24/05/16.
 */
public interface PlayScreen extends Screen {

    int getWidth();
    int getHeight();
    ILevel getLevel();
}
