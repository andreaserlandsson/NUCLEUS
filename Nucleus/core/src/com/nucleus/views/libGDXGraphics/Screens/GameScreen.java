package com.nucleus.views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.views.libGDXGraphics.Dialogs.LoseDialog;
import com.nucleus.model.level.ILevel;
import com.nucleus.model.nucleusObservers.IObservable;
import com.nucleus.model.nucleusObservers.IObserver;
import com.nucleus.model.level.Level;
import com.nucleus.views.libGDXGraphics.Dialogs.PauseDialog;
import com.nucleus.views.libGDXGraphics.Viewables.CountdownViewable;
import com.nucleus.views.libGDXGraphics.Viewables.IViewable;
import com.nucleus.views.libGDXGraphics.Viewables.PauseViewable;


/**
 * Created by erik on 25/04/16.
 */

public class GameScreen extends NucleusScreen implements PlayScreen, IObserver<Level.GameState> {


    private final int levelNumber;
    private ILevel level;

    private com.nucleus.views.libGDXGraphics.Dialogs.WinLoseDialog endGameDialog;
    private PauseDialog pauseDialog;
    private EventListener listener;

    public GameScreen(ILevel level, EventListener listener){
        super();
        this.level = level;
        this.listener = listener;
        this.levelNumber = level.getLevelNumber();

        //Adding views
        views.add(new CountdownViewable(level.getNucleonGun()));
        views.add(new com.nucleus.views.libGDXGraphics.Viewables.NucleonViewable(level.getAirborneNucleons()));
        views.add(new PauseViewable());
        views.add(new com.nucleus.views.libGDXGraphics.Viewables.MoleculeViewable(levelNumber, level.getMolecule()));
        pauseDialog = new PauseDialog(listener);

        //Add observers
        level.addObserver(this);
    }

    /**
     * This render method renders the game screen and also checks if the game is won,lost or pause
     * and if so also renders the win-, lose- or pause dialog
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        level.update(delta);

        for (IViewable view : views) {
            view.render(batch);
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

    /**
     * On observation this will check the status of the game and call on the co-responding method
     */
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
            endGameDialog = new com.nucleus.views.libGDXGraphics.Dialogs.WinDialog(listener);
            endGameDialog.show();
        }
        if (arg == Level.GameState.PAUSEDLOSE){
            Gdx.app.log("GameScreen", "Lost");
            endGameDialog = new LoseDialog(listener);
            endGameDialog.show();
        }
    }
}