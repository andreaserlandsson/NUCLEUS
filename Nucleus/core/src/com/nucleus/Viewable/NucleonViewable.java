package com.nucleus.Viewable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Material;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.Proton;
import com.nucleus.Model.Vector;

import java.util.List;

/**
 * Created by erik on 28/04/16.
 */
public class NucleonViewable implements IViewable {

    private List<INucleon> nucleons;
    private Texture proton, neutron, smallTrailProton;
    private TextureRegion smallTrail;

    public NucleonViewable(List<INucleon> nucleons){

        this.nucleons = nucleons;

        smallTrailProton = new Texture("tailProton1.png");
        smallTrail = new TextureRegion(smallTrailProton, smallTrailProton.getWidth(), smallTrailProton.getHeight());

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
                float x = nucleon.getPosition().getX() - proton.getWidth() / 2;
                float y = nucleon.getPosition().getY() - proton.getHeight() / 2;
                batch.draw(proton, x, y);
                batch.draw(smallTrail,
                        x + proton.getWidth() /2,
                        y + proton.getHeight() /2,
                        proton.getWidth() / 2,
                        proton.getHeight() / 2,
                        smallTrailProton.getWidth(),
                        smallTrailProton.getHeight(),
                        1.0f,
                        1.0f,
                        vectorToRadians(nucleon.getVelocity()));

            }
            else{
                float x = nucleon.getPosition().getX() - proton.getWidth() / 2;
                float y = nucleon.getPosition().getY() - proton.getHeight() / 2;
                batch.draw(neutron, x,  y);

            }
        }
        batch.end();
    }


}
