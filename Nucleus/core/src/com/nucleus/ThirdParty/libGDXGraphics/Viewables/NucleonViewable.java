package com.nucleus.ThirdParty.libGDXGraphics.Viewables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.Proton;
import com.nucleus.Model.Vector;

import java.util.List;

/**
 * Created by erik on 28/04/16.
 */
public class NucleonViewable implements IViewable {

    private List<INucleon> nucleons;
    private Texture proton, neutron, protonLargeTrail, neutronLargeTrail;
    private TextureRegion protonLargeTrailRegion, neutronLargeTrailRegion;

    public NucleonViewable(List<INucleon> nucleons){

        this.nucleons = nucleons;

        //Adding textures
        proton = new Texture("graphics/proton.png");
        neutron = new Texture("graphics/neutron.png");
        protonLargeTrail = new Texture("graphics/tailProton2.png");
        neutronLargeTrail = new Texture("graphics/tailNeutron2.png");

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

        for(INucleon nucleon : nucleons){
            if (nucleon.getClass() == Proton.class){
                float x = nucleon.getPosition().getX();
                float y = nucleon.getPosition().getY();
                batch.draw(proton, x  - nucleon.getRadius(),y  - nucleon.getRadius());
                batch.draw(protonLargeTrailRegion,
                        //TODO fix 2px offset
                        x-1,
                        y + nucleon.getRadius() - 1,
                        (float) (nucleon.getRadius() + 0.5),
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
                batch.draw(neutron, x - nucleon.getRadius(),  y - nucleon.getRadius());
                batch.draw(neutronLargeTrailRegion,
                        //TODO fix 2px offset
                        x-1,
                        y + nucleon.getRadius() - 1,
                        (float) (nucleon.getRadius() + 0.5),
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
