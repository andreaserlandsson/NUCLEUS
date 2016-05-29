package com.nucleus.views.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.assetHandler.Assets;

/**
 * Created by erik on 28/04/16.
 */
public class BackgroundViewable implements IViewable {
    private Texture bg;

    public BackgroundViewable(){
        this.bg = Assets.getTexture(NAssetsData.BACKGROUND);
    }
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }
}
