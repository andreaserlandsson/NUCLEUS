package com.nucleus.Controller;

import com.nucleus.Model.MusicPlayerData;
import com.nucleus.ThirdParty.libGDXSounds.INMusicPlayerAdapter;
import com.nucleus.ThirdParty.libGDXSounds.NMusicPlayerAdapter;


public class MusicController {
    INMusicPlayerAdapter musicPlayer;

    public MusicController(){
        this.musicPlayer = NMusicPlayerAdapter.getInstance();
    }

    public void playLoop(String song, float volume) {
        musicPlayer.playSongLoop(song,volume);

    }

    public void playSound(String song) {
        musicPlayer.playSoundEffect(song);
    }

    public void changeMusic(String newSong, String oldSong, float volume) {
        musicPlayer.changeSong(newSong,oldSong,volume);
    }
    public void pauseMusic(String song) {
        musicPlayer.pauseSong(song);
    }
    public void resumeMusic(String song) {
        musicPlayer.resumeSong(song);
    }
    public void stopMusic(String song) {
        musicPlayer.stopSong(song);
    }


}
