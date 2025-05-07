import countries.Country;
import employees.EmployeeDetails;

public class Main {
    public static void main(String[] args) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.details();
        Country country = new Country();
        country.longestCountry();
    }
}