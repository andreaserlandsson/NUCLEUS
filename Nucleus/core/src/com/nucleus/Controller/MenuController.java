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
        game.goToLevelChooser();
    }

    private void startLevel(int level){
        game.goToLevel(level);
    }

    public void exit() {
        game.exit();
    }

    public void changeLevel(int i) {
        game.goToLevel(i);
    }

    public void goToStartScreen(){
        game.goToStartLevel();
    }

    public void showPauseDialog(SpriteBatch batch){
        game.showPauseDialog(batch);
    }

    public void clicked(InputEvent event, float x, float y) {

        String label = event.getTarget().toString();

        if (label.equals("Label: Play")) {
            startLevelChooser();
        }

        else if (label.equals("Label: Options")) {
            System.out.println("HÄR SKA DET VARA OPTIONS!!");
        }

        else if (label.equals("Label: Exit")) {
            exit();
        }

        else if (label.equals("Label: Level 1")) {
            startLevel(1);
        }

        else if (label.equals("Label: Level 2")) {
            startLevel(2);
        }

        else if (label.equals("Label: Play Again")) {
            game.goToStartLevel();
        }

        else if (label.equals("Label: Main Menu")) {
            game.goToStartScreen();
        }

    }
}
