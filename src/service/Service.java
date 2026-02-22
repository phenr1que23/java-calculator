package service;

import java.lang.Math;

public class Service {
    public  double a, b;
    public  String oper = "";

    // Only those methods should be Service Functions

    public double calculate() {
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
        return a/b;
    }

    public double sqrt(){
        return Math.sqrt(a);
    }

    public double percentage(){
       return a / 100;
    }
}
