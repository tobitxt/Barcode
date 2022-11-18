package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Mock
    private Converter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        calculator = new Calculator(converter);
    }

    @Test
    public void shouldReturnPrintedErrorMessageWhenDividedByZero(){
        Mockito.when(converter.stringConverter( 0)).thenReturn((double) 0);
        assertEquals("Cannot divide by zero", calculator.divideByZero());
    }

    @Test
    public void shouldAddTwoPositiveIntegers(){
        Mockito.when(converter.stringConverter( 1)).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( 2)).thenReturn((double) 2);
        assertEquals(2, calculator.addition(1,1));
        assertEquals(4, calculator.addition(2,2));
    }

    @Test
    public void shouldAddTwoPositiveIntegersStrings(){
        Mockito.when(converter.stringConverter( "1")).thenReturn((double) 1);
        assertEquals(2, calculator.addition("1","1"));
    }

    @Test
    public void shouldAddOnePositiveIntegerAndOneString(){
        Mockito.when(converter.stringConverter( 1)).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( "1")).thenReturn((double) 1);
        assertEquals(2, calculator.addition(1,"1"));
    }

    @Test
    public void inputWordOutputFloat(){
        Mockito.when(converter.stringConverter( "one")).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( "1")).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( 1)).thenReturn((double) 1);
        Mockito.when(converter.stringConverter("five")).thenReturn((double) 5);
        assertEquals(1, converter.stringConverter("one"));
        assertEquals(1, converter.stringConverter("1"));
        assertEquals(1, converter.stringConverter(1));
        assertEquals(5, converter.stringConverter("five"));
    }

    @Test
    public void shouldAddTwoNameStrings(){
        Mockito.when(converter.stringConverter( "one")).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( "two")).thenReturn((double) 2);
        Mockito.when(converter.stringConverter( "1.2")).thenReturn(1.2);
        Mockito.when(converter.stringConverter("zero")).thenReturn((double) 0);
        assertEquals(3, calculator.addition("one","two"));
        assertEquals(1.2, calculator.addition("1.2","zero"));
    }

    @Test
    public void shouldSubtractTwoPositiveIntegers(){
        Mockito.when(converter.stringConverter( 9)).thenReturn((double) 9);
        Mockito.when(converter.stringConverter( 1)).thenReturn((double) 1);
        Mockito.when(converter.stringConverter( 3)).thenReturn((double) 3);
        Mockito.when(converter.stringConverter( 2)).thenReturn((double) 2);
        assertEquals(2, calculator.subtraction(3,1));
        assertEquals(7, calculator.subtraction(9,2));
    }

    @Test
    public void shouldMultiplyTwoPositiveIntegers(){
        Mockito.when(converter.stringConverter( 3)).thenReturn((double) 3);
        Mockito.when(converter.stringConverter( 2)).thenReturn((double) 2);
        assertEquals(9, calculator.multiply(3,3));
        assertEquals(6, calculator.multiply(2,3));
    }

    @Test
    public void shouldMultiplyTwoPositiveFloats(){
        Mockito.when(converter.stringConverter( 2.5f)).thenReturn(2.5);
        Mockito.when(converter.stringConverter( 3.0f)).thenReturn((double) 3);
        Mockito.when(converter.stringConverter( 2.0f)).thenReturn((double) 2);
        assertEquals(7.5, calculator.multiply(3.0f, 2.5f));
        assertEquals(5.0, calculator.multiply(2.5f,2.0f));
    }

    @Test
    public void shouldDivideTwoPositiveFloats(){
        Mockito.when(converter.stringConverter( 9.0f)).thenReturn((double) 9);
        Mockito.when(converter.stringConverter( 0.0f)).thenReturn((double) 0);
        Mockito.when(converter.stringConverter( 5.0f)).thenReturn((double) 5);
        Mockito.when(converter.stringConverter( 3.0f)).thenReturn((double) 3);
        Mockito.when(converter.stringConverter( 2.0f)).thenReturn((double) 2);
        assertEquals(3.0, calculator.divide(9.0f,3.0f));
        assertEquals(2.5, calculator.divide(5.0f,2.0f));
        assertEquals("Cannot divide by zero", calculator.divide(9.0f,0.0f));
    }

    @Test
    public void shouldDivideTwoPositiveIntegers(){
        Mockito.when(converter.stringConverter( 8)).thenReturn((double) 8);
        Mockito.when(converter.stringConverter( 4)).thenReturn((double) 4);
        Mockito.when(converter.stringConverter( 2)).thenReturn((double) 2);
        Mockito.when(converter.stringConverter( 0)).thenReturn((double) 0);
        assertEquals(4.0, calculator.divide(8,2));
        assertEquals(2.0, calculator.divide(4,2));
        assertEquals("Cannot divide by zero", calculator.divide(8,0));
    }

    @Test
    public void shouldSubtractTwoNameStrings(){


        Mockito.when(converter.stringConverter( "two")).thenReturn((double) 2);
        Mockito.when(converter.stringConverter( "one")).thenReturn((double) 1);
        assertEquals(1, calculator.subtraction("two","one"));
    }

    @Test
    public void shouldMultiplyTwoNameStrings(){

        Mockito.when(converter.stringConverter( "two")).thenReturn((double) 2);
        Mockito.when(converter.stringConverter( "one")).thenReturn((double) 1);
        assertEquals(2, calculator.multiply("one","two"));
    }

    @Test
    public void shouldDivideTwoNameStrings(){

        Mockito.when(converter.stringConverter( "four")).thenReturn((double) 4);
        Mockito.when(converter.stringConverter( "two")).thenReturn((double) 2);
        assertEquals(2.0, calculator.divide("four","two"));

    }
}