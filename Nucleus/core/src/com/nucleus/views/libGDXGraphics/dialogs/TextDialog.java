package com.nucleus.views.libGDXGraphics.dialogs;

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
     * Creates a new TextDialog with a text, a listener and a button.
     * @param listener the listener.
     * @param text the text to be displayed.
     * @param b the boolean for the button.
     */
    public TextDialog(EventListener listener, String text, boolean b){
        this.listener = listener;
        this.text = text;
        this.stage = new Stage();
        this.hasOkButton = b;
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
    }

    /**
     * Creates a table and fills it with a button and a listener.
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
