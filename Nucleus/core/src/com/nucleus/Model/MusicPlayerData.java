package com.nucleus.Model;


import java.util.HashMap;
import java.util.Map;


public class MusicPlayerData {
    public static final String levelOneMusic = "music/inGame.mp3";
    public static final String levelTwoMusic = "music/inGame2.mp3";
    public static final String menuMusic = "music/menuSounds.wav";
    public static final String buttonClickedSound = "music/tempButton.mp3";
    public static final String loadingMusic = "music/LoadingSound.mp3";
    private static MusicPlayerData instance = null;

    Map<String, String> audio;

    private MusicPlayerData(){
        audio = new HashMap<String, String>();
        audio.put(levelOneMusic, levelOneMusic);
        audio.put(levelTwoMusic, levelTwoMusic);
        audio.put(loadingMusic, loadingMusic);
        audio.put(buttonClickedSound, buttonClickedSound);
        audio.put(menuMusic, menuMusic);
        System.out.println(levelOneMusic.hashCode());
    }

    public static MusicPlayerData getInstance(){
        if (instance == null) {
            instance = new MusicPlayerData();
        }
        return instance;
    }

    public Map<String, String> getMusicMap(){
        return audio;
    }
}
