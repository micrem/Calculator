package com.example.mrem0106.demomremSpringDemo2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp () {
        calculator = new Calculator();
    }

    @Test
    public void calculate() {
        Assert.assertEquals(3, calculator.calculate(1, 2, Operator.plus), 0);
        Assert.assertEquals(0.25, calculator.calculate(1, 4, Operator.geteilt), 0);
    }

    @Test
    public void stringToEnum() {
    }
}