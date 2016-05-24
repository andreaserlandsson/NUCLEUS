package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.GameController;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage2;
    private Viewport viewport;
    protected Skin skin;
    private ILevel level;
    private Dialog dialog;

    private boolean goToMainMenu = false;

    public PauseDialog() {
    }

    public PauseDialog(SpriteBatch batch, ILevel level, EventListener listener){
        this.batch = batch;
        this.level = level;
        stage2 = new Stage();

        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));

        dialog = new Dialog("PAUSED", skin);
        dialog.button("Continue Playing", "continue");
        dialog.button("Main Menu", "menu");
        dialog.setMovable(false);
        dialog.addListener(listener);

        /*
        new Dialog("PAUSED", skin) {

            {
                button("Continue Playing", "continue");
                button("Main Menu", "menu");
                setMovable(false);

            }

            @Override
            protected void result(final Object object) {
                if (object.toString().equals("continue")) {
                    System.out.println("continue");
                    dispose();
                    System.out.println("continue");

                } else if (object.equals("menu")) {

                    System.out.println("main menu");
                    GameController controller = new GameController();
                    controller.goToStartScreen();

                } else if (object.equals("restart")) {

                    System.out.println("restart");

                }
            }

        }.show(stage2);*/

    }

    @Override
    public void show() {
        goToMainMenu = false;
        Gdx.input.setInputProcessor(stage2);
        dialog.show(stage2);

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
