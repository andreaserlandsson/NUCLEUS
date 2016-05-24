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
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Utils.LevelUtils.LevelBuilder;
import com.nucleus.Views.Assets;
import com.nucleus.Views.INMusicPlayer;
import com.nucleus.Views.NMusicPlayer;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.NucleonViewable;





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
    private GameController listener;
    private String[] buttons;
    private ILevel level;
    private List<IViewable> views = new ArrayList<IViewable>();
    private Assets assets;
    private INMusicPlayer musicPlayer;

    public StartScreen() {

        // Creating level
        level = LevelBuilder.buildLevel(0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.loadMusic();
        Assets.loadTextureFiles();

        musicPlayer.playMusic(NAssetsData.MENUMUSIC);
        //musicPlayer.playSound("music/tempButton.mp3");

        //temporary to see that loading texture works
        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        // Adding Listener
        this.listener = new GameController();


        this.buttons = buttons;

        //Initialising graphics
        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));
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

