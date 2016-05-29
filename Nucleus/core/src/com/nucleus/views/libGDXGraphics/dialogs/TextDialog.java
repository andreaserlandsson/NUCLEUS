package com.nucleus.views.libGDXGraphics.Dialogs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;


public class TextDialog extends ScreenAdapter{

    private Stage stage;
    protected Skin skin;
    private EventListener listener;
    private String text;
    private boolean hasOkButton;


    /**
     * This constructor builds a LevelSelectionDialog object with the correct listener
     */
    public TextDialog(EventListener listener){
        this.listener = listener;
        this.stage = new Stage();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
    }

    /**
     * This method sets upp the text and the buttons and add them to a listener which callas on the co-responding action
     */
    @Override
    public void show() {

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.bottom();
        mainTable.padBottom(150f);

        //Create buttons
        if (hasOkButton){
            Gdx.input.setInputProcessor(stage);

            TextButton okButton = new TextButton("OK", skin);

            //Add listeners to buttons
            okButton.addListener(listener);

            //Add buttons to table
            mainTable.add(okButton).width(100).pad(10);

        }

        stage.addListener(listener);


        Label levelText = new Label(text, skin);
        mainTable.add(levelText);
        mainTable.row();


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
