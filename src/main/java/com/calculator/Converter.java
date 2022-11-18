package com.calculator;

import java.util.ArrayList;

public class Converter {

    public Converter() {

    }
    public double stringConverter(Object number) {
        ArrayList<String> zeroToNine = new ArrayList<String>(){{
            add("zero");
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
            add("six");
            add("seven");
            add("eight");
            add("nine");
        }};
        double floatyNumber = zeroToNine.indexOf(number);
        if (floatyNumber >=0 & floatyNumber <= 9) {
            return zeroToNine.indexOf(number);
        }else {
            return Double.parseDouble(String.valueOf(number));
        }
    }
}
