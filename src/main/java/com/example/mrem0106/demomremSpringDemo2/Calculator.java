package com.example.mrem0106.demomremSpringDemo2;

public class Calculator {

    public double calculate (double a, double b, Operator op) {
        if (op == Operator.plus) {
            return a + b;
        }
        else if (op == Operator.minus) {
            return a - b;
        }
        else if (op == Operator.mal) {
            return a * b;
        }
        else if (op == Operator.geteilt) {
            return a / b;
        }
        return Double.NaN;
    }

    public Operator stringToEnum (String c) {
        if (c.equals("+") || c.equalsIgnoreCase("plus")) {
            return Operator.plus;
        }
        else if (c.equals("-") || c.equalsIgnoreCase("minus")) {
            return Operator.minus;
        }
        else if (c.equals("*") || c.equalsIgnoreCase("mal")) {
            return Operator.mal;
        }
        else if (c.equals("/") || c.equalsIgnoreCase("geteilt")) {
            return Operator.geteilt;
        }
        return null;
    }
}
