package com.nucleus.Viewable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
        moleculeTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfProton = new Texture("protonHalf.png");
        halfProton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfNeutron = new Texture("neutronHalf.png");
        halfNeutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.moleculeTextureRegion = new TextureRegion(moleculeTexture, moleculeTexture.getWidth(), moleculeTexture.getHeight());
        this.gluonPoints = molecule.getGluons();
    }

    private void drawGluons(SpriteBatch batch){
        for (IGluonPoint gluonPoint : gluonPoints) {

            if (gluonPoint.getNeutronsNeeded() <= 0){
                float x = gluonPoint.getPosition().getX()-halfNeutron.getWidth()/2+5;
                float y = gluonPoint.getPosition().getY()-halfNeutron.getHeight()/2-1;
                batch.draw(halfNeutron, x, y);
            }

            if (gluonPoint.getProtonsNeeded() <= 0){
                float x = gluonPoint.getPosition().getX()-halfProton.getWidth()/2-5;
                float y = gluonPoint.getPosition().getY()-halfProton.getHeight()/2-1;
                batch.draw(halfProton, x, y);
            }
        }
    }

    public void render(SpriteBatch batch){
        batch.begin();

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

        drawGluons(batch);

        batch.end();
    }
}
