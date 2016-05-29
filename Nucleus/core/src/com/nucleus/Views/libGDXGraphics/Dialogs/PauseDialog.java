package com.nucleus.Views.libGDXGraphics.Dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private Stage stage;
    protected Skin skin;
    private EventListener listener;


    /**
     * This constructor builds a PauseDialog object with the correct listener
     */
    public PauseDialog(EventListener listener){

        this.listener = listener;

        this.stage = new Stage();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

    }

    /**
     * This method sets upp the text and the buttons and add them to a listener which callas on the co-responding action
     */
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton continueButton = new TextButton("Continue", skin);
        TextButton restartButton = new TextButton("Restart Level", skin);
        TextButton menuButton = new TextButton("Main Menu", skin);

        stage.addListener(listener);

        //Add listeners to buttons. This listener calls on the clicked(...)-method in ButtonEventHandler
        //where it co-responds with a if-state which in turn goes back to the game if you press "Continue",
        //restarts the level if you press "Play Again" and goes to main menu if you press "Main Menu"
        continueButton.addListener(listener);
        restartButton.addListener(listener);
        menuButton.addListener(listener);

        Label pauseLabel = new Label("Game Paused", skin);
        mainTable.add(pauseLabel);
        mainTable.row();

        //Add buttons to table
        mainTable.add(continueButton).width(100).pad(10);
        mainTable.row();
        mainTable.add(restartButton).width(100).pad(10);
        mainTable.row();
        mainTable.add(menuButton).width(100).pad(10);

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
