package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 23/05/16.
 */
public class OptionsScreen extends NucleusScreen {

    private List<IViewable> views = new ArrayList<IViewable>();

    public OptionsScreen(ClickListener listener){
        super();

        views.add(new BackgroundViewable());

        Table mainTable = new Table();
        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        stage.addListener(listener);

        Label optionsText = new Label("Options", skin);
        mainTable.add(optionsText);
        mainTable.row();

        TextButton toggleSoundBtn = new TextButton("Toggle Sound", skin);
        toggleSoundBtn.addListener(listener);
        mainTable.add(toggleSoundBtn).width(150).pad(10);
        mainTable.row();
        TextButton toMenuBtn = new TextButton("Main Menu", skin);
        toMenuBtn.addListener(listener);
        mainTable.add(toMenuBtn).width(150).pad(10);
        mainTable.row();

        stage.addActor(mainTable);

    }

}
