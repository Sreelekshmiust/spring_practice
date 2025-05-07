<<<<<<< HEAD
package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double num1, double num2) {
        return num1+num2;
    }

    public double subtract(double num1, double num2) {
        return num1-num2;
    }

    public double multiply(double num1, double num2) {
        return num1*num2;
    }

    public double division(double num1, double num2) {

        if(num2==0){
            throw new ArithmeticException("The divisor should not be 0");
        }
        return num1/num2;
    }
}
=======
package com.example.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double add(double num1, double num2) {
        return num1+num2;
    }

    public double subtract(double num1, double num2) {
        return num1-num2;
    }

    public double multiply(double num1, double num2) {
        return num1*num2;
    }

    public double division(double num1, double num2) {

        if(num2==0){
            throw new ArithmeticException("The divisor should not be 0");
        }
        return num1/num2;
    }
}
>>>>>>> 7bfe80e89d517042f9dc0639a74600cf983dfb74
