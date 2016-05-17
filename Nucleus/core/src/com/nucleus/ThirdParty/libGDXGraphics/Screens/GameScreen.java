package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.ILevel;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.CountdownViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.IViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.NucleonViewable;
import com.nucleus.ThirdParty.libGDXControllers.MusicPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private ILevel level;
    private MusicPlayer music;


    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;

    private SpriteBatch batch;

    public GameScreen(int levelNumber, ILevel level){

        this.level = level;
        this.cam = new OrthographicCamera(1080, 1920);
        this.music = MusicPlayer.getInstance();
        music.changeMusic(music.menuMusic, music.loadingLevel,0.5f);
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        views.add(new BackgroundViewable());
        views.add(new CountdownViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new MoleculeViewable(levelNumber, level.getMolecule()));

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);


        //TODO: abstract this out
        if (levelNumber == 1){
            music.changeMusic(music.loadingLevel, music.inGameMusic,0.6f);
        }
        else if (levelNumber == 2){
            music.changeMusic(music.loadingLevel, music.inGameMusic2, 0.6f);

        }
    }


    @Override
    public void render(float delta) {
        level.update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(IViewable view : views){
            view.render(batch);
        }
    }

    @Override
    public void resize(int width, int height){
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show(){
        Gdx.app.log("GameScreen", "showing");
        music.resumeMusic(music.inGameMusic);
    }

    @Override
    public void hide(){
        Gdx.app.log("GameScreen", "hide called");
        music.pauseMusic(music.inGameMusic);
    }

    @Override
    public  void pause(){
        Gdx.app.log("GameScreen", "pause called");
        music.pauseMusic(music.inGameMusic);
    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
        music.resumeMusic(music.inGameMusic);
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
