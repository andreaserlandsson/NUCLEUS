package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nucleus.model.level.ILevel;


/**
 * Created by andreaserlandsson on 24/05/16.
 */
public abstract class WinLoseDialog extends ScreenAdapter {

    //these are all protected because they will be overwritten in WinDialog and LoseDialog
    protected Stage stage;
    protected Skin skin;
    protected EventListener listener;
    protected ILevel level;

    //this string is the string which will be printed out on the screen
    protected String title = "Win/Lose Text";

    /**
     * This constructor builds a WinLoseDialog object with the correct listener
     */
    public WinLoseDialog(EventListener listener) {
        this.listener = listener;
    }


    /**
     * This method sets upp the text and the buttons and add them to a listener which callas on the co-responding action
     */
    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);


        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton level2Button = new TextButton("Play Again", skin);
        TextButton level3Button = new TextButton("Main Menu", skin);

        stage.addListener(listener);

        //Add listeners to buttons. This listener calls on the clicked(...)-method in ButtonEventHandler
        //where it co-responds with a if-state which in turn restarts the level if you press "Play Again"
        //and goes to main menu if you press "Main Menu"
        level2Button.addListener(listener);
        level3Button.addListener(listener);

        Label levelText = new Label(title, skin);
        mainTable.add(levelText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(level2Button).width(100).pad(10);
        mainTable.row();
        mainTable.add(level3Button).width(100).pad(10);


        //Add table to stage
        stage.addActor(mainTable);

    }

    @Override
    public void render(float delta) {

        stage.act(delta);
        stage.draw();

    }

    @Override
    public void hide() {

        dispose();

    }

    @Override
    public void dispose() {

        stage.dispose();
        skin.dispose();

    }

}

