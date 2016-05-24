package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage;
    protected Skin skin;
    private ILevel level;
    private EventListener listener;

    private boolean goToMainMenu = false;

    public PauseDialog(SpriteBatch batch, ILevel level, EventListener listener){

        this.listener = listener;
        this.batch = batch;
        this.level = level;
        this.stage = new Stage();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

    }

    @Override
    public void show() {
        goToMainMenu = false;
        Gdx.input.setInputProcessor(stage);

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton level1Button = new TextButton("Continue", skin);
        TextButton level2Button = new TextButton("Restart Level", skin);
        TextButton level3Button = new TextButton("Main Menu", skin);

        stage.addListener(listener);

        //Add listeners to buttons
        level1Button.addListener(listener);
        level2Button.addListener(listener);
        level3Button.addListener(listener);

        Label levelText = new Label("Game Paused", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(level1Button).width(100).pad(10);
        mainTable.row();
        mainTable.add(level2Button).width(100).pad(10);
        mainTable.row();
        mainTable.add(level3Button).width(100).pad(10);


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
