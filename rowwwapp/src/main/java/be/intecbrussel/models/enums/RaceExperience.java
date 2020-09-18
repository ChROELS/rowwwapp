package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum RaceExperience {
    BEGINNER("Débutant"), NON_BEGINNER("Non-débutant"),ALL("Tous");

    RaceExperience(String value){}

    public static RaceExperience findRaceExperience(String value){
        return valueOf(value);
    }

}
