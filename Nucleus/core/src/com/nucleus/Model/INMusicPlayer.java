package com.nucleus.Model;


public interface INMusicPlayer {
    void playLoop(String song, float volume);
    void playSound(String song);
    void changeMusic(String newSong, String oldSong, float volume);
    void pauseMusic(String song);
    void resumeMusic(String song);
    void stopMusic(String song);
}
