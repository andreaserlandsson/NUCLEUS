package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by erik on 25/05/16.
 */
public class LevelSelectionDialog extends ScreenAdapter{

    private Stage stage;
    protected Skin skin;
    private EventListener listener;


    /**
     * This constructor builds a LevelSelectionDialog object with the correct listener
     */
    public LevelSelectionDialog(EventListener listener){
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
        mainTable.bottom();
        mainTable.padBottom(150f);

        //Create button
        TextButton okButton = new TextButton("OK", skin);

        stage.addListener(listener);

        //Add listeners to buttons. This listener calls on the clicked(...)-method in ButtonEventHandler
        //where it co-responds with a if-state which in turn changes the screen back to LevelChooseScreen
        okButton.addListener(listener);

        Label levelText = new Label("This level is not yet unlocked!", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(okButton).width(100).pad(10);

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
