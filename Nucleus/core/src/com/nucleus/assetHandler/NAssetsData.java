package com.nucleus.assetHandler;

public class NAssetsData {
    //Class with strings for all paths for all audio, textfiles and textures.
    //Used to minimize code duplication for each class.

    public static final String LEVELMUSIC = "inGame";
    public static final String MENUMUSIC = "menuSounds.wav";
    public static final String BUTTONCLICKEDSOUND = "tempButton.mp3";
    public static final String LOADINGMUSIC = "LoadingSound.mp3";
    public static final String BACKGROUND = "bg.png";
    public static final String COMPLETEDGLUON = "completedGluon.png";
    public static final String NEUTRON = "neutron.png";
    public static final String NEUTRONHALF = "neutronHalf.png";
    public static final String NEUTRONHALFCOMPLETE = "neutronHalfComplete.png";
    public static final String PAUSE = "pause.png";
    public static final String PROTON = "proton.png";
    public static final String PROTONHALF = "protonHalf.png";
    public static final String PROTONHALFCOMPLETE = "protonHalfComplete.png";
    public static final String TAILNEUTRON1 = "tailNeutron1.png";
    public static final String TAILNEUTRON2 = "tailNeutron2.png";
    public static final String TAILNEUTRON3 = "tailNeutron3.png";
    public static final String TAILPROTON1 = "tailProton1.png";
    public static final String TAILPROTON2 = "tailProton2.png";
    public static final String TAILPROTON3 = "tailProton3.png";
    public static final String WINSOUND = "winSound.mp3";
    public static final String LOSESOUND = "loseSound.mp3";

    public static final String LEVELLEVEL = "level_";
    public static final String LEVELPICTURE = ".png";

    //Method to return the correct texture for a level.
    public static String getLevelPicture (int levelNr) {
        return Integer.toString(levelNr) + LEVELPICTURE;
    }

    //Method to return the correct song for a level.
    public static String getLevelSong(int levelNr) {
        return LEVELMUSIC + Integer.toString(levelNr) + ".mp3";
    }

    //Method to return the correct .txt for level
    public static String getLevelLevel(int levelNr) {
        return LEVELLEVEL + Integer.toString(levelNr) + ".txt";
    }

}
