package com.nucleus.model;

public class LevelNotExistingException extends Exception {
    public LevelNotExistingException(){

    }

    public LevelNotExistingException(String str) {
        super(str);
    }
}
