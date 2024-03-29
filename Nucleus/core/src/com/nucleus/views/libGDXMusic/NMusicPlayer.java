package com.nucleus.views.libGDXMusic;

import com.badlogic.gdx.audio.Music;
import com.nucleus.assetHandler.Assets;

/**
 * Singleton class to prevent multiple instantiations and multiple musicPlayers.
 */
public class NMusicPlayer implements INMusicPlayer {
    private static Music currentlyPlaying;
    private static float masterVolume = 1;
    private static INMusicPlayer instance;


    /**
     * private constructor to defeat instantiation.
     */
    private NMusicPlayer(){
    }


    /**
     *  Method used by singletons.
     * @return Returns the same instance of the existing musicPlayer.
     * If no instance exists, create one.
     */
    public static INMusicPlayer getInstance() {
        if (instance == null) {
            instance = new NMusicPlayer();
        }
        return instance;
    }

    public void loadMusic(){
        Assets.loadMusicFiles();
    }

    /**
     *  Plays the String by getting the correspondent Music file from the assetManager.
     *  Sets the volume to the mastervolume, and set an infinite loop.
     *  Sets the currentPlaying to be the song playing, to easier track the current song.
     * @param str The string from with a musicFile will be obtained.
     */
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

    public String getSoundOff(){
        if (masterVolume == 0){
            return "Off";
        }
        else {
            return "On";
        }
    }

    /**
     * Plays a sound effect (eg. buttonClicked).
     * The sound will be lower than the masterVolume, and if the volume is muted, mute this sound.
     * @param str The sound effect to be played.
     */
    public void playSound(String str) {
        Music music = Assets.getSong(str);
        if (music != null) {
            float soundEffectVolume = 0.6f;
            if (soundEffectVolume <masterVolume) {
                music.setVolume(soundEffectVolume);
            } else {
                music.setVolume(masterVolume);
            }
            music.play();
        }
    }

    /**
     *  Switches the current song to the new song. If the current song is the new song, do nothing.
     *  @param newSong The new song to be played.
     */
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

    /**
     * Sets the mastervolume for the musicPlayer. Mutes or unmutes the sound.
     * @param volume The new masterVolume.
     */
    public void setMasterVolume(float volume) {
        masterVolume = volume;
        currentlyPlaying.setVolume(masterVolume);
    }

    public float getMasterVolume(){
        return masterVolume;
    }
}
