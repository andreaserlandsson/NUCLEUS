package com.nucleus.ThirdParty.libGDXGraphics.Screens;

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
    private MenuController controller;
    private ILevel level;

    public PauseDialog(Stage stage2, SpriteBatch batch, ILevel level){
        this.batch = batch;
        this.stage2 = stage2;
        this.level = level;

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage2);
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));


        new Dialog("PAUSED", skin) {
            {
                button("Continue Palying", "con");
                button("Main Menu", "menu");
                setMovable(false);
            }

            @Override
            protected void result(final Object object) {
                if (object.toString() == "con") {
                    level.resume();
                    dispose();
                    System.out.println("continue");
                } else {
                    System.out.println("main menu");
                    goToMainMenu();

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

    public void goToMainMenu(){
        controller.goToStartScreen();
    }


}
