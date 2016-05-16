package com.nucleus.ThirdParty.libGDXControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.nucleus.Model.IProgressTracker;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker implements IProgressTracker{
    FileHandle file;

    public ProgressTracker(){
        this.file = Gdx.files.local("assets/progress.txt");
    }

    public int readCompletedLevels(){
        String completedLvl = file.readString();
        return Integer.parseInt(completedLvl);
    }

    public void writeCompletedLeves(int levelNumber){
        if(readCompletedLevels()>levelNumber)
            file.writeString(Integer.toString(levelNumber),false);
    }
}
