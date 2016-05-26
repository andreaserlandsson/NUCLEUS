package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by andreaserlandsson on 24/05/16.
 */
public class WinLoseDialog extends ScreenAdapter {

    private Stage stage;
    protected Skin skin;
    private EventListener listener;
    protected String title = "test text";

    private boolean goToMainMenu = false;

    public WinLoseDialog(EventListener listener) {
        this.listener = listener;
    }

    @Override
    public void show() {
        stage = new Stage();
        goToMainMenu = false;
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

        //Add listeners to buttons
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

