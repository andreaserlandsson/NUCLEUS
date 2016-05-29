package com.nucleus.assetHandler;

import com.badlogic.gdx.files.FileHandle;

/**
 * Wrapper class for the string class.
 */
public class Text {
    private String str;

    /**
     * Sets the String to be containing the specific data in the specific file.
     * @param fileHandle File to be read and made to a string.
     */
    public Text (FileHandle fileHandle) {
        this.str = new String(fileHandle.readBytes());
    }

    @Override
    public String toString() {
        return this.str;
    }
}
