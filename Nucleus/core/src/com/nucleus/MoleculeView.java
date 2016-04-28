package com.nucleus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by erik on 28/04/16.
 */
public class MoleculeView implements View{
    private Texture moleculeTexture;
    IMolecule molecule;

    //TODO: add support for loading different level textures
    public MoleculeView(IMolecule molecule){
        this.molecule = molecule;
        this.moleculeTexture = new Texture("1.png");
    }
    public void render(SpriteBatch batch){
        batch.begin();
        batch.draw(moleculeTexture, Gdx.graphics.getWidth() / 2 - moleculeTexture.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - moleculeTexture.getHeight() / 2);
        batch.end();
    }
}
