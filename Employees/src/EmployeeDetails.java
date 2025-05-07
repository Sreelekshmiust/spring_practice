import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetails {

    public void findSkill() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Java", 55000.566));
        employeeList.add(new Employee(2, "Mary", "ython", 65000));
        employeeList.add(new Employee(3, "Sara", "React", 75000));
        employeeList.add(new Employee(4, "Michael", "ython", 72000));
        employeeList.add(new Employee(5, "Emma", "C++", 68000));
        employeeList.add(new Employee(6, "Sara", "JavaScript", 75000));

        try {
            List<Employee> pythonEmployees = employeeList.stream().filter(emp -> emp.getEmployeeSkill().equalsIgnoreCase("Python")).collect(Collectors.toList());

            if (pythonEmployees.isEmpty()) {
                throw new EmployeeSkillException("No employee has skill in python");
            } else {
                for (Employee emp : pythonEmployees) {
                    System.out.println(emp);
                }
            }
        } catch (EmployeeSkillException e) {
            System.out.println(e.getMessage());
        }
    }

}
