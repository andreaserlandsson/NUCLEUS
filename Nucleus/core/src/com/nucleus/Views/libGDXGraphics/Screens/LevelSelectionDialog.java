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
import com.nucleus.Model.ILevel;

/**
 * Created by erik on 25/05/16.
 */
public class LevelSelectionDialog extends ScreenAdapter{

    private SpriteBatch batch;
    private Stage stage;
    protected Skin skin;
    private ILevel level;
    private EventListener listener;

    private boolean goToMainMenu = false;

    public LevelSelectionDialog(SpriteBatch batch, ILevel level, EventListener listener){

        this.listener = listener;
        this.batch = batch;
        this.level = level;
        this.stage = new Stage();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton okButton = new TextButton("OK", skin);

        stage.addListener(listener);

        //Add listeners to buttons
        okButton.addListener(listener);

        Label levelText = new Label("Level not yet unlocked!", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(okButton).width(100).pad(10);

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
