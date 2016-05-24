package com.nucleus.Views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.Views.Assets;

public class NMusicPlayer implements INMusicPlayer {
    private static Music currentlyPlaying;
    private static float masterVolume = 1;
    private static INMusicPlayer instance;

    private NMusicPlayer(){
        // private constructor to fulfill singleton requirements.
    }

    public static INMusicPlayer getInstance() {
        if (instance == null) {
            instance = new NMusicPlayer();
        }
        return instance;
    }
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
        currentlyPlaying.setVolume(masterVolume);
    }

    public float getMasterVolume(){
        return masterVolume;
    }
}
