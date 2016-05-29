package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.assetHandler.Assets;

public class PauseViewable implements IViewable {
    private Texture pause;

    /**
     * Loads this PauseViewable with its textures
     */
    public PauseViewable(){
        this.pause = Assets.getTexture(NAssetsData.PAUSE);
        pause.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    /**
     * Redraws the pause button
     *
     * @param batch
     */
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(pause, Gdx.graphics.getWidth() - pause.getWidth() -10, Gdx.graphics.getHeight() - pause.getHeight() -10);
        batch.end();
    }
}
