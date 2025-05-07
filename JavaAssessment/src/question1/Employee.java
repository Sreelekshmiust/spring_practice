package question1;

public class Employee {

    private Integer employeeId;
    private String employeeName;

    public Employee(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
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

    @Override
    public int hashCode() {
        return employeeId;
    }
    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        return employeeId == employee.employeeId;
    }

}
