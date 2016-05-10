package com.nucleus.Controller;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.ILevel;
import com.nucleus.Screens.GameScreen;
import com.nucleus.ThirdParty.NInputAdapter;
import com.nucleus.Utils.LevelBuilder;

public class MenuController extends ClickListener implements ControllerState {


    public void touch(int screenX, int screenY, int pointer, int button){



        return;
    }



    public void drag(int screenX, int screenY, int pointer){
        return;
    }

    private void changeLevel(int levelNum){
        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(level));

    }

    private void options(){

    }

    private void exit(){
        Gdx.app.exit();
    }


    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("playButton", "clicked");
            changeLevel(1);
        }

        if (event.getTarget().toString().equals("Label: Options")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("optionsButton", "clicked");
        }

        if (event.getTarget().toString().equals("Label: Exit")){
            Gdx.app.log("coordinates:","x:" + x + "y: " + y);
            Gdx.app.log("event:", event.toString());
            Gdx.app.log("exitButton", "clicked");
        }


    }



}
