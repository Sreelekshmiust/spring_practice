package dateTimeApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTime {

    public void compareCurrentDate(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the date in YYYY-MM-DD format :" );
        String dateString = scn.nextLine();
        LocalDate date= LocalDate.parse(dateString);
        LocalDate currentdate = LocalDate.now();
        if(date.isAfter(currentdate)){
            System.out.println("The given date is after the current date");
        } else if (date.isBefore(currentdate)) {
            System.out.println("the given date is before the current date");
        } else if (date.isEqual(currentdate)) {
            System.out.println("the given date is the current date");
        }
        else {
            System.out.println("Invalid Date");
        }
    }

    public void changeFormat(){

        LocalDate date = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String formattedDate = date.format(dateTimeFormatter);
        System.out.println("the formatted date is " + formattedDate);
    }
}
