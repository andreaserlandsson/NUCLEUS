package com.nucleus.Viewable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.INucleon;
import com.nucleus.Model.Proton;

import java.util.List;

/**
 * Created by erik on 28/04/16.
 */
public class NucleonViewable implements IViewable {

    private List<INucleon> nucleons;
    private Texture proton, neutron;

    public NucleonViewable(List<INucleon> nucleons){
        this.nucleons = nucleons;
        proton = new Texture("proton.png");
        proton.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        neutron = new Texture("neutron.png");
        neutron.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    }

    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.enableBlending();
        for(INucleon nucleon : nucleons){
            if (nucleon.getClass() == Proton.class){
                batch.draw(proton, nucleon.getPosition().getX() - proton.getWidth() / 2, nucleon.getPosition().getY() - proton.getHeight() / 2);
            }
            else{
                batch.draw(neutron, nucleon.getPosition().getX() - proton.getWidth() / 2, nucleon.getPosition().getY() - proton.getHeight() / 2);
            }
        }
        batch.end();
    }


}
