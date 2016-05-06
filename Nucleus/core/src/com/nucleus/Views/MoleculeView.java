package com.nucleus.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by erik on 28/04/16.
 */
public class MoleculeView implements IView {
    private Texture moleculeTexture;
    private TextureRegion moleculeTextureRegion;
    com.nucleus.Model.IMolecule molecule;

    //TODO: add support for loading different level textures
    public MoleculeView(com.nucleus.Model.IMolecule molecule){
        this.molecule = molecule;
        this.moleculeTexture = new Texture("1.png");
        this.moleculeTextureRegion = new TextureRegion(moleculeTexture, moleculeTexture.getWidth(), moleculeTexture.getHeight());
    }
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(moleculeTextureRegion,
                Gdx.graphics.getWidth() / 2 - moleculeTexture.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - moleculeTexture.getHeight() / 2,
                Gdx.graphics.getWidth() / 2 - moleculeTexture.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - moleculeTexture.getHeight() / 2,
                moleculeTexture.getWidth(),
                moleculeTexture.getHeight(),
                1.0f,
                1.0f,
                45.0f);
        batch.end();
    }
}
