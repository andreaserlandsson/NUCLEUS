package com.nucleus.Views.libGDXGraphics.Viewables;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Quaxi on 24/05/16.
 */
public interface IViewableRotatable {

    void render(SpriteBatch batch, float rotation);
    String getRotationRequirement();

}
