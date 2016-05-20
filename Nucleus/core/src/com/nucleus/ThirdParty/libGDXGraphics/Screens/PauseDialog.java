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
import com.nucleus.Controller.MenuListener;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage2;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private ClickListener listener;

    public PauseDialog(Stage stage2, SpriteBatch batch){
        this.batch = batch;
        this.stage2 = stage2;

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage2 = new Stage());
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));


        new Dialog("Game Paused", skin) {
            {
                button("Continue Palying", "con");
                button("Main Menu", "menu");
            }

            @Override
            protected void result(final Object object) {
                if (object.toString() == "con") {
                    //hide();
                    System.out.println("play again");
                } else {
                    System.out.println("main menu");
                }
            }

        }.show(stage2);
    }

    //	public static class ExitDialog extends Dialog {
    //
    //		public ExitDialog(String title, Skin skin, String windowStyleName) {
    //			super(title, skin, windowStyleName);
    //		}
    //
    //		public ExitDialog(String title, Skin skin) {
    //			super(title, skin);
    //		}
    //
    //		public ExitDialog(String title, WindowStyle windowStyle) {
    //			super(title, windowStyle);
    //		}
    //
    //		{
    //			text("Do you really want to leave?");
    //			button("Yes", "See you next time!");
    //			button("No", "Enjoy your stay :)");
    //		}
    //
    //		@Override
    //		protected void result(Object object) {
    //			System.out.println(object);
    //		}
    //
    //	}

    @Override
    public void resize(int width, int height) {
        //stage.setViewport(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
