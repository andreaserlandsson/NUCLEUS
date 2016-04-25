package com.nucleus;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * Created by erik on 25/04/16.
 */
public class GameScreen implements Screen {
    Level level;

    public GameScreen(Level level){
        this.level = level;
    }

    @Override
    public void render(float delta){
        Gdx.app.log("Rendering",Float.toString(delta));
        //level.update(delta);
    }

    @Override
    public void resize(int width, int height){
        Gdx.app.log("GameScreen", "resizing");
    }

    @Override
    public void show(){
        Gdx.app.log("GameScreen", "resizing");
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
