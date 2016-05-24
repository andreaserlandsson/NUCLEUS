package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.nucleus.Views.libGDXGraphics.Viewables.BackgroundViewable;
import com.nucleus.Views.libGDXGraphics.Viewables.IViewable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erik on 23/05/16.
 */
public class OptionsScreen implements Screen {

    private SpriteBatch batch;
    protected Stage stage;
    private Viewport viewport;
    private OrthographicCamera camera;
    protected Skin skin;
    private ClickListener listener;
    private List<IViewable> views = new ArrayList<IViewable>();

    public OptionsScreen(){
        views.add(new BackgroundViewable());

    }

    @Override
    public void render(float delta){

    }

    @Override
    public void show(){
        Gdx.app.log("OptionsScreen", "showing");
        TextButton toggleSoundBtn = new TextButton("Toggle Sound", skin);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("OptionsScreen", "resizing");

    }

    @Override
    public void hide(){
        Gdx.app.log("OptionsScreen", "hiding");
    }

    @Override
    public void pause(){
        Gdx.app.log("OptionsScreen", "pausing");
    }

    @Override
    public void resume(){
        Gdx.app.log("OptionsScreen", "resuming");
    }

    @Override
    public void dispose() {
        // Leave blank
    }
}
