package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum RaceType {
    INLINE_C1("C1"),INLINE_C2("C2"),INLINE_C4("C4"),JUNIOR_SLALOM("slalom"),JUNIOR_DUATHLON("duathlon"),JUNIOR_BIATHLON("biathlon"),
    JUNIOR_TRIATHLON("triathlon"),TETE_DE_RIVIERE("Tête de rivière"), HANDICAP("Open à handicap"),REGATTA("régate"),
    TREK("randonnée"),CHALLENGE("challenge"),UNKNOWN("non-mentioné"),UNCLASSIFIED("non-répertorié");

    RaceType(String value){

    }
    public static RaceType findRace(String value){
        return valueOf(value);
    }
    @Override
    public String toString() {
        return Arrays.toString(values());
    }
}
