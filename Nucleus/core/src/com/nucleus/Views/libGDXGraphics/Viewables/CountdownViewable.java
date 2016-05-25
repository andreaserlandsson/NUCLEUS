package com.nucleus.Views.libGDXGraphics.Viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.Model.INucleonGun;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Utils.Assets;

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

        batch.draw(protonInGun,10,Gdx.graphics.getHeight() - protonInGun.getHeight(),30,30);
        batch.draw(neutronInGun,10,Gdx.graphics.getHeight() - neutronInGun.getHeight()-30,30,30);


        font.setColor(247/255f, 157/255f, 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getProtonsInGun()),
                45, Gdx.graphics.getHeight() - protonInGun.getHeight());

        font.setColor(158/255f,210/255f , 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getNeutronsInGun()),
                45, Gdx.graphics.getHeight() - protonInGun.getHeight() - 30);

        batch.end();


    }

}
