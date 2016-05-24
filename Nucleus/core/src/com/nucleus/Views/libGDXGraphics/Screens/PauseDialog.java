package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage pauseStage;
    private Viewport viewport;
    protected Skin skin;
    private ILevel level;
    private GameController listener;

    private boolean goToMainMenu = false;

    public PauseDialog() {
    }

    public PauseDialog(SpriteBatch batch, ILevel level){
        this.batch = batch;
        this.level = level;
        pauseStage = new Stage();
    }

    @Override
    public void show() {
        goToMainMenu = false;
        Gdx.input.setInputProcessor(pauseStage);
        listener =  new GameController();

        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        //Create Table
        Table mainTable = new Table();

        mainTable.setFillParent(true);
        mainTable.center();
        mainTable.padBottom(150f);

        //Create buttons
        TextButton level1Button = new TextButton("Continue", skin);
        TextButton level2Button = new TextButton("Restart Level", skin);
        TextButton level3Button = new TextButton("Main Menu", skin);

        pauseStage.addListener(listener);

        //Add listeners to buttons
        level1Button.addListener(listener);
        level2Button.addListener(listener);
        level3Button.addListener(listener);

        Label levelText = new Label("Game Paused", skin);
        mainTable.add(levelText);
        mainTable.row();

        //Add buttons to table
        mainTable.add(level1Button).width(100).pad(10);
        mainTable.row();
        mainTable.add(level2Button).width(100).pad(10);
        mainTable.row();
        mainTable.add(level3Button).width(100).pad(10);


        //Add table to stage
        pauseStage.addActor(mainTable);



        /*new Dialog("PAUSED", skin) {
            {*/

               /* button("Continue Playing", "continue");
                getButtonTable().row();
                button("Restart Level", "restart");
                getButtonTable().row();
                button("Main Menu", "menu");
                setMovable(false);*/

            //}

            /*
            @Override
            protected void result(final Object object) {
                if (object.toString().equals("continue")) {
                    System.out.println("continue");
                    dispose();
                    level.resume();
                    System.out.println("continue");

                } else if (object.equals("menu")) {

                    System.out.println("main menu");
                    GameController controller = new GameController();
                    controller.goToStartScreen();

                } else if (object.equals("restart")) {

                    System.out.println("restart");

                }
            }*/

        //}.show(stage2);
    }

    @Override
    public void resize(int width, int height) {
        //stage.setViewport(width, height);
    }

    @Override
    public void render(float delta) {
        pauseStage.act(delta);
        pauseStage.draw();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        pauseStage.dispose();
        skin.dispose();
    }


}
