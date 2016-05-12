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
import com.nucleus.Model.ILevel;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.Level;
import com.nucleus.Model.NucleonGun;
import com.nucleus.ThirdParty.libGDXControllers.MusicPlayer;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.IViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.NucleonViewable;
import com.nucleus.Utils.LevelBuilder;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class StartScreen implements Screen {

    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private ClickListener listener;
    private String[] buttons;
    private Level level;
    private MusicPlayer music;

    private List<IViewable> views = new ArrayList<IViewable>();


    public StartScreen(String[] buttons)
    {
        level = LevelBuilder.buildLevel(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));


        this.buttons = buttons;
        this.listener = new MenuListener();
        this.music = MusicPlayer.getInstance();
        this.music.initSongs();


        //Initialising graphics
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));
        camera = new OrthographicCamera();
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);

        //Initialize music
        music.playMusicLoop(music.menuMusic,0.3f);
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
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton playButton = new TextButton(buttons[0], skin);
        TextButton optionsButton = new TextButton(buttons[1], skin);
        TextButton exitButton = new TextButton(buttons[2], skin);

        stage.addListener(listener);

        //Add listeners to buttons
        playButton.addListener(listener);
        optionsButton.addListener(listener);
        exitButton.addListener(listener);

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

