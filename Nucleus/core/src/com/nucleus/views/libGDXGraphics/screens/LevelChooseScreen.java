package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.views.libGDXGraphics.dialogs.TextDialog;
import com.nucleus.views.libGDXGraphics.viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class LevelChooseScreen extends NucleusScreen implements DialogScreen {

    private List<IViewable> views = new ArrayList<IViewable>();
    private Button[] buttons;
    private TextDialog levelSelectionDialog;
    private EventListener listener;

    private boolean errorShowing = false;

    public LevelChooseScreen(ClickListener listener, int numOfButtons) {
        super();

        Gdx.app.log("GameScreen", "showing");

        this.listener = listener;
        //Create Table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        buttons = new Button[numOfButtons];

        Label levelText = new Label("Choose Level", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Initializing buttons and adding listeners to the buttons. This listener calls on the
        //clicked(...)-method in ButtonEventHandler where it co-responds with a if-state which in turn
        //goes back to the game if you press "Continue", restarts the level if you press "Play Again"
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TextButton("Level " + (i+1), skin);
            buttons[i].addListener(listener);
            mainTable.add(buttons[i]).width(100).pad(10);
            mainTable.row();
        }
        //Here we also add a main menu button which has the same listener which calls on the same
        //clicked(...)-method in ButtonEventHandler where it co-responds with a if-state which in turn
        //goes to main menu if you press "Main Menu".
        //We use a new table which is placed at the bottom so that we button also is place at the button.
        Table secondTable = new Table();
        secondTable.setFillParent(true);
        secondTable.center().bottom();
        mainTable.padBottom(150f);
        TextButton mainMenu = new TextButton("Main Menu", skin);
        secondTable.addListener(listener);
        secondTable.add(mainMenu).width(100).pad(100);


        stage.addListener(listener);

        //Add table to stage
        stage.addActor(mainTable);
        stage.addActor(secondTable);



    }

    public void showSelectionError(){
        Gdx.app.log("Level selection error", "showing");
        levelSelectionDialog.show();
    }

    @Override
    public void render(float delta){
        super.render(delta);
        if (levelSelectionDialog != null){
            levelSelectionDialog.render(delta);
        }
    }

    @Override
    public void showTextDialog(String text) {
        levelSelectionDialog = new TextDialog(listener, text, false);
        Gdx.app.log("Level selection error", "showing");
        levelSelectionDialog.show();
    }
}

