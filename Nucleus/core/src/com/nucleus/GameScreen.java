package com.nucleus;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private Level level;

    private List<View> views = new ArrayList<View>();
    //private OrthographicCamera cam;

    private SpriteBatch batch;
    private Texture bg;

    public GameScreen(Level level){
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

        for(View view : views){
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
