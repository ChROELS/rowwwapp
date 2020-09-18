package be.intecbrussel.models.enums;

import java.time.LocalDate;
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
    public static Category selectCategory(Disability disability) {
        Category category=null;
        if(disability==Disability.Option_1){
            category=PR1;
        }else if(disability==Disability.Option_2){
            category=PR2;
        }else if(disability==Disability.Option_3){
            category=PR3;
        }
        return category;
    }
    public static Category selectCategory(int age) {
        Category category=null;
        if (age < 10) {
            category = Category.findCategory("J10");
        } else if (age < 12) {
            category = Category.findCategory("J12");
        } else if (age < 14) {
            category = Category.findCategory("J14");
        } else if (age < 16) {
            category = Category.findCategory("J16");
        } else if (age < 18) {
            category = Category.findCategory("J18");
        }
          else if (age < 23) {
                category = Category.findCategory("U23");
            }
        else if (age < 25) {
            category = Category.findCategory("S_A");
        }
        else if (age < 27) {
            category = Category.findCategory("S_B");
        }
        else if (age < 36) {
            category = Category.findCategory("A");
        }
        else if (age < 43) {
            category = Category.findCategory("B");
        }
        else if (age < 50) {
            category = Category.findCategory("C");
        }
        else if (age < 55) {
            category = Category.findCategory("D");
        }
        else if (age < 60) {
            category = Category.findCategory("E");
        }
        else if (age < 65) {
            category = Category.findCategory("F");
        }
        else if (age < 70) {
            category = Category.findCategory("G");
        }
        else if (age < 75) {
            category = Category.findCategory("H");
        }
        else if (age < 80) {
            category = Category.findCategory("I");
        }
        else if (age < 83) {
            category = Category.findCategory("J");
        }
        else if (age < 86) {
            category = Category.findCategory("K");
        }
        else if (age < 89) {
            category = Category.findCategory("L");
        }
        else {
            category = Category.findCategory("M");
        }
        return category;
    }

}
