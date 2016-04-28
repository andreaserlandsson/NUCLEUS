package com.nucleus;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    private Level level;

    private OrthographicCamera cam;

    private SpriteBatch batch;
    private Texture bg;
    private Texture proton, neutron, molecule;
    private Texture x;


    public GameScreen(Level level){
        this.level = level;
        //this.cam = new OrthographicCamera(280, 560);
        //cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        bg = new Texture("bg.png");
        molecule = new Texture("1.png");
        molecule.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        proton = new Texture("proton.png");
        proton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        x = new Texture("x.png");
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        level.update(delta);
        //Gdx.app.log("Delta", Float.toString(delta));
        //Gdx.app.log("FPS", Float.toString(1 / delta));
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.enableBlending();
        for(INucleon nucleon : level.getAirborneNucleons()){
            batch.draw(proton, nucleon.getPosition().getX(), nucleon.getPosition().getY());
        }
        //batch.draw(x,0,0);
        //batch.draw(x,285,0);
        batch.draw(molecule, 140, 206);
        batch.end();

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
