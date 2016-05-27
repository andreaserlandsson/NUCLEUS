package com.nucleus.Model;

/**
 * Created by paki on 5/4/16.
 */
public class LevelNotExistingException extends Exception {
    public LevelNotExistingException(){

    }

    public LevelNotExistingException(String str) {
        super(str);
    }
}
