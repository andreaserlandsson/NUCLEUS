package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;


/**
 * Created by andreaserlandsson on 17/05/16.
 */

public class WinDialog extends WinLoseDialog {
    private SpriteBatch batch;
    private ILevel level;
    private EventListener listener;
    private INMusicPlayer musicPlayer;
    public WinDialog(SpriteBatch batch, ILevel level, EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.WINSOUND);
        this.listener = listener;
        this.batch = batch;
        this.level = level;
        this.title = "You Won";

    }

}
