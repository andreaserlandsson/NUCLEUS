package com.nucleus.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erik on 28/04/16.
 */
public class BackgroundView implements IView {
    private Texture bg;

    public BackgroundView(){
        this.bg = new Texture("bg.png");
    }
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }
}
