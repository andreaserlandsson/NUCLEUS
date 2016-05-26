package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.IObservable;
import com.nucleus.Model.IObserver;
import com.nucleus.Model.Level;
import com.nucleus.Views.libGDXGraphics.Dialog.PauseDialog;
import com.nucleus.Views.libGDXGraphics.Dialog.WinDialog;
import com.nucleus.Views.libGDXGraphics.Dialog.WinLoseDialog;
import com.nucleus.Views.libGDXGraphics.Viewables.CountdownViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewableRotatable;
import com.nucleus.Views.libGDXGraphics.Viewables.MoleculeViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.NucleonViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.PauseViewable;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by erik on 25/04/16.
 */

public class GameScreen extends NucleusScreen implements PlayScreen, IObserver<Level.GameState> {


    private final int levelNumber;
    private Level level;

    private WinLoseDialog endGameDialog;
    private com.nucleus.Views.libGDXGraphics.Dialog.PauseDialog pauseDialog;
    private EventListener listener;

    private List<IViewableRotatable> viewsRot = new ArrayList<IViewableRotatable>();

    public GameScreen(Level level, EventListener listener){
        super();
        this.level = level;
        this.listener = listener;
        this.levelNumber = level.getLevelNumber();

        //Adding views
        views.add(new CountdownViewable(level.getNucleonGun()));
        views.add(new NucleonViewable(level.getAirborneNucleons()));
        views.add(new PauseViewable());
        viewsRot.add(new MoleculeViewable(levelNumber, level.getMolecule()));
        pauseDialog = new PauseDialog(listener);

        //Add observers
        level.addObserver(this);
    }

    @Override
    public void render(float delta) {
        level.update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (IViewable view : views) {
            view.render(batch);
        }

        for (IViewableRotatable viewRot : viewsRot) {
            if (viewRot.getRotationRequirement().equals("Molecule")) {
                viewRot.render(batch, level.getMolecule().getRotation());
            }
        }
        if (level.getCurrentState() == Level.GameState.PAUSEDLOSE ||
                level.getCurrentState() == Level.GameState.PAUSEDWIN) {
            endGameDialog.render(delta);
        } else if (level.getCurrentState() == Level.GameState.PAUSED) {
            pauseDialog.render(delta);
        }
    }


    @Override
    public void pause(){
        Gdx.app.log("GameScreen", "pause called");
        pauseDialog.show();
    }

    @Override
    public void resume(){
        Gdx.app.log("GameScreen", "resume called");
        pauseDialog.resume();
    }

    @Override
    public int getWidth() {
        return Gdx.graphics.getWidth();
    }

    @Override
    public int getHeight() {
        return Gdx.graphics.getHeight();
    }

    @Override
    public ILevel getLevel() {
        return level;
    }

    @Override
    public void onObservation(IObservable<Level.GameState> o, Level.GameState arg) {
        if (arg == Level.GameState.PAUSED){
            pause();
        }
        if (arg == Level.GameState.RUNNING){
            resume();
        }
        if (arg == Level.GameState.PAUSEDWIN){
            Gdx.app.log("GameScreen", "Won");
            endGameDialog = new WinDialog(listener);
            endGameDialog.show();
        }
        if (arg == Level.GameState.PAUSEDLOSE){
            Gdx.app.log("GameScreen", "Lost");
            endGameDialog = new com.nucleus.Views.libGDXGraphics.Dialog.LoseDialog(listener);
            endGameDialog.show();
        }
    }
}