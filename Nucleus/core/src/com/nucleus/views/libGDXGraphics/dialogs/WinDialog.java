package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;

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
