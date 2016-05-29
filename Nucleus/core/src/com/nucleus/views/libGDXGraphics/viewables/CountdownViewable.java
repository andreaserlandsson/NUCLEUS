package com.nucleus.views.libGDXGraphics.viewables;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nucleus.assetHandler.Assets;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.model.level.INucleonGun;

public class CountdownViewable implements IViewable {
    private Texture protonInGun;
    private Texture neutronInGun;
    private INucleonGun gun;

    /**
     * The view of the "ammo", i.e. the amount of protons and neutrons left in the nucleon gun in the
     * game view. The view is two different counters, one in red showing the amount of protons left and one in green
     * showing the amount of neutron left.
     * @param gun The gun of which the ammo is displayed.
     */
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
        BitmapFont font = new BitmapFont(Gdx.files.internal("menu/default.fnt"), false);

        //draws the pictures of the proton and the neutron
        batch.draw(protonInGun,10,Gdx.graphics.getHeight() - protonInGun.getHeight(),30,30);
        batch.draw(neutronInGun,10,Gdx.graphics.getHeight() - neutronInGun.getHeight()-30,30,30);

        //this is the amount of protons left in a red color
        font.setColor(247/255f, 157/255f, 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getProtonsInGun()),
                40, Gdx.graphics.getHeight()-13);

        //this the amount of neutrons left in a green color
        font.setColor(158/255f,210/255f , 150/255f, 1f);
        font.draw(batch, Integer.toString(gun.getNeutronsInGun()),
                40, Gdx.graphics.getHeight() - 43);

        batch.end();
    }

}
