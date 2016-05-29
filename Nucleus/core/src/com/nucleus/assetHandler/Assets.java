package com.nucleus.assetHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;


import java.util.HashMap;
import java.util.Map;

public class Assets {
    /**
     * Paths to the three different directories where the music files are located.
     */
    private static final String PATHTOMUSIC = "music/";
    private static final String PATHTOTEXTURE = "graphics/";
    private static final String PATHTOTXT = "levels/leveldata/";

    /**
     * Three AssetManagers, one for each file type.
     */
    private static AssetManager audioAssets = new AssetManager();
    private static AssetManager textureAssets = new AssetManager();
    private static AssetManager txtAssets = new AssetManager();

    /**
     * Three hashMaps containing all paths and values for each file type.
     */
    private static Map<String, String> audio = new HashMap<String, String>();
    private static Map<String, String> texture = new HashMap<String, String>();
    private static Map<String, String > txt = new HashMap<String, String>();

    /**
     * The three methods below do the same thing, but for different class types.
     * They all load their own class from the filepath into the hashmap, and then
     * calls on respectively load method and waits for the assets to be loaded.
    */
    public static void loadMusicFiles() {
        FileHandle musicPath;
        musicPath = Gdx.files.internal(PATHTOMUSIC);

        for (FileHandle entry : musicPath.list()) {
            audio.put(entry.name(), entry.path());
        }
        loadMusic();
        finishLoading(audioAssets);
    }

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
        }
        loadText();
        finishLoading(txtAssets);
    }

    /**
     * The three following methods do the same for each class type.
     * Loads all the files that is in it's hashMap into the assigned AssetManager.
     * The value is the path to each file.
     */
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

    public static void loadText() {
        setTxtLoader(txtAssets);
        if (txt != null) {
            for (Map.Entry entry : txt.entrySet()) {
                txtAssets.load((String) entry.getValue(), Text.class);
            }
        }
    }

    /**
     * The three following methods works in the same way, and this will be the comment for all of them.
     * The method checks if the String is in the hashMap for corresponding type.
     * If it is, the assetManager gets the specific file, and returns it.
     * @param song the string to be located and returned.
     * @return returns the corresponding type, in this case a Music.class.
     */
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

    public static Text getFile(String file){
        Text text = null;
        String filePath = txt.get(file);
        if (filePath != null) {
            text = txtAssets.get(filePath, Text.class);
            return text;
        }
        return text;
    }

    /**
     * Makes sure that the assetManger finishes loading each object.
     * This is done as assetManager.load() only places objects in a loading queue, while
     * update() actually loads the objects in the queue.
     * @param assetManager The specific assetManager that needs to load queue'd objects.
     */
    public static void finishLoading(AssetManager assetManager){
        while(!(assetManager.update()));
    }

    /**
     * As .txt is not a default loader for the AssetManager, we have to define it here.
     * Uses the TextLoader class that is also created for this purpose only.
     * @param assetManager The assetManager that we sets the loading type for.
     */
    private static void setTxtLoader(AssetManager assetManager) {
        assetManager.setLoader(Text.class, new TextLoader(new InternalFileHandleResolver()));
    }
}
