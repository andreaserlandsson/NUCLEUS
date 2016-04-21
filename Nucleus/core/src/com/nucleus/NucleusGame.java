package com.nucleus;

public class NucleusGame {

    Level level;
    private int height;
    private int width;

    public NucleusGame(int height, int width){
        this.height = height;
        this.width= width;
    }

    public void buildLevel(int lvl){
        LevelBuilder.buildLevel(lvl);
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

}
