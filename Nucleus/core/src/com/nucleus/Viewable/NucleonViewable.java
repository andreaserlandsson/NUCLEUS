package com.nucleus.Viewable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.INucleon;

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
    }

    //TODO: implement something to differentiate between protons and Nucleons
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.enableBlending();
        for(INucleon nucleon : nucleons){
            batch.draw(proton, nucleon.getPosition().getX() - proton.getWidth() / 2, nucleon.getPosition().getY() - proton.getHeight() / 2);
        }
        batch.end();
    }


}
