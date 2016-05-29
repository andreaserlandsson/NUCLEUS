package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class PauseDialog extends ScreenAdapter {
    private Stage stage;
    protected Skin skin;
    private EventListener listener;

    /**
     * Creates a new pauseDialog with a listener.
     * @param listener the listener that is set for the dialog.
     */
    public PauseDialog(EventListener listener){

        this.listener = listener;

        this.stage = new Stage();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

    }

    /**
     * Creates a table and fills it with buttons.
     * Sets a listener to each button to be interactable.
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

        //Add listeners to buttons
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
    public void resize(int width, int height) {
        //stage.setViewport(width, height);
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
