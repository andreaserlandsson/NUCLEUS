package com.nucleus.Utils;

/**
 * Created by erik on 16/05/16.
 */
public interface IProgressTracker {
    void writeCompletedLevels(int lvlNumber);
    boolean checkLevelPermission(int levelNumber);
}