package com.nucleus.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.CollisionHandler;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.Level;
import com.nucleus.Model.Molecule;
import com.nucleus.Views.IView;
import com.nucleus.Views.BackgroundView;
import com.nucleus.Views.MoleculeView;
import com.nucleus.Views.NucleonView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private ILevel level;

    private List<IView> views = new ArrayList<IView>();
    //private OrthographicCamera cam;

    private SpriteBatch batch;

    public GameScreen(ILevel level){
        this.level = level;
        //this.cam = new OrthographicCamera(280, 560);
        //cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        views.add(new BackgroundView());
        views.add(new NucleonView(level.getAirborneNucleons()));
        views.add(new MoleculeView(level.getMolecule()));
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        level.update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for(IView view : views){
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
