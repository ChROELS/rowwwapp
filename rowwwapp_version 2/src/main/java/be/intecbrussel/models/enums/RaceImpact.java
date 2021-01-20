package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum RaceImpact {
    NATIONAL("National"),INTERNATIONAL("International");
    private final String value;

    RaceImpact(String value) {
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
    @Override
    public String toString() {
        return "RaceImpact{"+name()+"}";
    }
}
