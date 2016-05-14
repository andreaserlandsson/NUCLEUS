package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.NMusicPlayer;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.IViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.NucleonViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private ILevel level;
    private NMusicPlayer musicPlayer;

    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;

    private SpriteBatch batch;

    public GameScreen(int levelNumber, ILevel level){

        this.level = level;
        this.cam = new OrthographicCamera(1080, 1920);
        this.musicPlayer = NMusicPlayer.getInstance();
        this.musicPlayer.changeMusic(NMusicPlayer.loadingMusic, NMusicPlayer.menuMusic,0.5f);
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new MoleculeViewable(levelNumber, level.getMolecule()));

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
        musicPlayer.changeMusic(NMusicPlayer.levelTwoMusic,NMusicPlayer.loadingMusic,0.6f);



        //TODO: abstract this out
        //if (levelNumber == 1){
          // musicPlayer.changeMusic(NMusicPlayer.levelChosen,NMusicPlayer.loading,0.6f);
        //}
        //else if (levelNumber == 2){
          //  musicPlayer.changeMusic(NMusicPlayer.levelTwo,NMusicPlayer.loading,0.6f);
        //}
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
        //musicPlayer.resume(NMusicPlayer.levelSong);
    }

    @Override
    public void hide(){
        Gdx.app.log("GameScreen", "hide called");
       // musicPlayer.pause(NMusicPlayer.levelSong);
    }

    @Override
    public  void pause(){
        Gdx.app.log("GameScreen", "pause called");
        //musicPlayer.pause(NMusicPlayer.levelSong);
    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
        //musicPlayer.resume(NMusicPlayer.levelSong);
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
