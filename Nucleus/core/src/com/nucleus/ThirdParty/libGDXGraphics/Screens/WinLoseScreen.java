package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.MenuListener;

/**
 * Created by andreaserlandsson on 11/05/16.
 */

public class WinLoseScreen implements Screen{
    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private ClickListener listener;
    private String[] buttons;
    private boolean won;

    public WinLoseScreen(boolean won) {
        this.won = won;
        this.listener = new MenuListener();
        //Initialising graphics
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        Gdx.app.log("WinLoseScreen", "showing");

        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.top();
        mainTable.padBottom(15f).padTop(30f);

        /*if (won) {
            mainTable.add("YOU WON");
        } else {
            mainTable.add("YOU LOST");
        }*/


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

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("WinLoseScreen", "resizing");

        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void pause() {
        Gdx.app.log("WinLoseScreen", "hide called");
    }

    @Override
    public void resume() {
        Gdx.app.log("WinLoseScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("WinLoseScreen", "hide called");
    }

    @Override
    public void dispose() {
        Gdx.app.log("WinLoseScreen", "dispose called");
    }
}
