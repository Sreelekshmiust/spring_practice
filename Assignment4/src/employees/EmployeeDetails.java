package employees;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDetails {
    public void details(){
         List<Employee> employeeList = new ArrayList<>();
         employeeList.add(new Employee(1, "John Doe", 30, "Marketing", 5.5, 60000.0));
         employeeList.add(new Employee(2, "Jane Smith", 28, "Marketing", 3.5, 55000.0));
         employeeList.add(new Employee(3, "Michael Johnson", 35, "Finance", 8.0, 75000.0));
         employeeList.add(new Employee(4, "Emily Davis", 32, "Human Resources", 6.0, 65000.0));
         employeeList.add(new Employee(5, "David Brown", 40, "Operations", 10.0, 80000.0));

         long totalNumber = employeeList.stream().count();
         System.out.println("The total number of employees are " + totalNumber);

        Map<String,List<String>> groupByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment,Collectors.mapping(employee -> employee.getEmployeeName(),Collectors.toList())));
        System.out.println(groupByDepartment);

        Optional<Double> totalSalary = employeeList.stream().map(Employee::getEmployeeSalary).reduce((x, y)->x+y);
        System.out.println("The total salary of the employees is " + totalSalary.get());

       Map<String,Double> totalSalaryEachDepatment = employeeList.stream().collect(Collectors.groupingBy(Employee::getEmployeeDepartment,Collectors.summingDouble(Employee::getEmployeeSalary)));
        System.out.println("the total salary in each department are " + totalSalaryEachDepatment);

       List<Employee> sortedAgeEmployeeList = employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeAge)).collect(Collectors.toList());
        System.out.println("the sorted employee list based on age is " );
        for(Employee emp: sortedAgeEmployeeList){
            System.out.println(emp);
        }

        List<Employee> sortedExperienceEmployeeList = employeeList.stream().sorted(Comparator.comparing(Employee::getEmployeeExperience)).collect(Collectors.toList());
        System.out.println("the sorted employee list based on experience is " );
        for(Employee emp: sortedExperienceEmployeeList){
            System.out.println(emp);
        }
    }

}
