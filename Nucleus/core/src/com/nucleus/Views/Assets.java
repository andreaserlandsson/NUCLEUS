package com.nucleus.Views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.HashMap;
import java.util.Map;

public class Assets {
    private static AssetManager audioAssets = new AssetManager();
    private static AssetManager textureAssets = new AssetManager();
    private static AssetManager skinAssets = new AssetManager();

    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();
    private static Map<String, String> skins = new HashMap<String, String>();


    public static void loadMusicFiles() {
        FileHandle musicPath;
        musicPath = Gdx.files.internal("music/");
        for (FileHandle entry : musicPath.list()) {
            audio.put(entry.name(), entry.path());
            System.out.println("path == " +entry.path() + "\n" + " name = " + entry.name());
        }
        loadMusic();
        finishLoading(audioAssets);

        System.out.println(audioAssets.getLoadedAssets());
    }

    public static void loadTextureFiles() {
        FileHandle texturePath;
        texturePath = Gdx.files.internal("graphics/");

        for (FileHandle entry : texturePath.list()) {
            texture.put(entry.name(), entry.path());
        }
        loadTexture();
        finishLoading(textureAssets);
        System.out.println(textureAssets.getLoadedAssets());
    }

    /*public static void loadSkinFiles() {
        FileHandle skinPath;
        skinPath = Gdx.files.internal("menu/skins/");

        for (FileHandle entry : skinPath.list()) {
            skins.put(entry.name(),entry.path());
        }
        loadSkins();
        finishLoading(skinAssets);
    } */


    public static void loadMusic () {
        if (audio != null) {
            for (Map.Entry entry : audio.entrySet()) {
                audioAssets.load((String) entry.getValue(), Music.class);
               // System.out.println("key ====== " +entry.getKey());
               // System.out.println("namn på låt == " + entry.getValue());

            }
        }
    }

    public static void loadTexture() {
        if (texture != null) {
            for (Map.Entry entry : texture.entrySet()) {
                textureAssets.load((String) entry.getValue(), Texture.class);
                System.out.println("key ====== " +entry.getKey());
                System.out.println("namn på grafisk skit == " + entry.getValue());
            }
        }
    }
    /*
    public static void loadSkins() {
        if (skins != null) {
            for (Map.Entry entry : skins.entrySet()) {
                skinAssets.load((String) entry.getValue(), Skin.class);
            }
        }
    } */

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

    public static Skin getSkin(String s) {
        Skin skinFile = null;
        String skinPath = skins.get(s);
        if (skinPath != null) {
            skinFile = skinAssets.get(skinPath, Skin.class);
            return skinFile;
        }
    return skinFile;
    }

    public static void finishLoading(AssetManager assetManager){
        while(!(assetManager.update()));
    }

}
