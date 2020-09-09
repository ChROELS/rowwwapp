package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Category {
    ALL("Open"), PR3("PR3"), PR2("PR2"), PR1("PR1"), JUNIOR_10("10"),JUNIOR_12("12"),JUNIOR_14("14"),JUNIOR_16("16")
    ,JUNIOR_18("18"),UNDER_23("U23"),SENIOR_A("S_A"),SENIOR_B("S_B"),Master_A("A"),Master_B("B"),Master_C("C"),
    Master_D("D"),Master_E("E"),Master_F("F"),Master_G("G"),Master_H("H"),Master_I("I"),Master_J("J"),Master_K("K"),
    Master_L("L"),Master_M("M");

    Category(String value) {
    }

    public static Category findCategory(String value){
        return valueOf(value);
    }
    @Override
    public String toString() {
        return Arrays.toString(values());
    }
}
