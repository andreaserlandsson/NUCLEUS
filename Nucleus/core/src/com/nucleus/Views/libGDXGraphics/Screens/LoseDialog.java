package com.nucleus.Views.libGDXGraphics.Screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.nucleus.Model.ILevel;
import com.nucleus.Model.NAssetsData;
import com.nucleus.Views.libGDXMusic.INMusicPlayer;
import com.nucleus.Views.libGDXMusic.NMusicPlayer;

/**
 * Created by andreaserlandsson on 24/05/16.
 */
public class LoseDialog extends WinLoseDialog {

    private INMusicPlayer musicPlayer;

    public LoseDialog(SpriteBatch batch, ILevel level, EventListener listener) {
        super(listener);
        this.musicPlayer = NMusicPlayer.getInstance();
        musicPlayer.switchSong(NAssetsData.LOSESOUND);
        this.listener = listener;
        this.batch = batch;
        this.level = level;
        this.title = "You Lost";

    }

}
