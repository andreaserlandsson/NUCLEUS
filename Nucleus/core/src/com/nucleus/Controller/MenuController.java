package com.nucleus.Controller;

import com.nucleus.Adapters.Controllers.MenuControllerAdapter;

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
    public void showPauseDialog() {
        adapter.showPauseDialog();
    }

}
