package com.example.mrem0106.demomremSpringDemo2;

public class CalculatorDataString {
    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    private String num1;
    private String num2;
    private String result;
    private String operator;

    public CalculatorDataString() {
        num1="2";
        num2="3";
        result = "RESULT";
        operator = "+";
    }
}

