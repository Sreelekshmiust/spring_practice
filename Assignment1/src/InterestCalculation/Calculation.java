package InterestCalculation;

import java.util.Scanner;

public interface Calculation {

    public void simpleInterest(float principal, float rate, float time);
    public void compoundInterest(float principal, float rate, float time, float numberOfTime);

}
