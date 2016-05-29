package com.nucleus.views.libGDXGraphics.Dialogs;

import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.assetHandler.NAssetsData;
import com.nucleus.views.libGDXMusic.INMusicPlayer;
import com.nucleus.views.libGDXMusic.NMusicPlayer;


/**
 * Created by andreaserlandsson on 17/05/16.
 */

public class WinDialog extends WinLoseDialog {

    private INMusicPlayer musicPlayer;
    public WinDialog(EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.WINSOUND);
        this.title = "You Won";

    }

}
