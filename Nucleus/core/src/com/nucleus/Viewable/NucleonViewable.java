package com.nucleus.Viewable;

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

        protonLargeTrail = new Texture("tailProton1.png");
        protonLargeTrail.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        protonLargeTrailRegion = new TextureRegion(protonLargeTrail, protonLargeTrail.getWidth(), protonLargeTrail.getHeight());

        neutronLargeTrail = new Texture("tailNeutron1.png");
        neutronLargeTrail.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        neutronLargeTrailRegion = new TextureRegion(neutronLargeTrail, neutronLargeTrail.getWidth(), neutronLargeTrail.getHeight());

        proton = new Texture("proton.png");
        proton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        neutron = new Texture("neutron.png");
        neutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
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
                        x-2,
                        y + nucleon.getRadius(),
                        nucleon.getRadius(),
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
                        x-2,
                        y + nucleon.getRadius(),
                        nucleon.getRadius(),
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
