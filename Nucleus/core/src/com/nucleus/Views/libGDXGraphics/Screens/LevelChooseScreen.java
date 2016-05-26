package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quaxi on 04/05/16.
 */
public class LevelChooseScreen extends NucleusScreen {

    private List<IViewable> views = new ArrayList<IViewable>();
    private Button[] buttons;
    private LevelSelectionDialog levelSelectionDialog;

    private boolean errorShowing = false;

    public LevelChooseScreen(ClickListener listener, int numOfButtons)
    {
        super();

        //Initialising graphics
        views.add(new BackgroundViewable());

        //Buttons and stuff
        Gdx.app.log("GameScreen", "showing");

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

        //Initializing buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new TextButton("Level " + (i+1), skin);
            buttons[i].addListener(listener);
            mainTable.add(buttons[i]).width(100).pad(10);
            mainTable.row();
        }

        Table secoundTable = new Table();
        secoundTable.setFillParent(true);
        secoundTable.center().bottom();
        mainTable.padBottom(150f);
        TextButton mainMenu = new TextButton("Main Menu", skin);
        secoundTable.addListener(listener);
        secoundTable.add(mainMenu).width(100).pad(100);


        stage.addListener(listener);

        //Add table to stage
        stage.addActor(mainTable);
        stage.addActor(secoundTable);

        levelSelectionDialog = new LevelSelectionDialog(batch, listener);

    }

    public void showSelectionError(){
        Gdx.app.log("Level selection error", "showing");
        errorShowing = true;
        levelSelectionDialog.show();
    }

    public void closeSelectionError(){
        Gdx.app.log("Level selection error", "closed");
        errorShowing = false;
        levelSelectionDialog.dispose();
    }

    @Override
    public void render(float delta){
        super.render(delta);
        levelSelectionDialog.render(delta);

    }

}

