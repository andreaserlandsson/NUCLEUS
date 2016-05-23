package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.ILevel;
import com.nucleus.Controller.libGDXControllers.NInputAdapter;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.CountdownViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.NucleonViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private ILevel level;

    private boolean winLoseScreenShow = false;

    private WinLoseScreen loseScreen;
    private WinLoseScreen winScreen;
    private PauseDialog pauseDialog;

    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;
    private static SpriteBatch batch;
    private boolean isPaused;

    public GameScreen(int levelNumber, ILevel level){
        this.level = level;
        this.cam = new OrthographicCamera(1080, 1920);
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        views.add(new BackgroundViewable());
        views.add(new CountdownViewable(level.getNucleonGun()));
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new MoleculeViewable(levelNumber, level.getMolecule()));

        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

    }


    @Override
    public void render(float delta) {

        if (level.isGameLost()) {
            if (winLoseScreenShow == false) {
                //winDialog.show();
                this.loseScreen = new WinLoseScreen(false);
                loseScreen.show();
                winLoseScreenShow = true;
            }

            //winDialog.render(1);
            loseScreen.render(1);

        } else if (level.isGameWon()) {
            if (winLoseScreenShow == false) {
                //winDialog.show();
                this.winScreen = new WinLoseScreen(true);
                winScreen.show();
                winLoseScreenShow = true;
            }

            //winDialog.render(1);
            winScreen.render(1);

        } else if (level.isGamePaused()) {
            pauseDialog.render(delta);
            level.update(delta);

        } else {

            //check if you "touch" the pause "button" and if so call on the pause method
            if ((Gdx.input.getX() > level.getWidth() - 10) && Gdx.input.getY() < 10) {
                pause();
            }

            level.update(delta);

            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            for (IViewable view : views) {
                view.render(batch);
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
        level.pause(batch);
        pauseDialog = new PauseDialog(batch);
        pauseDialog.show();

    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
        Gdx.input.setInputProcessor(new NInputAdapter(level));

    }

    @Override
    public void dispose() {
        // Leave blank
    }

}