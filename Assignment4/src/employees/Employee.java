package employees;

public class Employee {

    private Integer employeeId;
    private String employeeName;
    private Integer employeeAge;
    private String employeeDepartment;
    private double employeeExperience;
    private double employeeSalary;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, Integer employeeAge, String employeeDepartment, double employeeExperience, double employeeSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeDepartment = employeeDepartment;
        this.employeeExperience = employeeExperience;
        this.employeeSalary = employeeSalary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public double getEmployeeExperience() {
        return employeeExperience;
    }

    public void setEmployeeExperience(double employeeExperience) {
        this.employeeExperience = employeeExperience;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeExperience=" + employeeExperience +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
