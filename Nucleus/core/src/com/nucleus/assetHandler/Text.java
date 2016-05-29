package com.nucleus.assetHandler;

import com.badlogic.gdx.files.FileHandle;

    //Wrapper class of the String class
public class Text {
    private String str;

    //Sets the file from the .txt file
    public Text (FileHandle fileHandle) {
        this.str = new String(fileHandle.readBytes());
    }

    //Returns the text in in a string format.
    @Override
    public String toString() {
        return this.str;
    }
}
