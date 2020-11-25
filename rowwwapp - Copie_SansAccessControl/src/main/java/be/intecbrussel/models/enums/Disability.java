package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum Disability {
    Option_0("no disability"),
    Option_1("rowers with minimal or no trunk function who primarily propel the boat through arm and shoulder function. These rowers have poor sitting balance, which requires them to be strapped to the boat/seat"),
    Option_2("rowers that have functional use of arms and trunk but have weakness/absence of leg function to slide the seat"),
    Option_3("rowers with residual function in the legs which allows them to slide the seat. This class also includes athletes with vision impairment");

    Disability(String value) {
    }
    public static Disability findDisability(String value){
        return valueOf(value);
    }


    public String toString(Disability d) {
        String result = null;
        switch (d) {
            case Option_0:
                result= "Disability{" + "no disability" + "}";
            break;
            case Option_1:
                result="Disability{" + "rowers with minimal or no trunk function who primarily propel the boat through arm and shoulder function" + "}";
            break;
            case Option_2:
                result= "Disability{" + "rowers that have functional use of arms and trunk but have weakness/absence of leg function to slide the seat" + "}";
            break;
            case Option_3:
                result= "Disability{" + "rowers with residual function in the legs which allows them to slide the seat" + "}";
            break;
        }
        return result;
    }

}
