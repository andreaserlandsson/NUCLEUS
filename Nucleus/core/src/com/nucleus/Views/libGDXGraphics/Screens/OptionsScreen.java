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
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 23/05/16.
 */
public class OptionsScreen implements Screen {

    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private List<IViewable> views = new ArrayList<IViewable>();

    public OptionsScreen(ClickListener listener){
        views.add(new BackgroundViewable());
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        stage = new Stage(viewport, batch);


        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        stage.addListener(listener);

        Label optionsText = new Label("Options", skin);
        mainTable.add(optionsText);
        mainTable.row();

        TextButton toggleSoundBtn = new TextButton("Toggle Sound: ON", skin);
        toggleSoundBtn.addListener(listener);
        mainTable.add(toggleSoundBtn).width(150).pad(10);
        mainTable.row();
        TextButton toMenuBtn = new TextButton("Main Menu", skin);
        toMenuBtn.addListener(listener);
        mainTable.add(toggleSoundBtn).width(150).pad(10);
        mainTable.row();

        stage.addActor(mainTable);

        Gdx.input.setInputProcessor(stage);

    }


    @Override
    public void render(float delta){
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
        Gdx.app.log("OptionsScreen", "showing");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("OptionsScreen", "resizing");

    }

    @Override
    public void hide(){
        Gdx.app.log("OptionsScreen", "hiding");
    }

    @Override
    public void pause(){
        Gdx.app.log("OptionsScreen", "pausing");
    }

    @Override
    public void resume(){
        Gdx.app.log("OptionsScreen", "resuming");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
