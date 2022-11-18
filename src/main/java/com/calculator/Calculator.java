package com.calculator;

public class Calculator {

    private Converter converter;

    public Calculator(Converter converter) {
        this.converter = converter;
    }

    public double addition(Object x, Object y) {
        double floatx = converter.stringConverter(x);
        double floaty = converter.stringConverter(y);
        return floatx + floaty;
    }

    public double subtraction(Object x, Object y) {
        double floatx = converter.stringConverter(x);
        double floaty = converter.stringConverter(y);
        return floatx - floaty;
    }

    public double multiply(Object x, Object y) {
        double floatx = converter.stringConverter(x);
        double floaty = converter.stringConverter(y);
        return floatx * floaty;
    }

    public String divideByZero() {
        return "Cannot divide by zero";
    }

    public Object divide(Object x, Object y) {

        double floatx = converter.stringConverter(x);
        double floaty = converter.stringConverter(y);
        if (floaty != 0) {
            return (floatx / floaty);
        }
        return divideByZero();
    }
}
