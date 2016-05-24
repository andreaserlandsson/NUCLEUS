package com.nucleus.Views.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.Assets;

/**
 * Created by erik on 28/04/16.
 */
public class MoleculeViewable implements IViewableRotateble {
    private Texture moleculeTexture, halfProton, halfNeutron, halfProtonComplete, halfNeutronComplete;
    private TextureRegion moleculeTextureRegion;
    private IGluonPoint[] gluonPoints;
    private final String rotationRequirement = "Molecule";

    //TODO: add support for loading different level textures
    public MoleculeViewable(int levelNumber, IMolecule molecule){
        gluonPoints = molecule.getGluons();
        loadTextures(levelNumber);
    }

    private void drawGluons(SpriteBatch batch){
        for (IGluonPoint gluonPoint : gluonPoints) {
            if (gluonPoint.getNeutronsNeeded() > 0){
                float sizeFactor = (float)gluonPoint.getCurrentNeutrons()/(float)gluonPoint.getMaxNeutrons();
                float x = gluonPoint.getPosition().getX()-halfNeutron.getWidth()/2*sizeFactor+5*sizeFactor;
                float y = gluonPoint.getPosition().getY()-halfNeutron.getHeight()/2*sizeFactor-1*sizeFactor;
                batch.draw(halfNeutron, x, y, halfNeutron.getWidth()*sizeFactor,
                        halfNeutron.getHeight()*sizeFactor);
            }
            else if (gluonPoint.getNeutronsNeeded()==0){
                float x = gluonPoint.getPosition().getX()-halfNeutronComplete.getWidth()/2+5;
                float y = gluonPoint.getPosition().getY()-halfNeutronComplete.getHeight()/2-1;
                batch.draw(halfNeutronComplete, x, y);
            }
            if (gluonPoint.getProtonsNeeded() > 0){
                float sizeFactor = (float)gluonPoint.getCurrentProtons()/(float)gluonPoint.getMaxProtons();
                float x = gluonPoint.getPosition().getX()-halfProton.getWidth()/2*sizeFactor-5*sizeFactor;
                float y = gluonPoint.getPosition().getY()-halfProton.getHeight()/2*sizeFactor-1*sizeFactor;
                batch.draw(halfProton, x, y, halfProton.getWidth() * sizeFactor,
                        halfProton.getHeight() *sizeFactor);

            }
            else if (gluonPoint.getProtonsNeeded()==0){
                float x = gluonPoint.getPosition().getX()-halfProtonComplete.getWidth()/2-5;
                float y = gluonPoint.getPosition().getY()-halfProtonComplete.getHeight()/2-1;
                batch.draw(halfProtonComplete, x, y);
            }
        }
    }

    public void render(SpriteBatch batch, float rotation){
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
                rotation);

        drawGluons(batch);

        batch.end();
    }

    @Override
    public String getRotationRequirement() {
        return rotationRequirement;
    }


    private void loadTextures(int levelNumber){
        this.moleculeTexture = Assets.getTexture(NAssetsData.getLevel(levelNumber));
        moleculeTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.moleculeTextureRegion = new TextureRegion(moleculeTexture, moleculeTexture.getWidth(), moleculeTexture.getHeight());
        this.halfProton = Assets.getTexture(NAssetsData.PROTONHALF);
        halfProton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfNeutron = Assets.getTexture(NAssetsData.NEUTRONHALF);
        halfNeutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfProtonComplete = Assets.getTexture(NAssetsData.PROTONHALFCOMPLETE);
        halfProtonComplete.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfNeutronComplete = Assets.getTexture(NAssetsData.NEUTRONHALFCOMPLETE);
        halfNeutronComplete.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
}
