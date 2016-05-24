package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class WinDialog extends WinLoseDialog {

    private SpriteBatch batch;
    private ILevel level;

    public WinDialog(SpriteBatch batch, ILevel level){

        this.batch = batch;
        this.level = level;
        this.title = "You Won";

    }

}
