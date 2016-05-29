package com.nucleus.views.libGDXGraphics.dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;

public class LoseDialog extends WinLoseDialog {

    private INMusicPlayer musicPlayer;

    /**
     * Creates a new loseDialog with a title, a new song, and a listener.
     * @param listener the listener for the dialog.
     */
    public LoseDialog(EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.LOSESOUND);
        this.title = "You Lost";

    }

}
