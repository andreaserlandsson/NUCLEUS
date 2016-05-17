package com.nucleus.ThirdParty.libGDXGraphics.Viewables;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by mirandabannsgard on 16-05-17.
 */
public class CountdownViewable implements IViewable {
    private Texture protonInGun;
    private Texture neutronInGun;

    public CountdownViewable(){
        this.protonInGun = new Texture("graphics/proton.png");
        this.neutronInGun = new Texture("graphics/neutron.png");
    }



    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
        batch.draw(protonInGun,10,10,30,30);
        batch.draw(neutronInGun,10,40,30,30);

        batch.end();


    }
}
