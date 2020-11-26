package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Gender {
    MALE("M"), FEMALE("F"), ALL("ALL");
    private final String value;
    Gender(String value) {
        this.value = value;
    }
    public static Gender findGender(String value){
        return valueOf(value);
    }
    public String getValue(){
        return this.value;
    }
    @Override
    public String toString() {
        return "Gender{"+name()+"}";
    }
}
