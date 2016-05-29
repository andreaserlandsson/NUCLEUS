package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.Screen;
import com.nucleus.model.level.ILevel;

public interface PlayScreen extends Screen {

    int getWidth();
    int getHeight();
    ILevel getLevel();
}
