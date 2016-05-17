package com.nucleus.ThirdParty.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.INucleonGun;

/**
 * Created by mirandabannsgard on 16-05-17.
 */
public class CountdownViewable implements IViewable {
    private Texture protonInGun;
    private Texture neutronInGun;
    private BitmapFont font;
    private INucleonGun gun;


    public CountdownViewable(INucleonGun gun){
        this.protonInGun = new Texture("graphics/proton.png");
        this.neutronInGun = new Texture("graphics/neutron.png");
        this.gun = gun;
    }



    @Override
    public void render(SpriteBatch batch) {

        batch.begin();
        font = new BitmapFont(Gdx.files.internal("menu/default.fnt"), true);
        //font.setColor(Color.WHITE);

        batch.draw(protonInGun,10,10,30,30);
        batch.draw(neutronInGun,10,40,30,30);

        //font.setColor(255, 40, 50, 1);
        font.draw(batch, Integer.toString(gun.getProtonsInGun()),45,18);
        //font.setColor(18, 210, 150, 50);
        font.draw(batch, Integer.toString(gun.getNeutronsInGun()),45,48);

        batch.end();


    }

}
