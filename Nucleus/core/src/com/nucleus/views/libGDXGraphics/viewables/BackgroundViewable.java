package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.assetHandler.Assets;

public class BackgroundViewable implements IViewable {
    private Texture bg;

    /**
     * Sets the BackgroundViewable with corresponding image.
     */
    public BackgroundViewable(){
        this.bg = Assets.getTexture(NAssetsData.BACKGROUND);
    }

    /**
     * Renders the background.
     * @param batch The batch that renders all sprite's.
     */
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }
}
