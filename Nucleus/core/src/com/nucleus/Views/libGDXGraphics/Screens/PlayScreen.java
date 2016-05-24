package com.nucleus.Views.libGDXGraphics.Screens;

/**
 * Created by Quaxi on 24/05/16.
 */
public interface PlayScreen {

    public void drag(int screenX, int screenY, int pointer);
    public void touch(int screenX, int screenY, int pointer, int button);
}
