package com.nucleus.ThirdParty.libGDXSounds;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import java.util.ArrayList;
import java.util.List;


public class NMusicPlayerAdapter implements INMusicPlayerAdapter {
    private static INMusicPlayerAdapter instance = null;
    MusicPlayer musicPlayer;
    Music menu, inGame1,inGame2, buttonClicked, loadingLevel;
    final String menuMusic = "music/menuSounds.wav";
    final String levelMusic1 = "music/inGame.mp3";
    final String levelMusic2 = "music/inGame2.mp3";
    final String buttonSound = "music/tempButton.mp3";
    final String loadingSound = "music/LoadingSound.mp3";
    List<Music> musicList;
    List<String> musicIndex;

    public static INMusicPlayerAdapter getInstance(){
        if (instance == null){
            instance = new NMusicPlayerAdapter();
        }
        return instance;
    }
    private NMusicPlayerAdapter() {
        musicPlayer = MusicPlayer.getInstance();
        musicList = new ArrayList<Music>();
        musicIndex = new ArrayList<String>();
        loadSongs();
        for (int i = 0; i < musicIndex.size(); i++){
            System.out.println(musicIndex.get(i));
        }
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
        musicList.add(menu =  Gdx.audio.newMusic(Gdx.files.internal("music/menuSounds.wav")));
        musicList.add(inGame1 = Gdx.audio.newMusic(Gdx.files.internal("music/inGame.mp3")));
        musicList.add(inGame2 = Gdx.audio.newMusic(Gdx.files.internal("music/inGame2.mp3")));
        musicList.add(buttonClicked = Gdx.audio.newMusic(Gdx.files.internal("music/tempButton.mp3")));
        musicList.add(loadingLevel = Gdx.audio.newMusic(Gdx.files.internal("music/LoadingSound.mp3")));
        musicIndex.add(menuMusic);
        musicIndex.add(levelMusic1);
        musicIndex.add(levelMusic2);
        musicIndex.add(buttonSound);
        musicIndex.add(loadingSound);
    }

    private Music findSong(String song){
        Music music = null;
        //System.out.println(musicIndex.size());
        //System.out.println(musicList.size());
        for (int i = 0; i < musicIndex.size(); i++){
          //  System.out.println(musicIndex.get(i));
            //System.out.println(song);

            if (musicIndex.get(i).equals(song)) {
                    return musicList.get(i);
            }
        }
        return music;
    }
}
