package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Gender {
    MALE("M"), FEMALE("F"), ALL("ALL");

    Gender(String value) {
    }
    public static Gender findGender(String value){
        return valueOf(value);
    }

    @Override
    public String toString() {
        return "Gender{"+name()+"}";
    }
}
