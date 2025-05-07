<<<<<<< HEAD
package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/add")
    public double add(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.add(num1,num2);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.subtract(num1,num2);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping("/division")
    public double division(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.division(num1,num2);
    }
}
=======
package com.example.calculator.controller;

import com.example.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/add")
    public double add(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.add(num1,num2);
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.subtract(num1,num2);
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.multiply(num1,num2);
    }

    @GetMapping("/division")
    public double division(@RequestParam double num1,@RequestParam double num2){
        return calculatorService.division(num1,num2);
    }
}
>>>>>>> 7bfe80e89d517042f9dc0639a74600cf983dfb74
