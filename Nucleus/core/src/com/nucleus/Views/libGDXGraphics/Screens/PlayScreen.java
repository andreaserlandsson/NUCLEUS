package com.nucleus.Views.libGDXGraphics.Screens;

/**
 * Created by Quaxi on 24/05/16.
 */
public interface PlayScreen {

    void drag(int screenX, int screenY, int pointer);
    void touch(int screenX, int screenY, int pointer, int button);
    int getWidth();
    int getHeight();
    void pause();
}
