package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage2;
    protected Skin skin;
    private ILevel level;

    private boolean goToMainMenu = false;

    public PauseDialog() {
    }

    public PauseDialog(SpriteBatch batch, ILevel level){
        this.batch = batch;
        this.level = level;
        stage2 = new Stage();
    }

    @Override
    public void show() {
        goToMainMenu = false;
        Gdx.input.setInputProcessor(stage2);
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        new Dialog("PAUSED", skin) {
            {
                button("Continue Playing", "continue");
                button("Main Menu", "menu");
                setMovable(false);
            }

            @Override
            protected void result(final Object object) {
                if (object.toString().equals("continue")) {
                    dispose();
                    level.resume();
                    System.out.println("continue");

                } else {

                    System.out.println("main menu");
                    GameController controller = new GameController();
                    controller.goToStartScreen();

                }
            }

        }.show(stage2);
    }

    @Override
    public void resize(int width, int height) {
        //stage.setViewport(width, height);
    }

    @Override
    public void render(float delta) {
        stage2.act(delta);
        stage2.draw();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        stage2.dispose();
        skin.dispose();
    }


}
