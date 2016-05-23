package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.MenuController;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class LevelChooseScreen implements Screen {

    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private MenuController listener;
    private List<IViewable> views = new ArrayList<IViewable>();



    public LevelChooseScreen()
    {

        //Initialising graphics

        views.add(new BackgroundViewable());
        listener = new MenuController();
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);
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
    public void resize(int width, int height){
        Gdx.app.log("GameScreen", "resizing");

        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void show(){
        Gdx.app.log("GameScreen", "showing");

        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.top();
        mainTable.padBottom(15f).padTop(30f);

        //Create buttons
        TextButton level1Button = new TextButton("Level 1", skin);
        TextButton level2Button = new TextButton("Level 2", skin);
        TextButton level3Button = new TextButton("Level 3", skin);

        stage.addListener(listener);

        //Add listeners to buttons
        level1Button.addListener(listener);
        level2Button.addListener(listener);
        level3Button.addListener(listener);

        Label levelText = new Label("Choose Level", skin);
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
    public void hide(){
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public  void pause(){
        Gdx.app.log("GameScreen", "pause called");
    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}

