package com.nucleus.Views;

import com.badlogic.gdx.audio.Music;

public class NMusicPlayer {
    private static Music currentlyPlaying;

    public void loadMusic(){
        Assets.loadMusicFiles();
    }

    public void playMusic(String str, float volume) {
        Music music = Assets.getSong(str);
        if (music != null) {
            music.setVolume(volume);
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

    public void switchSong(String newSong, float volume) {
        Music music = Assets.getSong(newSong);
        if (music != null) {
            if (currentlyPlaying != null) {
                currentlyPlaying.stop();
            }
            music.play();
            music.setVolume(volume);
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




}
