package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Controller.MenuController;
import com.nucleus.Controller.MenuListener;
import com.nucleus.Model.ILevel;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage2;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private ILevel level;

    private boolean goToMainMenu = false;

    public PauseDialog( SpriteBatch batch, ILevel level){
        this.batch = batch;
        stage2 = new Stage();
        this.level = level;

    }

    @Override
    public void show() {

        goToMainMenu = false;

        Gdx.input.setInputProcessor(stage2);
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));


        new Dialog("PAUSED", skin) {
            {
                button("Continue Playing", "con");
                button("Main Menu", "menu");
                setMovable(false);
            }

            @Override
            protected void result(final Object object) {
                if (object.toString() == "con") {
                    dispose();

                    level.resume();
                    System.out.println("continue");

                } else {

                    System.out.println("main menu");
                    MenuController controller = new MenuController();
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
