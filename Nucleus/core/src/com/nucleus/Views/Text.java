package com.nucleus.Views;

import com.badlogic.gdx.files.FileHandle;

/**
 * Created by paki on 5/25/16.
 */
public class Text {
    private String str;

    public Text(){
        this.str = new String("".getBytes());
    }

    public Text(byte[] data) {
        this.str = new String(data);
    }

    public Text (String string){
        this.str = new String(string.getBytes());
    }

    public Text (FileHandle fileHandle) {
        this.str = new String(fileHandle.readBytes());
    }

    public Text(Text text) {
        this.str = new String(text.toString().getBytes());
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }

    public void dispose(){
        this.str = new String("".getBytes());
    }
}
