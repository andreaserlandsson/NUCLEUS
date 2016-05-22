package com.nucleus.Controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.nucleus.Adapters.Controllers.MenuControllerAdapter;
import com.nucleus.Model.ILevel;

/**
 * Created by Quaxi on 10/05/16.
 */
public class MenuController {

    MenuControllerAdapter adapter;

    public MenuController() {
        adapter = new MenuControllerAdapter();
    }

    public void startLevelChoose() {
        adapter.startLevelChoose();
    }

    public void exit() {
        adapter.exit();
    }

    public void changeLevel(int i) {
        adapter.changeLevel(i);
    }

    public void goToStartScreen(){
        adapter.goToStartLevel();
    }
    public void showPauseDialog(Stage stage2, SpriteBatch batch, ILevel level){adapter.showPauseDialog(stage2,batch,level);}

}
