package com.nucleus.Views.libGDXGraphics.Dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

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
