package com.nucleus.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    //Paths to the different directories where the files are located.
    private static final String PATHTOMUSIC = "music/";
    private static final String PATHTOTEXTURE = "graphics/";

    //Two assetManagers, one for each type of file.
    private static AssetManager audioAssets = new AssetManager();
    private static AssetManager textureAssets = new AssetManager();

    //Two HashMaps which holds the location and key to all different files.
    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();


    //Loads all the music from the filepath into the hashMap.
    //Then calls on loadMusic() and wait for the assets to be loaded.
    public static void loadMusicFiles() {
        FileHandle musicPath;
        musicPath = Gdx.files.internal(PATHTOMUSIC);
        for (FileHandle entry : musicPath.list()) {
            audio.put(entry.name(), entry.path());
        }
        loadMusic();
        finishLoading(audioAssets);
    }
    //Loads all the textures from the filepath into the hashMap.
    //Then calls on loadMusic() and wait for the assets to be loaded.
    public static void loadTextureFiles() {
        FileHandle texturePath;
        texturePath = Gdx.files.internal(PATHTOTEXTURE);

        for (FileHandle entry : texturePath.list()) {
            texture.put(entry.name(), entry.path());
        }
        loadTexture();
        finishLoading(textureAssets);
    }

    //Loads all the music that is in the hashMap into the assetManger
    //for audio. The value is the path to each file.
    public static void loadMusic () {
        if (audio != null) {
            for (Map.Entry entry : audio.entrySet()) {
                audioAssets.load((String) entry.getValue(), Music.class);
            }
        }
    }

    //Loads all the textures that is in the hashMap into the assetManger
    //for textures. The value is the path to each file.
    public static void loadTexture() {
        if (texture != null) {
            for (Map.Entry entry : texture.entrySet()) {
                textureAssets.load((String) entry.getValue(), Texture.class);
            }
        }
    }

    //Checks if the song is in the hashmap, and if so
    //gets the song from the audioAsset and returns it.
    public static Music getSong(String song) {
        Music music = null;
        String songFile = audio.get(song);
        if (songFile != null) {
            music = audioAssets.get(songFile, Music.class);
            return music;
        }
        return music;
    }

    //Checks if the texture is in the hashmap, and if so
    //gets the texture from the textureAsset and returns it.
    public static Texture getTexture(String picture) {
        Texture pic = null;
        String textPath = texture.get(picture);
        if (textPath != null) {
            pic = textureAssets.get(textPath, Texture.class);
            return pic;
        }
        return pic;
    }

    //Makes sure that the assetManger finishes loading each object.
    //This is done as assetManager.load() only places objects in a loading queue.
    //Update() actually loads the objects in the queue.
    public static void finishLoading(AssetManager assetManager){
        while(!(assetManager.update()));
    }

}
