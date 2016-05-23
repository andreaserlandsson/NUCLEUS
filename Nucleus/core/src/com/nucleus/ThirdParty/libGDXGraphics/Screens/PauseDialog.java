package com.nucleus.ThirdParty.libGDXGraphics.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.nucleus.Controller.MenuController;
import com.nucleus.Model.ILevel;
import com.nucleus.ThirdParty.libGDXControllers.NInputAdapter;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class PauseDialog extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage stage2;
    protected Skin skin;
    private ILevel level;


    public PauseDialog( SpriteBatch batch, ILevel level){
        this.batch = batch;
        stage2 = new Stage();
        this.level = level;

    }

    @Override
    public void show() {


        Gdx.input.setInputProcessor(stage2);
        skin = new Skin(Gdx.files.internal("menu/uiskin.json"));


        new Dialog("PAUSED", skin) {


            { //these brackets works as a "universal-constructor" (or what ever it is called)

                getButtonTable().row();
                button("Continue Playing", "continue"); //this button calls on the result-method with the object "continue"
                getButtonTable().row();
                button("Restart Level", "restart");        //this button calls on the result-method with the object "menu"
                getButtonTable().row();
                button("Main Menu", "menu");            //this button calls on the result-method with the object "menu"

                setMovable(false);

            }

            @Override
            protected void result(final Object object) {
                if (object.equals("continue")) {

                    System.out.println("continue");
                    dispose();
                    level.resume();
                    Gdx.input.setInputProcessor(new NInputAdapter(level)); //changes back to the game input processor

                } else if (object.equals("menu")) {

                    System.out.println("main menu");
                    MenuController controller = new MenuController();
                    controller.goToStartScreen();

                } else if (object.equals("restart")) {

                    System.out.println("restart");
                    MenuController controller = new MenuController();
                    controller.changeLevel(level.getLevelNumber());

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
