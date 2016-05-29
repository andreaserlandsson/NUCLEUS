package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.nucleus.model.level.ILevel;
import com.nucleus.views.libGDXGraphics.viewables.IViewable;
import com.nucleus.views.libGDXGraphics.viewables.NucleonViewable;

public class StartScreen extends NucleusScreen implements Screen {
    private ILevel level;

    /**
     * This level is level 0, which has no molecule, it just make the start screen have a background
     * with nucleons moving in the background
     *
     * @param listener
     * @param level
     */
    public StartScreen(EventListener listener, ILevel level) {
        super();
        this.level = level;

        //Initialising graphics
        views.add(new NucleonViewable(level.getAirborneNucleons()));

        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Initializing buttons and adding listeners to the buttons. This listener calls on the
        //clicked(...)-method in ButtonEventHandler where it co-responds with a if-state which in turn
        //goes to the Level choose screen if you click "play", goes to the the option screen or exits
        //the application
        TextButton playButton = new TextButton("Play", skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        //Add listeners to buttons
        playButton.addListener(listener);
        optionsButton.addListener(listener);
        exitButton.addListener(listener);
        stage.addListener(listener);

        //adds a title which will be shown on the screen
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

    /**
     * This screen plays a game in the background and so it calls on level.update(delta),
     * Gdc.gl.glClear... and renders the views
     *
     * @param delta
     */
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
}

