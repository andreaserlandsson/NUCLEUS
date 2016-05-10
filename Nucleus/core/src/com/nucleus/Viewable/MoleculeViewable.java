package com.nucleus.Viewable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.Model.GluonPoint;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;

/**
 * Created by erik on 28/04/16.
 */
public class MoleculeViewable implements IViewable {
    private Texture moleculeTexture, halfProton, halfNeutron;
    private TextureRegion moleculeTextureRegion;
    private IMolecule molecule;
    private IGluonPoint[] gluonPoints;

    //TODO: add support for loading different level textures
    public MoleculeViewable(IMolecule molecule){
        this.molecule = molecule;
        this.moleculeTexture = new Texture("1.png");
        this.halfProton = new Texture("proton.png");
        this.moleculeTextureRegion = new TextureRegion(moleculeTexture, moleculeTexture.getWidth(), moleculeTexture.getHeight());
        this.gluonPoints = molecule.getGluons();
    }

    public void render(SpriteBatch batch){
        batch.begin();

        //batch.draw(halfProton, gluonPoints[0].getPosition().getY(), gluonPoints[0].getPosition().getX());

        batch.draw(moleculeTextureRegion,
                Gdx.graphics.getWidth() / 2 - moleculeTexture.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - moleculeTexture.getHeight() / 2,
                moleculeTexture.getWidth() / 2,
                moleculeTexture.getHeight() / 2,
                moleculeTexture.getWidth(),
                moleculeTexture.getHeight(),
                1.0f,
                1.0f,
                molecule.getRotation());
        batch.end();
    }
}
