package com.nucleus.assetHandler;

public class NAssetsData {

    /**
     * Holder class with strings for all values to all different files that is loaded into the assetManager.
     */

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

    //här är jag
    public static final String SHIELD = "shield.png";
    public static final String SHIELDCIRCLE = "circle.png";
    //till hit

    public static final String LEVELLEVEL = "level_";
    public static final String LEVELPICTURE = ".png";


    public static String getLevelPicture (int levelNr) {
        return Integer.toString(levelNr) + LEVELPICTURE;
    }

    public static String getLevelSong(int levelNr) {
        return LEVELMUSIC + Integer.toString(levelNr) + ".mp3";
    }

    public static String getLevelLevel(int levelNr) {
        return LEVELLEVEL + Integer.toString(levelNr) + ".txt";
    }

}
