package com.nucleus.Controller;

/**
 * Created by erik on 16/05/16.
 */
public interface IProgressTracker {
    void writeCompletedLevels(int lvlNumber);
    boolean checkLevelPermission(int levelNumber);
}