package com.nucleus.ThirdParty.libGDXControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {

    // Singleton because we only want one instance of it, so we don't have
    // multiple songs playing simultaneously.

    private static MusicPlayer instance = null;

    public Music inGameMusic, inGameMusic2, menuMusic,buttonClicked,loadingLevel;

    private MusicPlayer(){
        this.inGameMusic = Gdx.audio.newMusic(Gdx.files.internal("music/inGame.mp3"));
        this.inGameMusic2 = Gdx.audio.newMusic(Gdx.files.internal("music/inGame2.mp3"));
        this.menuMusic = Gdx.audio.newMusic(Gdx.files.internal("music/menuSounds.wav"));
        this.buttonClicked = Gdx.audio.newMusic(Gdx.files.internal("music/tempButton.mp3"));
        this.loadingLevel = Gdx.audio.newMusic(Gdx.files.internal("music/LoadingSound.mp3"));

    }


    //if not initaialized, initalize. Else, return that instance that allready exists.
    public static MusicPlayer getInstance(){
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void initSongs(){
        playMusicLoop(inGameMusic,0f);
        inGameMusic.pause();
    }

    //Start the music.
    public void playMusicLoop(Music music, float volume){
        music.setVolume(volume);
        music.play();
        music.setLooping(true);
    }

    //Play gameSounds, different from music.
    public void playSound(Music music){
        music.play();
    }

    public void changeMusic(Music m1, Music m2, Float volume) {
        m1.stop();
        playMusicLoop(m2,volume);
    }

    //Pause the party.
    public void pauseMusic (Music music){
        music.pause();
    }

    //Resume music where it was last (ex via pause).
    public void resumeMusic (Music music){
        music.play();
    }

    //Stop music.
    public void stopMusic(Music music) {
        music.stop(); //stop eller dispose?
        music.dispose();
    }
}