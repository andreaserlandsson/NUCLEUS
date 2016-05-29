package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.assetHandler.Assets;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.model.molecule.IGluonPoint;
import com.nucleus.model.molecule.IMolecule;

public class MoleculeViewable implements IViewable {
    private IMolecule molecule;
    private Texture moleculeTexture, halfProton, halfNeutron, halfProtonComplete, halfNeutronComplete;
    private TextureRegion moleculeTextureRegion;
    private IGluonPoint[] gluonPoints;

    public MoleculeViewable(int levelNumber, IMolecule molecule){
        gluonPoints = molecule.getGluons();
        this.molecule = molecule;
        loadTextures(levelNumber);
    }

    /**
     * Fills the the gluon points with color. Depending on how many more protons the gluon needs the
     * left half will be filled with color scaled to this. Same thing on the right half only for neutrons
     * instead.

     * @param batch The images to be rendered.
     */
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

    /**
     * Renders the molecule according to the progress and position for each gluon point.
     * @param batch The batch that renders all sprite's.
     */
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

    /**
     * Sets the correct textures for the molecule and the corresponding gluonpoints.
     * @param levelNumber The levelnumber needed to locate the correct textures.
     */
    private void loadTextures(int levelNumber){
        this.moleculeTexture = Assets.getTexture(NAssetsData.getLevelPicture(levelNumber));
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
