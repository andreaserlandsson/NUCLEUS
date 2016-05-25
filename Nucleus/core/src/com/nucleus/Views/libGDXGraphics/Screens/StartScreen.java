package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.LevelUtils.LevelBuilder;
import com.nucleus.Utils.Assets;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.NucleonViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class StartScreen extends NucleusScreen implements Screen {
    private ILevel level;
    private List<IViewable> views = new ArrayList<IViewable>();

    public StartScreen(EventListener listener) {
        super();
        // Creating level
        Assets.loadTextureFiles();

        Assets.loadTextFiles();
        level = LevelBuilder.buildLevel(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //temporary to see that loading texture works
        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));

        //Initialising graphics
        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));

        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton playButton = new TextButton("Play", skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        //Add listeners to buttons
        playButton.addListener(listener);
        optionsButton.addListener(listener);
        exitButton.addListener(listener);
        stage.addListener(listener);

        Label nucleusText = new Label("NUCLEUS", skin);
        mainTable.add(nucleusText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(playButton).width(100).pad(10);
        mainTable.row();
        mainTable.add(optionsButton).width(100).pad(10);
        mainTable.row();
        mainTable.add(exitButton).width(100).pad(10);

        //Add table to stage
        stage.addActor(mainTable);
    }

    @Override
    public void render(float delta) {

        level.update(delta);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(IViewable view : views){
            view.render(batch);
        }

        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height){
        Gdx.app.log("StartScreen", "resizing");

        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void show(){
        Gdx.app.log("StartScreen", "showing");
    }

    @Override
    public void hide(){
        Gdx.app.log("StartScreen", "hide called");
    }

    @Override
    public  void pause(){
        Gdx.app.log("StartScreen", "pause called");
    }

    @Override
    public void resume(){
        Gdx.app.log("StartScreen", "resume called");
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}

