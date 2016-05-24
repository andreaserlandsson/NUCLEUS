package com.nucleus.Views.libGDXMusic;

/**
 * Created by paki on 5/24/16.
 */
public interface INMusicPlayer {
    void loadMusic();
    void playMusic(String song);
    void stopMusic();
    void playSound(String sound);
    void switchSong(String newSong);
    void pauseMusic();
    void resumeMusic();
    void setMasterVolume(float volume);
    float getMasterVolume();
}
