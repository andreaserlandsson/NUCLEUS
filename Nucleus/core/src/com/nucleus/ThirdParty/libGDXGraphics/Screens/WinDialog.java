package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Controller.MenuListener;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class WinDialog extends ScreenAdapter {
    protected Stage stage;
    protected Skin skin;
    private ClickListener listener;


    public WinDialog(){

        this.listener = new MenuListener();

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage = new Stage());
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        new Dialog("You won!", skin) {

            {
                //Create Table
                Table mainTable = new Table();
                mainTable.setFillParent(true);
                mainTable.top();
                mainTable.padBottom(15f).padTop(30f);

                //Create buttons
                TextButton mainMenuButton = new TextButton("Main Menu", skin);
                TextButton playAgainButton = new TextButton("Play Again", skin);

                stage.addListener(listener);

                //Add listeners to buttons
                mainMenuButton.addListener(listener);
                playAgainButton.addListener(listener);

                //Add buttons to table
                mainTable.add(mainMenuButton);
                mainTable.row();
                mainTable.add(playAgainButton);
                //mainTable.row();

                //Add table to stage
                stage.addActor(mainTable);
            }

            /*
            @Override
            protected void result(final Object object) {
                new Dialog("", skin) {

                    {
                        text(object.toString());
                        button("OK");
                    }

                }.show(stage);
            } */

        }.show(stage);
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // tabort?
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
