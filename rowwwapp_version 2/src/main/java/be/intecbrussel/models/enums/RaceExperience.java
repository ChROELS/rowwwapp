package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum RaceExperience {
    BEGINNER("Débutant"), NON_BEGINNER("Non-débutant"),ALL("Tous");
    private final String value;
    RaceExperience(String value){this.value = value;}

    public static RaceExperience findRaceExperience(String value){
        return valueOf(value);
    }
    public String getValue(){
        return this.value;
    }
    @Override
    public String toString() {
        return "RaceExperience{"+name()+"}";
    }
}
