package com.nucleus.Model;

/**
 * Created by erik on 16/05/16.
 */
public interface IProgressTracker {
    int readCompletedLevels();
    void writeCompletedLeves(int lvlNumber);
}