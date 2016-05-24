package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 24/05/16.
 */
public class LoseDialog extends WinLoseDialog {

    private SpriteBatch batch;
    private ILevel level;

    public LoseDialog(SpriteBatch batch, ILevel level) {

        this.batch = batch;
        this.level = level;
        this.title = "You Lost";

    }

}
