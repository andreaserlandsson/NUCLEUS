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

/**
 * Created by erik on 23/05/16.
 */
public class OptionsScreen extends NucleusScreen implements DialogScreen {

    private List<IViewable> views = new ArrayList<IViewable>();
    private TextDialog dialog;
    private EventListener listener;

    public OptionsScreen(ClickListener listener){
        super();

        this.listener = listener;
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

        TextButton reverseRot = new TextButton("Reverse Rotation", skin);
        reverseRot.addListener(listener);
        mainTable.add(reverseRot).width(150).pad(10);
        mainTable.row();

        TextButton toMenuBtn = new TextButton("Main Menu", skin);
        toMenuBtn.addListener(listener);
        mainTable.add(toMenuBtn).width(150).pad(10);
        mainTable.row();

        stage.addActor(mainTable);

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
