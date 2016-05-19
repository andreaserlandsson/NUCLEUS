package com.nucleus.Views;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    public static AssetManager audioAssets = new AssetManager();
    public static AssetManager textureAssets = new AssetManager();

    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();

    public static void loadMusicFiles() {
        FileHandle musicPath;

        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            musicPath = Gdx.files.internal("assets/music");
        } else {
            musicPath = Gdx.files.internal("music/");
        }
        for (FileHandle entry : musicPath.list()) {
            audio.put(entry.path(), entry.name());
            //System.out.println("Path ====== "+entry.path());
            //System.out.println("namn ==== " +entry.name());
        }
    }

    public static void loadTextureFiles() {
        FileHandle texturePath;
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            texturePath = Gdx.files.internal("assets/graphics");
        } else {
            texturePath = Gdx.files.internal("graphics/");
        }
        for (FileHandle entry : texturePath.list()) {
            texture.put(entry.path(), entry.name());
            //System.out.println("Path ====== "+entry.path());
            //System.out.println("namn ==== " +entry.name());
        }
    }
    public static void loadMusic () {
        if (audio != null) {
            for (Map.Entry entry : audio.entrySet()) {
                audioAssets.load((String) entry.getValue(), Music.class);
                //System.out.println("key ====== " +entry.getKey());
                //System.out.println("namn på låt == " + entry.getValue());
            }
        }
    }

    public static void loadTexture() {
        if (texture != null) {
            for (Map.Entry entry : texture.entrySet()) {
                textureAssets.load((String) entry.getValue(), Skin.class);
                //System.out.println("key ====== " +entry.getKey());
                //System.out.println("namn på grafisk skit == " + entry.getValue());
            }
        }
    }

    public static AssetManager getMusic () {
        return audioAssets;
    }
}
