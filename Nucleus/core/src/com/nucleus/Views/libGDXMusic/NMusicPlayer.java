package com.nucleus.Views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.Views.Assets;

    //Singleton class to prevent multiple instances.
public class NMusicPlayer implements INMusicPlayer {
    private static Music currentlyPlaying;
    private static float masterVolume = 1;
    private static INMusicPlayer instance;
    private static float soundEffectVolume = 0.6f;

    private NMusicPlayer(){
        // Private constructor to fulfill singleton requirements.
    }

        //Returns the same instance of the musicPlayer.
        //If no instance exists, create one.
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

        //Stops the current song from playing.
    public void stopMusic() {
        if (currentlyPlaying != null) {
            currentlyPlaying.stop();
            currentlyPlaying = null;
        }
    }

        //Plays a sound effect (eg. buttonClicked).
        //The sound will be lower than the masterVolume,
        //but if the sound is muted from options, there is no sound.
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

        //Switches the current song to the new song.
    public void switchSong(String newSong) {
        Music music = Assets.getSong(newSong);
        if (music != null) {

            music.setVolume(masterVolume);
            music.play();
            if (currentlyPlaying != null) {
                if (currentlyPlaying != music) {
                    currentlyPlaying.stop();
                }
            }
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

        //Sets the masterVolume for all the music. Used to mute or unmute the sound.
    public void setMasterVolume(float volume) {
        masterVolume = volume;
        currentlyPlaying.setVolume(masterVolume);
    }

        //get-Method used for the option to mute or unmute the sound.
    public float getMasterVolume(){
        return masterVolume;
    }
}
