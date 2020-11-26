package be.intecbrussel.models.enums;

public enum Category {
    ALL_OPEN("Open"), PR3("PR3"), PR2("PR2"), PR1("PR1"), JUNIOR_10("10"),JUNIOR_12("12"),JUNIOR_14("14"),JUNIOR_16("16")
    ,JUNIOR_18("18"),UNDER_23("U23"),SENIOR_A("S_A"),SENIOR_B("S_B"),Master_A("A"),Master_B("B"),Master_C("C"),
    Master_D("D"),Master_E("E"),Master_F("F"),Master_G("G"),Master_H("H"),Master_I("I"),Master_J("J"),Master_K("K"),
    Master_L("L"),Master_M("M");

    private final String value;
    Category(String value1) {
        this.value = value1;
    }
    public String getValue(){
        return this.value;
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
            category = JUNIOR_10;
        } else if (age >= 10 && age < 12) {
            category = JUNIOR_12;
        } else if (age >= 12 && age < 14) {
            category = JUNIOR_14;
        } else if (age >= 14 && age < 16) {
            category = JUNIOR_16;
        } else if (age >= 16 && age < 18) {
            category = JUNIOR_18;
        }
          else if (age >= 18 && age < 23) {
                category = UNDER_23;
            }
        else if (age >= 23 &&age < 25) {
            category = SENIOR_A;
        }
        else if (age >= 25 && age < 27) {
            category = SENIOR_B;
        }
        else if (age >= 27 && age < 36) {
            category = Master_A;
        }
        else if (age >= 36 && age < 43) {
            category = Master_B;
        }
        else if (age >= 43 && age < 50) {
            category = Master_C;
        }
        else if (age >= 50 && age < 55) {
            category = Master_D;
        }
        else if (age >= 55 && age < 60) {
            category = Master_E;
        }
        else if (age >= 60 && age < 65) {
            category = Master_F;
        }
        else if (age >= 65 && age < 70) {
            category = Master_G;
        }
        else if (age >= 70 && age < 75) {
            category = Master_H;
        }
        else if (age >= 75 && age < 80) {
            category = Master_I;
        }
        else if (age >= 80 && age < 83) {
            category = Master_J;
        }
        else if (age >= 83 && age < 86) {
            category = Master_K;
        }
        else if (age >= 86 && age < 89) {
            category = Master_L;
        }
        else {
            category = Master_M;
        }
        return category;
    }

}
