package com.nucleus.views.libGDXMusic;


    /** Interface for the MusicPlayer. Makes it possible to easy switch out the libGDX musicPlayer
     *  for another one.
     */
public interface INMusicPlayer {
    void loadMusic();
    void playMusic(String song);
    void stopMusic();
    void playSound(String sound);
    void switchSong(String newSong);
    void setMasterVolume(float volume);
    float getMasterVolume();
    String getSoundOff();
}
