package com.nucleus.Views.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Utils.Assets;

/**
 * Created by Quaxi on 24/05/16.
 */
public class PauseViewable implements IViewable {
    private Texture pause;

    public PauseViewable(){
        this.pause = Assets.getTexture(NAssetsData.PAUSE);
        pause.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(pause, Gdx.graphics.getWidth() - pause.getWidth() -10, Gdx.graphics.getHeight() - pause.getHeight() -10);
        batch.end();
    }
}
