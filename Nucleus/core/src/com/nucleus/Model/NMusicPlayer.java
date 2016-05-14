package com.nucleus.Model;

import com.nucleus.ThirdParty.libGDXSounds.*;

import java.util.Random;

public class NMusicPlayer  {
    public static final String levelOneMusic = "music/inGame.mp3";
    public static final String levelTwoMusic = "music/inGame2.mp3";
    public static final String menuMusic = "music/menuSounds.wav";
    public static final String buttonClickedSound = "music/tempButton.mp3";
    public static final String loadingMusic = "music/LoadingSound.mp3";
    public static String levelSong;
    private static final int amountOfSongs = 2;
    private static NMusicPlayer instance = null;
    private static INMusicPlayerAdapter musicPlayer;

    private NMusicPlayer() {
    }

    public static NMusicPlayer getInstance(){
        if (instance == null){
            instance = new NMusicPlayer();
            musicPlayer = NMusicPlayerAdapter.getInstance();
            System.out.println(levelSong);
        }
        return instance;
    }

    public void playLoop(String song, float volume) {
        musicPlayer.playSongLoop(song,volume);
    }

    public void playSound(String song) {
        musicPlayer.playSoundEffect(song);
    }
    public void changeMusic(String newSong, String oldSong, float volume) {
        musicPlayer.changeSong(newSong,oldSong,volume);
    }
    public void pauseMusic(String song) {
        musicPlayer.pauseSong(song);
    }
    public void resumeMusic(String song) {
        musicPlayer.resumeSong(song);
    }

    public void stopMusic(String song) {
        musicPlayer.stopSong(song);
    }
}
