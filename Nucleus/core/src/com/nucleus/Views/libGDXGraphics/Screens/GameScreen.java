package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.Controller.NInputHandler;
import com.nucleus.Controller.NInputProcessor;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Utils.LevelUtils.LevelBuilder;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.CountdownViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewableRotateble;
import com.nucleus.Views.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.NucleonViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.PauseViewable;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen, PlayScreen, Observer {

    private Level level;
    private boolean winLoseScreenShow = false;
    private NMusicPlayer mc;
    private WinDialog winDialog;
    private LoseDialog loseDialog;
    private PauseDialog pauseDialog;
    private EventListener listener;

    private List<IViewable> views = new ArrayList<IViewable>();
    private List<IViewableRotateble> viewsRot = new ArrayList<IViewableRotateble>();
    private OrthographicCamera cam;
    private static SpriteBatch batch;
    private boolean pauseDialogIsShowing = false;

    private INMusicPlayer musicPlayer;

    public GameScreen(int levelNumber, EventListener listener){
        //starting level music
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.getLevelSong(levelNumber));

        this.level = (Level) LevelBuilder.buildLevel(levelNumber, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.listener = listener;
        this.cam = new OrthographicCamera(1080, 1920);
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //Adding views
        views.add(new BackgroundViewable());
        views.add(new CountdownViewable(level.getNucleonGun()));
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new PauseViewable());
        viewsRot.add(new MoleculeViewable(levelNumber, level.getMolecule()));

        pauseDialog = new PauseDialog(batch, level, listener);

        //Add observers
        level.addObserver(this);

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

    }


    @Override
    public void render(float delta) {

        if (level.isGameLost()) {
            if (winLoseScreenShow == false) {
                this.loseDialog = new LoseDialog(batch, level, listener);
                loseDialog.show();
                winLoseScreenShow = true;
            }
            loseDialog.render(delta);

        } else if (level.isGameWon()) {
            if (winLoseScreenShow == false) {
                this.winDialog = new WinDialog(batch, level, listener);
                winDialog.show();
                winLoseScreenShow = true;
            }
            winDialog.render(delta);

        } else if (level.isGamePaused()) {
            if (!pauseDialogIsShowing) {
                pause();
            }
            pauseDialog.render(delta);
            level.update(delta);

        } else {

            pauseDialogIsShowing = false;

            level.update(delta);

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            for (IViewable view : views) {
                view.render(batch);
            }

            for (IViewableRotateble viewRot : viewsRot) {
                if (viewRot.getRotationRequirement().equals("Molecule"))
                viewRot.render(batch, level.getMolecule().getRotation());
            }
        }
    }



    @Override
    public void resize(int width, int height){
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show(){
        Gdx.app.log("GameScreen", "showing");

    }

    @Override
    public void hide(){
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void pause(){

        Gdx.app.log("GameScreen", "pause called");
        pauseDialog.show();
        pauseDialogIsShowing = true;

    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
        pauseDialog.resume();

    }

    @Override
    public void dispose() {
        // Leave blank
    }


    @Override
    public int getWidth() {
        return Gdx.graphics.getWidth();
    }

    @Override
    public int getHeight() {
        return Gdx.graphics.getHeight();
    }

    @Override
    public ILevel getLevel() {
        return level;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg.toString().equals("pause")){
            pause();
        }
        if (arg.toString().equals("resume")){
            resume();
        }
    }
}