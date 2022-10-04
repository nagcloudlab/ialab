package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    private Calc calc;
    @BeforeEach
    public void setup(){
        calc = new Calc();
    }
    @Test
    public void addTest(){
        assertEquals(10, calc.add(5,5));
    }
}
