package com.nucleus.ThirdParty;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Screens.GameScreen;
import com.nucleus.Screens.LevelChooseScreen;
import com.nucleus.ThirdParty.NInputAdapter;
import com.nucleus.Utils.LevelBuilder;

public class MenuControllerAdapter {

    public void changeLevel(int levelNum){

        Gdx.app.log("level1Button", "received");

        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), levelNum);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(level));

    }
    
    public void startLevelChoose(int levelNum){

        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new LevelChooseScreen());

    }

    private void options(){

    }

    public void exit(){
        Gdx.app.exit();
    }




}
