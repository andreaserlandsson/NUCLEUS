package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.views.libGDXGraphics.viewables.BackgroundViewable;
import com.nucleus.views.libGDXGraphics.viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

public abstract class NucleusScreen implements Screen {
    protected SpriteBatch batch;
    protected Stage stage;
    protected Viewport viewport;
    protected OrthographicCamera camera;
    protected Skin skin;
    protected List<IViewable> views = new ArrayList<IViewable>();

    public NucleusScreen(){
        views.add(new BackgroundViewable());
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        camera = new OrthographicCamera(1080, 1920);
        camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage = new Stage(viewport, batch);


        //Setting inputHandler
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
    public void show(){
        Gdx.app.log("NucleusScreen", "showing");
    }

    @Override
    public void resize(int width, int height){
        Gdx.app.log("LevelChooseScreen", "resizing");
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void hide(){
        Gdx.app.log("NucleusScreen", "hiding");
        dispose();
    }

    @Override
    public void pause(){
        Gdx.app.log("NucleusScreen", "pausing");
    }

    @Override
    public void resume(){
        Gdx.app.log("NucleusScreen", "resuming");
    }

    @Override
    public void dispose() {

    }
}
