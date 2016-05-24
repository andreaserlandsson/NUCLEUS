package com.nucleus.Views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.Views.Assets;

public class NMusicPlayer {
    private static Music currentlyPlaying;
    private static float masterVolume = 1;

    public void loadMusic(){
        Assets.loadMusicFiles();
    }

    public void playMusic(String str) {
        Music music = Assets.getSong(str);
        if (music != null) {
            music.setVolume(masterVolume);
            music.play();
            music.setLooping(true);
            currentlyPlaying = music;
        }
    }

    public void stopMusic(String str) {
        Music music = Assets.getSong(str);
        if (music != null) {
            music.stop();
            currentlyPlaying = null;
        }
    }

    public void playSound(String str) {
        Music music = Assets.getSong(str);
        if (music != null) {
            music.play();
        }
    }

    public void switchSong(String newSong) {
        Music music = Assets.getSong(newSong);
        if (music != null) {
            if (currentlyPlaying != null) {
                currentlyPlaying.stop();
            }
            music.play();
            music.setVolume(masterVolume);
        }
    }

    public void pauseMusic(String song) {
        Music music = Assets.getSong(song);
        if (music != null) {
            music.pause();
        }
    }

    public void resumeMusic(String song) {
        Music music = Assets.getSong(song);
        if (music != null){
            music.pause();
        }
    }

    public void setMasterVolume(float volume) {
        masterVolume = volume;
    }




}
