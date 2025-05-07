package question2;

import question2.exception.InvalidInputException;

import java.util.Scanner;

public class DivisionOperation {

    public void division() throws InvalidInputException {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Enter the first number: ");
            double firstNumber = scn.nextDouble();
            System.out.println("Enter the second number: ");
            double secondNumber = scn.nextDouble();
            if(secondNumber ==0){
                throw new InvalidInputException("please enter a valid divisor");
            }
            double result = firstNumber/secondNumber;
            System.out.println("The result of division between "+firstNumber +"and "+ secondNumber+ " is " +result);
        }catch (Exception e){
            e.printStackTrace();
            throw new InvalidInputException(e.getMessage());
        }
    }
}
