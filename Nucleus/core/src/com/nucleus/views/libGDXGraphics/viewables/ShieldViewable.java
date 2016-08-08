package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.assetHandler.Assets;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.assetHandler.Text;
import com.nucleus.model.level.IShield;

/**
 * Created by andreaserlandsson on 08/08/16.
 */
public class ShieldViewable implements IViewable {
    private Texture shieldTextu;
    private Texture shieldCircleTextu;
    private IShield shield;

    /**
     * Creates a PauseViewable with the correct textures
     */
    public ShieldViewable(IShield shield){
        this.shield = shield;
        this.shieldTextu = Assets.getTexture(NAssetsData.SHIELD);
        this.shieldCircleTextu = Assets.getTexture(NAssetsData.SHIELDCIRCLE);
        shieldTextu.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    /**
     * Renders the pause button
     * @param batch The batch to be rendered
     */
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        BitmapFont font = new BitmapFont(Gdx.files.internal("menu/default.fnt"), false);

        batch.draw(shieldTextu, Gdx.graphics.getWidth()/2 - 10, Gdx.graphics.getHeight() - 40);

        //this is the amount of charges of the shield left in a white color
        font.setColor(255/255f, 255/255f, 255/255f, 1f);
        font.draw(batch, Integer.toString(shield.getCharge()),
                Gdx.graphics.getWidth()/2 + 20, Gdx.graphics.getHeight()-20);

        if (shield.getCap() != 0) {
            batch.draw(shieldCircleTextu, Gdx.graphics.getWidth()/2 - 120 , Gdx.graphics.getHeight()/2 - 120);

            //this is the amount of capacity of the shield left in a grey color
            font.setColor(200/255f, 200/255f, 200/255f, 1f);
            font.draw(batch, Integer.toString(shield.getCap()),
                    Gdx.graphics.getWidth()/2 + 40, Gdx.graphics.getHeight()-20);

        }
        batch.end();

    }
}
