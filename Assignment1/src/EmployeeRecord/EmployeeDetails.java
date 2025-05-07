package EmployeeRecord;

import java.util.*;

public class EmployeeDetails {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(6, "John", "john@example.com", 55000.0, "Finance"));
        employees.add(new Employee(7, "Mary", "mary@example.com", 65000.0, "Development"));
        employees.add(new Employee(8, "Sara", "sara@example.com", 75000.0, "Sales"));
        employees.add(new Employee(9, "Michael", "michael@example.com", 72000.0, "HR"));
        employees.add(new Employee(10, "Emma", "emma@example.com", 68000.0, "Marketing"));
        employees.add(new Employee(8, "Sara", "sara@example.com", 75000.0, "Sales"));
        Set<Integer> employeeIDs = new HashSet<>();


        for (Employee record : employees) {
            employeeIDs.add(record.getEmpId());
        }
        List<Integer> sortedEmployeeIDs = new ArrayList<>(employeeIDs);
        sortedEmployeeIDs.sort(Collections.reverseOrder());
        Map<Integer, Employee> employeeInfo = new HashMap<>();

        for (int empID : sortedEmployeeIDs) {
            for (Employee record : employees) {
                if (record.getEmpId() == empID) {
                    employeeInfo.put(empID, record);
                    break;
                }
            }
        }
        for (int empID : sortedEmployeeIDs) {
            System.out.println("Details of Employee with id: " + empID);
            Employee ob = employeeInfo.get(empID);
            System.out.println("\tEmployee Name: " + ob.getEmpName());
            System.out.println("\tEmployee email: " + ob.getEmpSalary());
            System.out.println("\tEmployee Salary: " + ob.getEmpSalary());
            System.out.println("\tEmployee Department " + ob.getEmpDepartment());
        }
    }
}