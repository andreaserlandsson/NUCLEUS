package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;

/**
 * Created by andreaserlandsson on 24/05/16.
 */
public class LoseDialog extends WinLoseDialog {

    private INMusicPlayer musicPlayer;

    /**
     * This constructor builds a LoseDialog (extends WinLoseDialog) object with the correct listener
     */
    public LoseDialog(EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.LOSESOUND);
        //this changes the printed text to "You Lost"
        this.title = "You Lost";

    }

}
