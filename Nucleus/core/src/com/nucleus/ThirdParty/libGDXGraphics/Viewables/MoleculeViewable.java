package com.nucleus.ThirdParty.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.Model.IGluonPoint;
import com.nucleus.Model.IMolecule;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.Assets;

import javax.print.attribute.standard.MediaSize;

/**
 * Created by erik on 28/04/16.
 */
public class MoleculeViewable implements IViewable {
    private Texture moleculeTexture, halfProton, halfNeutron, halfProtonComplete, halfNeutronComplete;
    private TextureRegion moleculeTextureRegion;
    private IMolecule molecule;
    private IGluonPoint[] gluonPoints;

    //TODO: add support for loading different level textures
    public MoleculeViewable(int levelNumber, IMolecule molecule){
        this.molecule = molecule;
        this.gluonPoints = molecule.getGluons();
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

    private void loadTextures(int levelNumber){
        this.moleculeTexture = new Texture("levels/"+Integer.toString(levelNumber)+".png");
        moleculeTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.moleculeTextureRegion = new TextureRegion(moleculeTexture, moleculeTexture.getWidth(), moleculeTexture.getHeight());
        this.halfProton = Assets.getTexture(NAssetsData.PROTONHALF);
        halfProton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfNeutron = Assets.getTexture(NAssetsData.NEUTRONHALF) ;//new Texture("graphics/neutronHalf.png");
        halfNeutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfProtonComplete = Assets.getTexture(NAssetsData.PROTONHALFCOMPLETE);//)new Texture("graphics/protonHalfComplete.png");
        halfProtonComplete.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        this.halfNeutronComplete = Assets.getTexture(NAssetsData.NEUTRONHALFCOMPLETE);//new Texture("graphics/neutronHalfComplete.png");
        halfNeutronComplete.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }
}
