package InterestCalculation;
import java.util.Scanner;


public class Interest implements Calculation{

    @Override
    public void simpleInterest(float principal, float rate, float time) {

        float si = principal*rate*time;
        System.out.println("The simple interest is " + si);
    }

    @Override
    public void compoundInterest(float principal, float rate, float time, float numberOfTime) {

        float amount = principal * (float) Math.pow((1 + rate / numberOfTime), numberOfTime * time);
        float ci = amount - principal;
        System.out.println("The compound interest is " + ci);
    }

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the principal amount: ");
            float principal = scanner.nextFloat();
            if(principal<=0){
                throw  new CustomException("The principal amount cannot be null");
            }
            System.out.print("Enter the annual interest rate : ");
            float rate = scanner.nextFloat();
            if(rate<=0){
                throw  new CustomException("The rate cannot be null");
            }
            System.out.print("Enter the time period : ");
            float time = scanner.nextFloat();
            if(time<=0){
                throw  new CustomException("The time cannot be null");
            }
            System.out.print("Enter the number of time interest compounded : ");
            float numberOfTime = scanner.nextFloat();
            if(numberOfTime<=0){
                throw  new CustomException("The number of time interest compounded cannot be null");
            }

            Interest interest = new Interest();
            interest.simpleInterest(principal,rate,time);
            interest.compoundInterest(principal,rate,time,numberOfTime);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
