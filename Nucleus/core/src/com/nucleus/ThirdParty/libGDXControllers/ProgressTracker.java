package com.nucleus.ThirdParty.libGDXControllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Created by erik on 16/05/16.
 */
public class ProgressTracker {
    FileHandle file;

    public ProgressTracker(){
        this.file = Gdx.files.local("assets/progress.txt");
    }

    public int readCompletedLevels(){
        return 0;
    }

    public void writeCompletedLeves(){

    }
}
