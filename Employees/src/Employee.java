public class Employee {

    private Integer employeeId;
    private String employeeName;
    private String employeeSkill;
    private double salary;

    public Employee(Integer employeeId, String employeeName, String employeeSkill, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSkill = employeeSkill;
        this.salary = salary;
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

    public String getEmployeeSkill() {
        return employeeSkill;
    }

    public void setEmployeeSkill(String employeeSkill) {
        this.employeeSkill = employeeSkill;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSkill='" + employeeSkill + '\'' +
                ", salary=" + salary +
                '}';
    }
}
