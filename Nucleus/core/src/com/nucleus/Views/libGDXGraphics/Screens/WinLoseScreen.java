package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.GameController;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andreaserlandsson on 11/05/16.
 */

public class WinLoseScreen implements Screen {
    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private GameController listener;
    private boolean hasWon;
    private List<IViewable> views = new ArrayList<IViewable>();
    private BitmapFont font = new BitmapFont();

    public WinLoseScreen(boolean won) {

        this.hasWon = won;
        views.add(new BackgroundViewable());
        listener = new GameController();
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        stage = new Stage(viewport, batch);

        //Input
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

        //Create buttons
        TextButton mainMenuButton = new TextButton("Main Menu", skin);
        TextButton playAgainButton = new TextButton("Play Again", skin);

        stage.addListener(listener);

        //Add listeners to buttons
        stage.addListener(listener);
        mainMenuButton.addListener(listener);
        playAgainButton.addListener(listener);

        //Add buttons and text to table
        if (hasWon) {
            Label winText = new Label("YOU WON", skin);
            mainTable.add(winText);
        } else {
            Label loseText = new Label("YOU LOST", skin);
            mainTable.add(loseText);
        }

        mainTable.row();
        mainTable.add(playAgainButton);
        mainTable.row();
        mainTable.add(mainMenuButton);

        //Add table to stage
        stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.1f, .12f, .16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(IViewable view : views){
            view.render(batch);
        }

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
