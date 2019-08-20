package com.example.mrem0106.demomremSpringDemo2;

public class CalculatorData {
    private String num1;
    private String num2;
    private Double num1d;
    private Double num2d;
    private Double result;
    private String operator;



    public CalculatorData(String num1, String num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
        calculate();
    }

    public CalculatorData() {
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
        num1d = Double.parseDouble(num1);
        calculate();
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
        num2d = Double.parseDouble(num2);
        calculate();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        calculate();
    }

    public Double getResult() {
        return result;
    }

    private void calculate(){
        Calculator calculator = new Calculator();
        result = Double.NaN;
        if (operator.equalsIgnoreCase("*")){
            result = num1d * num2d;
        } else if (operator.equalsIgnoreCase("/")){
            result = num1d / num2d;
        } else if (operator.equalsIgnoreCase("+")){
            result = num1d + num2d;
        } else if (operator.equalsIgnoreCase("-")){
            result = num1d - num2d;
        }
    }
}
