package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class LevelChooseScreen extends NucleusScreen implements Screen {

    private List<IViewable> views = new ArrayList<IViewable>();
    private Button[] buttons;

    public LevelChooseScreen(ClickListener listener, int numOfButtons)
    {
        super();

        //Initialising graphics
        views.add(new BackgroundViewable());

        //Buttons and stuff
        Gdx.app.log("GameScreen", "showing");

        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        buttons = new Button[numOfButtons];

        Label levelText = new Label("Choose Level", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Initializing buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TextButton("Level " + (i+1), skin);
            buttons[i].addListener(listener);
            mainTable.add(buttons[i]).width(100).pad(10);
            mainTable.row();
        }

        stage.addListener(listener);

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
    public void resize(int width, int height){
        Gdx.app.log("LevelChooseScreen", "resizing");
        viewport.update(width, height);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
    }

    @Override
    public void show(){
        Gdx.app.log("LevelChooseScreen", "Showing");

    }

    @Override
    public void hide(){
        Gdx.app.log("LevelChooseScreen", "hide called");
    }

    @Override
    public  void pause(){
        Gdx.app.log("LevelChooseScreen", "pause called");
    }

    @Override
    public void resume(){
        Gdx.app.log("LevelChooseScreen", "resume called");
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}

