package service;

import java.lang.Math;
import javax.swing.*;

public class Service {
    private double a, b;
    private String oper = "";

    public void clear_all(JLabel display){
        display.setText("0");
    }

    public void write_number(JLabel display, JButton button){
        if(display.getText().equals("0") || display.getText().equals("Infinity") || display.getText().equals("NaN")){
            display.setText(button.getText());
            return;
        }
        display.setText(display.getText() + button.getText());
    }
    public void write_dot(JLabel display, JButton button){
        if(!display.getText().contains(".")) {
            if(display.getText().equals("Infinity") || display.getText().equals("NaN")){
                display.setText("0");
            }
            display.setText(display.getText() + button.getText());
        }
    }

    public void reverse(JLabel display){
        if(!display.getText().equals("0")){
            double number = Double.parseDouble(display.getText()) * -1;
            if(number == (int) number){
                display.setText(String.valueOf((int) number));
                return;
            }
            display.setText(String.valueOf(number));
        }
    }

    public void set_oper(JLabel display, JButton button){
        oper = button.getText();
        set_a(display);
        clear_all(display);
    }

    public void set_a(JLabel display) {
        a = Double.parseDouble(display.getText());
    }

    public void set_b(JLabel display) {
        b = Double.parseDouble(display.getText());
    }

    public void calculate(JLabel display){
        if(oper.isEmpty()){
            System.out.println("vazio");
            return;
        }

        set_b(display);
        if(oper.equals("+")){
            if(sum(a, b) == (int) sum(a, b)){
                display.setText(String.valueOf((int) sum(a, b)));
            }
            else{
                display.setText(String.valueOf(sum(a, b)));
            }
        }
        else if(oper.equals("-")){
            if(subtraction(a, b) == (int) subtraction(a, b)){
                display.setText(String.valueOf((int) subtraction(a, b)));
            }
            else{
                display.setText(String.valueOf(subtraction(a, b)));
            }
        }
        else if(oper.equals("x")){
            if(multiplication(a, b) == (int) multiplication(a, b)){
                display.setText(String.valueOf((int) multiplication(a, b)));
            }
            else{
                display.setText(String.valueOf(multiplication(a, b)));
            }
        }
        else if(oper.equals("/")){
            if(division(a, b) == (int) division(a, b)){
                display.setText(String.valueOf((int) division(a, b)));
            }
            else{
                display.setText(String.valueOf(division(a, b)));
            }
        }
        a = 0;
        b = 0;
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

    public void sqrt(JLabel display){
        display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
    }

    public void percentage(JLabel display){
        display.setText(String.valueOf(Double.parseDouble(display.getText()) / 100));
    }

}
