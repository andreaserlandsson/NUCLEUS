package com.nucleus.Views.libGDXGraphics.Dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.AssetHandler.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by andreaserlandsson on 17/05/16.
 */
public class WinDialog extends WinLoseDialog {

    private INMusicPlayer musicPlayer;

    /**
     * This constructor builds a WinDialog (extends WinLoseDialog) object with the correct listener
     */
    public WinDialog(EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.WINSOUND);
        //this changes the printed text to "You Won"
        this.title = "You Won";

    }

}
