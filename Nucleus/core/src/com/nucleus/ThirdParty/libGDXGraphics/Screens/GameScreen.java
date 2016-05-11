package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.ILevel;
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


    private List<IViewable> views = new ArrayList<IViewable>();
    private OrthographicCamera cam;

    private SpriteBatch batch;

    public GameScreen(ILevel level){
        this.level = level;
        this.cam = new OrthographicCamera(1080, 1920);
        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        views.add(new BackgroundViewable());
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new MoleculeViewable(level.getMolecule()));
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }

    @Override
    public void render(float delta) {
        if (true) {

        }
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
