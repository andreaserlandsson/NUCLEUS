package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.MenuListener;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.INucleonGun;
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

    private WinDialog winDialog;
    private boolean dialogShow = false;

    private PauseDialog pauseDialog;
    private boolean pauseDialogShowing = false;

    protected Stage stage;
    protected Skin skin;
    private ClickListener listener;

    private WinLoseScreen loseScreen;
    private WinLoseScreen winScreen;

    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;

    private SpriteBatch batch;

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

        listener = new MenuListener();
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        //this.winDialog = new WinDialog();
        //winScreen.show();
        //loseScreen.show();

    }


    @Override
    public void render(float delta) {

        if (level.isGameLost()) {
            if (dialogShow == false) {
                //winDialog.show();
                this.loseScreen = new WinLoseScreen(false);
                loseScreen.show();
                dialogShow = true;
            }

            //winDialog.render(1);
            loseScreen.render(1);

        } else if (level.isGameWon()) {
            if (dialogShow == false) {
                //winDialog.show();
                this.winScreen = new WinLoseScreen(true);
                winScreen.show();
                dialogShow = true;
            }

            //winDialog.render(1);
            winScreen.render(1);

        } else if (level.isGamePaused()) {
            if (pauseDialogShowing) {
                this.pauseDialog = new PauseDialog();
                pauseDialog.show();
                pauseDialogShowing = false;
            }
            pauseDialog.render(1);
        } else {



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

        /*
        Table mainTabel = new Table();
        mainTabel.setFillParent(true);
        mainTabel.top().left();
        mainTabel.padBottom(15f).padTop(30f); //what is this?

        TextButton pauseButton = new TextButton("Pause", skin);

        stage.addListener(listener);

        pauseButton.addListener(listener);

        mainTabel.add(pauseButton);

        stage.addActor(pauseButton);
        */
        Gdx.input.setInputProcessor(stage = new Stage());
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        if (level.isGamePaused()) {

        }
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
        // Leave blank
    }
}
