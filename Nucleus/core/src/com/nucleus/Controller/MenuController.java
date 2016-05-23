package com.nucleus.Controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Model.ILevel;
import com.nucleus.NucleusGame;

/**
 * Created by Quaxi on 10/05/16.
 */
public class MenuController extends ClickListener {

    private NucleusGame game;


    public MenuController() {
        game = new NucleusGame();
    }

    public void startLevelChooser() {
        game.startLevelChooser();
    }

    private void startLevel(int level){
        game.startLevel(level);
    }

    public void exit() {
        game.exit();
    }

    public void changeLevel(int i) {
        game.startLevel(i);
    }

    public void goToStartScreen(){
        game.goToStartLevel();
    }

    public void showPauseDialog(Stage stage2, SpriteBatch batch, ILevel level){
        game.showPauseDialog(stage2,batch,level);
    }

    public void clicked(InputEvent event, float x, float y) {

        if (event.getTarget().toString().equals("Label: Play")) {
            startLevelChooser();
        }

        else if (event.getTarget().toString().equals("Label: Options")) {
            System.out.println("HÄR SKA DET VARA OPTIONS!!");
        }

        else if (event.getTarget().toString().equals("Label: Exit")) {
            exit();
        }

        else if (event.getTarget().toString().equals("Label: Level 1")) {
            startLevel(1);
        }

        else if (event.getTarget().toString().equals("Label: Level 2")) {
            startLevel(2);
        }

        //win and lose screen
        else if (event.getTarget().toString().equals("Label: Play Again")) {
            game.goToStartScreen();
        }

        else if (event.getTarget().toString().equals("Label: Main Menu")) {
        }
    }
}
