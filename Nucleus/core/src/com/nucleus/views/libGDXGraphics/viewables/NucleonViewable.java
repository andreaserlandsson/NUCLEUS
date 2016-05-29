package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.assetHandler.Assets;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.model.collision.Vector;
import com.nucleus.model.particles.INucleon;
import com.nucleus.model.particles.Proton;

import java.util.List;

public class NucleonViewable implements IViewable {

    private List<INucleon> nucleons;
    private Texture proton, neutron, protonLargeTrail, neutronLargeTrail;
    private TextureRegion protonLargeTrailRegion, neutronLargeTrailRegion;

    public NucleonViewable(List<INucleon> nucleons){

        this.nucleons = nucleons;


        //Adding textures
        proton = Assets.getTexture(NAssetsData.PROTON);
        neutron = Assets.getTexture(NAssetsData.NEUTRON);
        protonLargeTrail = Assets.getTexture(NAssetsData.TAILPROTON2) ;
        neutronLargeTrail = Assets.getTexture(NAssetsData.TAILNEUTRON2);

        //Adding filters
        protonLargeTrail.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapLinearNearest);
        neutronLargeTrail.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.MipMapLinearNearest);
        proton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        neutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        //Fitting rotated textures into TextureRegions
        protonLargeTrailRegion = new TextureRegion(protonLargeTrail, protonLargeTrail.getWidth(), protonLargeTrail.getHeight());
        neutronLargeTrailRegion = new TextureRegion(neutronLargeTrail, neutronLargeTrail.getWidth(), neutronLargeTrail.getHeight());

    }

    private int vectorToRadians(Vector v){

        double angle = Math.atan2(v.getY(), v.getX());
        double degrees = 180*angle/Math.PI;
        return (int) (90+Math.round(degrees))%360;

    }


    @Override
    public void render(SpriteBatch batch){

        batch.begin();
        batch.enableBlending();
        final int PICOFFSET =1;  //Variable compensating for asymmetrical graphic assets
        for(INucleon nucleon : nucleons){
            if (nucleon.getClass() == Proton.class){
                float x = nucleon.getPosition().getX();
                float y = nucleon.getPosition().getY();
                batch.draw(proton, x  - 2*nucleon.getRadius(),y  - 2*nucleon.getRadius());
                batch.draw(protonLargeTrailRegion,
                        x - nucleon.getRadius()-PICOFFSET,
                        y - PICOFFSET,
                        (float) (nucleon.getRadius()),
                        0,
                        protonLargeTrail.getWidth(),
                        protonLargeTrail.getHeight(),
                        1.0f,
                        1.0f,
                       vectorToRadians(nucleon.getVelocity()));

            }
            else{
                float x = nucleon.getPosition().getX();
                float y = nucleon.getPosition().getY();
                batch.draw(neutron, x - 2*nucleon.getRadius(),  y - 2*nucleon.getRadius());
                batch.draw(neutronLargeTrailRegion,
                        x - nucleon.getRadius(),
                        y - PICOFFSET,
                        (float) (nucleon.getRadius()),
                        0,
                        neutronLargeTrail.getWidth(),
                        neutronLargeTrail.getHeight(),
                        1.0f,
                        1.0f,
                       vectorToRadians(nucleon.getVelocity()));
            }
        }
        batch.end();
    }


}
