package com.nucleus.Views;

import com.nucleus.Adapters.Graphics.GraphicsAdapter;
import com.nucleus.ThirdParty.libGDXGraphics.Viewables.IViewable;

/**
 * Created by Quaxi on 11/05/16.
 */
public class GameView {

    private GraphicsAdapter adapter;
    private IViewable moleculeViewable, nucleonViewable, backgroundViewable;
    private String backgroundTexture, hydrogenTexture, protonTexture, neutronTexture, neutronTailMedium, protonTailMedium;

    public GameView() {
        backgroundTexture = "bg.png";
        hydrogenTexture = "1.png";
        protonTexture = "proton.png";
        neutronTexture = "neutronTexture.png";
        neutronTailMedium = "tailNeutron2.png";
        protonTailMedium = "tailProton2.png";

    }

    public void draw(String texturePath, float x, float y){
        adapter.draw(texturePath, x, y);


    }

}
