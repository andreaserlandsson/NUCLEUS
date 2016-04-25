package com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class NucleusView extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    private OrthographicCamera cam;
    private Viewport viewport;

    @Override
    public void create () {

//        batch = new SpriteBatch();
//        img = new Texture("bg.png");
//        cam = new OrthographicCamera();
//
//        cam.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        int screenWidth = Gdx.graphics.getWidth();
//        int screenHeight = Gdx.graphics.getHeight();
//
//        viewport = new ExtendViewport(screenWidth, screenHeight,
//                screenWidth, screenHeight, cam); // Supposed to keep aspect ratio but doesnt work..
//
//        int gameWidth = 288;
//        int gameHeight = 512;
//
//        NucleusGame game = new NucleusGame(gameWidth, gameHeight);
//
//        System.out.println("level 1  is; ");
//        LevelParser.levelParse(1); //extremely temporary, delete!!
//        System.out.println("level 2 is ;");
//        LevelParser.levelParse(2);

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //batch.begin();
        //batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //batch.end();
    }

    @Override
    public void resize(int width, int height) {
        //viewport.update(width, height);
    }

    @Override
    public void dispose(){

    }
}
