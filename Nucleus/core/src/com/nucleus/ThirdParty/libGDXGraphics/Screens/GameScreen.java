package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.MenuController;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.Level;
import com.nucleus.ThirdParty.libGDXControllers.NInputAdapter;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.CountdownViewable;
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

    private boolean winLoseScreenShow = false;

    private WinLoseScreen loseScreen;
    private WinLoseScreen winScreen;

    private PauseDialog pauseDialog;
    private boolean pauseDialogIsShowing = false;

    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;
    private static SpriteBatch batch;

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
                this.loseScreen = new WinLoseScreen(false, level);
                loseScreen.show();
                winLoseScreenShow = true;
            }

            //winDialog.render(1);
            loseScreen.render(1);

        } else if (level.isGameWon()) {
            if (winLoseScreenShow == false) {
                //winDialog.show();
                this.winScreen = new WinLoseScreen(true, level);
                winScreen.show();
                winLoseScreenShow = true;
            }

            //winDialog.render(1);
            winScreen.render(1);

        } else if (level.isGamePaused()) {
            if (!pauseDialogIsShowing) {
                pause();                    // we only want to call on this once when the game is paused and if the pause dialog is not upp but the game is paused
                pauseDialogIsShowing = true;
            }
            pauseDialog.render(delta);

        } else {
            pauseDialogIsShowing = false;

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

        level.pause();

        this.pauseDialog = new PauseDialog(batch, level);
        pauseDialog.show();

    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");

    }

    @Override
    public void dispose() {
        // Leave blank
    }

}