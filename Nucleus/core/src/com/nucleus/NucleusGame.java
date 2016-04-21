package com.nucleus;

public class NucleusGame {

    Level level;
    private int height;
    private int width;

    public NucleusGame(int width, int height){
        this.height = height;
        this.width= width;
    }

    public void buildLevel(int lvl){
        level = LevelBuilder.buildLevel(width, height, lvl);
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public Level getLevel(){
        return level;
    }


}
