package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Position {
    COX("barreur(euse)"),STROKE("nage"),ROWER("rameur(euse)");

    Position(String value){}
    public static Position findPosition(String value){
        return valueOf(value);
    }
    @Override
    public String toString() {
        return Arrays.toString(values());
    }
}
