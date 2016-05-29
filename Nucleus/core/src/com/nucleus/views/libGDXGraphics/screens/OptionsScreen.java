package com.nucleus.views.libGDXGraphics.screens;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.views.libGDXGraphics.dialogs.TextDialog;
import com.nucleus.views.libGDXGraphics.viewables.BackgroundViewable;
import com.nucleus.views.libGDXGraphics.viewables.IViewable;

import java.util.ArrayList;
import java.util.List;


public class OptionsScreen extends NucleusScreen implements DialogScreen {

    private List<IViewable> views = new ArrayList<IViewable>();
    private TextDialog dialog;
    private EventListener listener;

    /**
     * Creates a new option screen with different options with a listener.
     * @param listener The listener for the screen.
     */

    public OptionsScreen(ClickListener listener){
        super();

        this.listener = listener;
        views.add(new BackgroundViewable());

        //initates the table
        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        Table secondTable = new Table();
        secondTable.setFillParent(true);
        secondTable.center().bottom();
        secondTable.pad(100f);


        //adds the listener to the stage
        stage.addListener(listener);

        //Adds a string which will be shown on the screen
        Label optionsText = new Label("Options", skin);
        mainTable.add(optionsText);
        mainTable.row();


        //Initializing buttons and adding listeners to the buttons. This listener calls on the
        //clicked(...)-method in ButtonEventHandler where it co-responds with a if-state which in turn
        //toggles the sound, reverses the rotations or goes back to the main menu
        TextButton toggleSoundBtn = new TextButton("Toggle Sound", skin);
        toggleSoundBtn.addListener(listener);
        mainTable.add(toggleSoundBtn).width(150).pad(10);
        mainTable.row();

        TextButton reverseRot = new TextButton("Reverse Rotation", skin);
        reverseRot.addListener(listener);
        mainTable.add(reverseRot).width(150).pad(10);
        mainTable.row();

        TextButton toMenuBtn = new TextButton("Main Menu", skin);
        toMenuBtn.addListener(listener);
        secondTable.add(toMenuBtn).width(150).pad(10);
        secondTable.row();

        //adds the table to the stage
        stage.addActor(mainTable);
        stage.addActor(secondTable);

    }

    public void showTextDialog(String text){
        dialog = new TextDialog(listener, text, false);
        dialog.show();
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        if (dialog != null){
            dialog.render(delta);
        }
    }
}
