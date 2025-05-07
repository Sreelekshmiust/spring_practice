package question2;

import question2.exception.InvalidInputException;

public class Main {

    public static void main(String[] args) throws InvalidInputException {
        DivisionOperation divisionOperation = new DivisionOperation();
            try {
                divisionOperation.division();
            }catch (InvalidInputException ex){
                System.out.println("Error : " +ex.getMessage() );
            }
    }
}
