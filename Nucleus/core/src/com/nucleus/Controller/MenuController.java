package com.nucleus.Controller;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.nucleus.Model.ILevel;
import com.nucleus.Screens.GameScreen;
import com.nucleus.ThirdParty.NInputAdapter;
import com.nucleus.Utils.LevelBuilder;

public class MenuController {

    public void changeLevel(int levelNum){

        ILevel level = LevelBuilder.buildLevel(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 1);
        Gdx.input.setInputProcessor(new NInputAdapter(level));
        ((Game)Gdx.app.getApplicationListener()).setScreen(new GameScreen(level));

    }

    private void options(){



    }

    public void exit(){
        Gdx.app.exit();
    }


}
