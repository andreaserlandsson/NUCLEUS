package com.nucleus.ThirdParty.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.Assets;

/**
 * Created by mirandabannsgard on 16-05-17.
 */
public class CountdownViewable implements IViewable {
    private Texture protonInGun;
    private Texture neutronInGun;
    private BitmapFont font;
    private INucleonGun gun;


    public CountdownViewable(INucleonGun gun){
        this.protonInGun = Assets.getTexture(NAssetsData.PROTON);//new Texture("graphics/proton.png");
        this.neutronInGun = Assets.getTexture(NAssetsData.NEUTRON);//new Texture("graphics/neutron.png");
        protonInGun.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        neutronInGun.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        this.gun = gun;
    }



    @Override
    public void render(SpriteBatch batch) {

        batch.begin();
        font = new BitmapFont(Gdx.files.internal("menu/default.fnt"), true);
        //font.setColor(Color.WHITE);

        batch.draw(protonInGun,10,10,30,30);
        batch.draw(neutronInGun,10,40,30,30);


        font.setColor(247/255f, 157/255f, 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getProtonsInGun()),45,18);

        font.setColor(158/255f,210/255f , 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getNeutronsInGun()),45,48);

        batch.end();


    }

}
