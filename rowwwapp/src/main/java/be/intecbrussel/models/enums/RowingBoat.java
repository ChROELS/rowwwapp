package be.intecbrussel.models.enums;

import java.util.Arrays;

public enum RowingBoat {
    ALL("Tous"),SWEEP_COXLESS_PAIR_2_MINUS("2-"),SWEEP_COXLESS_PAIR_4_MINUS("4-"),SWEEP_COXLESS_PAIR_2_PLUS("2+"),
    SWEEP_COXLESS_PAIR_4_PLUS("4+"),SWEEP_EIGHT_8_PLUS("8+"),SINGLE_SCULL_1X("1x"),
    DOUBLE_SCULL_2X("2x"),TRIPLE_SCULL_3X("3x"),QUAD_SCULL_4X("4x"),OCTUPLE_SCULL_8X("8x"),
    QUEEP_4_MINUS("4-"),ROWING_DINGHY("Dinghy"),ROWING_TENDER("Tender"),YOLE("Yole"),
    CANOE_SKIFF("Canöe"),CANADIAN_TREK_SKIFF("Canadian_trek"),SINGLE_TREK_SKIFF_1X("Trek_1x"),
    DOUBLE_TREK_SKIFF_2X("Trek_2x"),QUAD_TREK_SKIFF_4X("Trek_4x");

    RowingBoat(String value){

    }

    public static RowingBoat findBoat(String value){
        return valueOf(value);
    }

    @Override
    public String toString() {
        return Arrays.toString(values());
    }
}
