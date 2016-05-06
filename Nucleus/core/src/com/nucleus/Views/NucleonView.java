package com.nucleus.Views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

/**
 * Created by erik on 28/04/16.
 */
public class NucleonView implements IView {

    private List<com.nucleus.Model.INucleon> nucleons;
    private Texture proton, neutron;

    public NucleonView(List<com.nucleus.Model.INucleon> nucleons){
        this.nucleons = nucleons;
        proton = new Texture("proton.png");
    }

    //TODO: implement something to differentiate between protons and Nucleons
    @Override
    public void render(SpriteBatch batch){
        batch.begin();
        batch.enableBlending();
        for(com.nucleus.Model.INucleon nucleon : nucleons){
            batch.draw(proton, nucleon.getPosition().getX() - proton.getWidth() / 2, nucleon.getPosition().getY() - proton.getHeight() / 2);
        }
        batch.end();
    }


}
