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
 * Abstract class for the win and lose dialogs.
 */
public abstract class WinLoseDialog extends ScreenAdapter {

    protected Stage stage;
    protected Skin skin;
    protected EventListener listener;
    protected String title = "test text";

    public WinLoseDialog(EventListener listener) {
        this.listener = listener;
    }

    /**
     * Creates a main table with buttons, that is set each time a player wins or lose.
     * Win and Lose dialog both extends this, but alters the title of the windows.
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

