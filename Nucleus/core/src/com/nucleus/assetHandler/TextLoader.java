package com.nucleus.assetHandler;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

    /**
     *  As there is no default loader for Texts in AssetManager, we implement our own.
     * Created by guidelines from
     * https://github.com/libgdx/libgdx/wiki/Managing-your-assets#writing-your-own-loaders
     */
public class TextLoader extends AsynchronousAssetLoader<Text, TextLoader.TextParameter> {

        /**
         * Inner class for the text parameters. Extends the default AssetLoaderParameters.
         */
    public class TextParameter extends AssetLoaderParameters<Text> {
    }

    Text text;


    public TextLoader(FileHandleResolver resolver) {
        super(resolver);
    }

    public void loadAsync(AssetManager manager, String fileName, FileHandle file, TextParameter parameter) {
        this.text = new Text(file);
    }

    public Text loadSync(AssetManager manager, String fileName, FileHandle file, TextParameter parameter) {
        Text newText = this.text;
        this.text = null;
        return newText;
    }

        /**
         * No dependencies required, so return null.
         * Must however be implemented from AsynchronousAssetLoader.
         * @param fileName
         * @param file
         * @param parameter
         * @return
         */
        public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, TextParameter parameter) {
        return null;
    }
}