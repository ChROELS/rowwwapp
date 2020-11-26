package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Position {
    COX("barreur(euse)"),STROKE("nage"),ROWER("rameur(euse)");
    private final String value;
    Position(String value){this.value = value;}
    public static Position findPosition(String value){
        return valueOf(value);
    }
    public String getValue(){
        return this.value;
    }
    @Override
    public String toString() {
        return "Position{"+name()+"}";
    }
}
