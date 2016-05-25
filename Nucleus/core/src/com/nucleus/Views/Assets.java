package com.nucleus.Views;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Assets {
    //Paths to the different directories where the files are located.
    private static final String PATHTOMUSIC = "music/";
    private static final String PATHTOTEXTURE = "graphics/";
    private static final String PATHTOTXT = "levels/leveldata/";


    //Two assetManagers, one for each type of file.
    private static AssetManager audioAssets = new AssetManager();
    private static AssetManager textureAssets = new AssetManager();
    private static AssetManager txtAssets = new AssetManager();

    //Two HashMaps which holds the location and key to all different files.
    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();
    private static Map<String, String > txt = new HashMap<String, String>();

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

    public static void loadTextFiles() {
        FileHandle txtPath;
        txtPath = Gdx.files.internal(PATHTOTXT);


        for (FileHandle entry : txtPath.list()) {
            txt.put(entry.name(), entry.path());

            System.out.println(entry.name());
            System.out.println(entry.path());

        }

        loadText();
        finishLoading(txtAssets);
        System.out.println(txtAssets.getLoadedAssets());}

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

    public static void loadText() {
        setTxtLoader(txtAssets);
        if (txt != null) {
            for (Map.Entry entry : txt.entrySet()) {
                txtAssets.load((String) entry.getValue(), Text.class);
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

    public static Text getFile(String file){
        Text text = null;
        String filePath = txt.get(file);
        if (filePath != null) {
            text = txtAssets.get(filePath, Text.class);
            return text;
        }
        return text;
    }

    //Makes sure that the assetManger finishes loading each object.
    //This is done as assetManager.load() only places objects in a loading queue.
    //Update() actually loads the objects in the queue.
    public static void finishLoading(AssetManager assetManager){
        while(!(assetManager.update()));
    }

    private static void setTxtLoader(AssetManager assetManager) {
        assetManager.setLoader(Text.class, new TextLoader(new InternalFileHandleResolver()));
    }

}
