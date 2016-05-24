package com.nucleus.Views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.Views.Assets;

public class NMusicPlayer implements INMusicPlayer {
    private static Music currentlyPlaying;
    private static float masterVolume = 1;
    private static INMusicPlayer instance;
    private static float soundEffectVolume = 0.6f;

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

    public void stopMusic() {
        if (currentlyPlaying != null) {
            currentlyPlaying.stop();
            currentlyPlaying = null;
        }
    }

    public void playSound(String str) {
        Music music = Assets.getSong(str);
        if (music != null) {
            if (soundEffectVolume<masterVolume) {
                music.setVolume(soundEffectVolume);
            } else {
                music.setVolume(masterVolume);
            }
            music.play();
        }
    }

    public void switchSong(String newSong) {
        Music music = Assets.getSong(newSong);
        if (music != null) {
            if (currentlyPlaying != null) {
                currentlyPlaying.stop();
            }
            music.setVolume(masterVolume);
            music.play();
            currentlyPlaying = music;
        }
    }

    public void pauseMusic() {
        if (currentlyPlaying != null) {
            currentlyPlaying.pause();
        }
    }

    public void resumeMusic() {
        if (currentlyPlaying != null){
            currentlyPlaying.play();
            currentlyPlaying.setVolume(masterVolume);
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
