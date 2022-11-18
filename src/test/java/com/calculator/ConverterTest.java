package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    private Converter converter = new Converter();

    @Test
    public void shouldReturnADoubleFromStringInput() {
        double actual = converter.stringConverter("one");
        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnADoubleFromFloatInput() {
        double actual = converter.stringConverter(1.0f);
        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnADoubleFromIntegerInput() {
        double actual = converter.stringConverter(1);
        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnADoubleFromStringIntegerInput() {
        double actual = converter.stringConverter("1");
        assertEquals(1, actual);
    }

    @Test
    public void shouldReturnADoubleFromDoubleInput() {
        double actual = converter.stringConverter(1.0);
        assertEquals(1, actual);
    }
}
