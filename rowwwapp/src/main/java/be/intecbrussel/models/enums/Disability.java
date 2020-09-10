package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Disability {
    UNKNOWN, HEARING, SEEING, SPEAKING, LEARNING, MOBILITY, AMPUTEE, MUSCULAR, CEREBRAL, DOWNS_SYNDROME, NO_DISABILITY;
    public String toString(){
        return Arrays.toString(values());
    }
}
