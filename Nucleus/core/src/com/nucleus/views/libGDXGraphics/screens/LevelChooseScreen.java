package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.views.libGDXGraphics.dialogs.TextDialog;

public class LevelChooseScreen extends NucleusScreen implements DialogScreen {

    private Button[] buttons;
    private TextDialog levelSelectionDialog;
    private EventListener listener;

    /**
     * Creates a new LevelChooseScreen with a listener and buttons for each level.
     * Also adds a main-menu button.
     * @param listener The listener to be set for the screen.
     * @param numOfButtons The number of buttons to be created, one for each level.
     */
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


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TextButton("Level " + (i+1), skin);
            buttons[i].addListener(listener);
            mainTable.add(buttons[i]).width(100).pad(10);
            mainTable.row();
        }


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

    @Override
    public void render(float delta){
        super.render(delta);
        if (levelSelectionDialog != null){
            levelSelectionDialog.render(delta);
        }
    }

    /**
     * Shows a text dialog with the text as message.
     * @param text the message to be displayed.
     */
    @Override
    public void showTextDialog(String text) {
        levelSelectionDialog = new TextDialog(listener, text, false);
        Gdx.app.log("Level selection error", "showing");
        levelSelectionDialog.show();
    }
}

