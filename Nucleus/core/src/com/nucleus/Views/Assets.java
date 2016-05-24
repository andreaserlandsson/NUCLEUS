package com.nucleus.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Json;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    private static AssetManager audioAssets = new AssetManager();
    private static AssetManager textureAssets = new AssetManager();

    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();


    public static void loadMusicFiles() {
        FileHandle musicPath;
        musicPath = Gdx.files.internal("music/");
        for (FileHandle entry : musicPath.list()) {
            audio.put(entry.name(), entry.path());
        }
        loadMusic();
        finishLoading(audioAssets);
    }

    public static void loadTextureFiles() {
        FileHandle texturePath;
        texturePath = Gdx.files.internal("graphics/");

        for (FileHandle entry : texturePath.list()) {
            texture.put(entry.name(), entry.path());
        }
        loadTexture();
        finishLoading(textureAssets);
    }

    public static void loadMusic () {
        if (audio != null) {
            for (Map.Entry entry : audio.entrySet()) {
                audioAssets.load((String) entry.getValue(), Music.class);
            }
        }
    }

    public static void loadTexture() {
        if (texture != null) {
            for (Map.Entry entry : texture.entrySet()) {
                textureAssets.load((String) entry.getValue(), Texture.class);
            }
        }
    }

    public static Music getSong(String song) {
        Music music = null;
        String songFile = audio.get(song);
        if (songFile != null) {
            music = audioAssets.get(songFile, Music.class);
            return music;
        }
        return music;
    }

    public static Texture getTexture(String picture) {
        Texture pic = null;
        String textPath = texture.get(picture);
        if (textPath != null) {
            pic = textureAssets.get(textPath, Texture.class);
            return pic;
        }
        return pic;
    }

    public static void finishLoading(AssetManager assetManager){
        while(!(assetManager.update()));
    }

}
