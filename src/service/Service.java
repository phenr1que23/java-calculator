package service;

import java.lang.Math;

public class Service {
    private double a, b;
    private String oper;

    public double calculate(double a, double b, String oper) {
        double result;
        switch (oper) {
            case "+" -> {
                result = sum(a, b);
                return result;
            }
            case "-" -> {
                result = subtraction(a, b);
                return result;
            }
            case "x" -> {
                result = multiplication(a, b);
                return result;
            }
            case "/" -> {
                result = division(a, b);
                return result;
            }
        }
        return 0;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setOper(String oper){
        this.oper = oper;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getOper() {
        return oper;
    }

    public double sum(double a, double b){
        return a + b;
    }

    public double subtraction(double a, double b){
        return a - b;
    }

    public double multiplication(double a, double b){
        return a * b;
    }

    public double division(double a, double b){
        if(b == 0) throw new ArithmeticException("Division by zero");
        return a/b;
    }

    public double sqrt(){
        return Math.sqrt(a);
    }

    public double percentage(){
       return a / 100;
    }
}
