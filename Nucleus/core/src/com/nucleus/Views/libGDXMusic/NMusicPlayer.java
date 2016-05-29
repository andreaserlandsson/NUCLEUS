package com.nucleus.Views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.AssetHandler.Assets;

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

        // Plays the String by getting the correspondent Music file from the assetmManager.
        // Sets the volume to the mastervolume, and set an infinite loop.
        // Sets the currentPlaying to be the song playing, to easier track the current song.
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

        //Switches the current song to the new song. If the current song is the new song,
        // do nothing
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

        //Sets the masterVolume for all the music. Used to mute or unmute the sound.
    public void setMasterVolume(float volume) {
        masterVolume = volume;
        currentlyPlaying.setVolume(masterVolume);
    }

    public float getMasterVolume(){
        return masterVolume;
    }
}
