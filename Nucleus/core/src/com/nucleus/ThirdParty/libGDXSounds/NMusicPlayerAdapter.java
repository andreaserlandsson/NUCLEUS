package com.nucleus.ThirdParty.libGDXSounds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.nucleus.Model.MusicPlayerData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NMusicPlayerAdapter implements INMusicPlayerAdapter {
    private static INMusicPlayerAdapter instance = null;
    private MusicPlayer musicPlayer;
    private static Map<String, String> musicFiles;
    private static Map<String, Music> musicList;
    private MusicPlayerData musicPlayerData;

    private NMusicPlayerAdapter() {
        musicPlayer = MusicPlayer.getInstance();
        musicPlayerData = MusicPlayerData.getInstance();
        musicFiles = musicPlayerData.getMusicMap();
        musicList = new HashMap<String, Music>();
        loadSongs();
    }

    public static INMusicPlayerAdapter getInstance(){
        if (instance == null) {
            instance = new NMusicPlayerAdapter();
        }
        return instance;
    }

    @Override
    public void playSongLoop(String song, float volume) {
        musicPlayer.playMusicLoop(findSong(song),volume);
    }

    @Override
    public void playSoundEffect(String song) {
        musicPlayer.playSound(findSong(song));
    }

    @Override
    public void changeSong(String newSong, String oldSong, float volume) {
        musicPlayer.changeMusic(findSong(newSong),findSong(oldSong),volume);
    }

    @Override
    public void pauseSong(String song) {
        musicPlayer.pauseMusic(findSong(song));
    }

    @Override
    public void resumeSong(String song) {
        musicPlayer.resumeMusic(findSong(song));
    }

    @Override
    public void stopSong(String song) {
        musicPlayer.stopMusic(findSong(song));
    }

    private void loadSongs() {
        for (Map.Entry<String, String> entry : musicFiles.entrySet()){
            musicList.put(entry.getKey(),Gdx.audio.newMusic(Gdx.files.internal(entry.getValue())));
        }
    }

    private Music findSong(String song){
        Music music = null;
        for (Map.Entry e : musicList.entrySet()) {
            if (e.getKey().equals(song)) {
                System.out.println("hittade en låt!");
                music = (Music)e.getValue();
                return music;
            }
        }
        return music;
    }
}
