package com.employee.details.service;

import com.employee.details.entities.Employee;
import com.employee.details.exception.EmployeeAlreadyExist;
import com.employee.details.exception.EmployeeNotFound;
import com.employee.details.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> createEmployee(List<Employee> employeeList) throws EmployeeAlreadyExist {

        List<Employee> employees = new ArrayList<>();
        for(Employee employee: employeeList) {
            Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
            if (optionalEmployee.isPresent()) {
                throw new EmployeeAlreadyExist("Employee with id " + employee.getEmployeeId() + " already exists");
            }
            employees.add(employee);
            employeeRepository.save(employee);
        }
            return employees;
    }

    public Employee fetchEmployeeById(Integer employeeId) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFound("Employee with id " + employeeId + " not found");
        }
        Employee fetchedEmployee = optionalEmployee.get();
        return fetchedEmployee;
    }

    public List<Employee> fetchEmployeeList() {

        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if(optionalEmployee.isPresent()) {
            Employee updatedEmployee = optionalEmployee.get();
            updatedEmployee.setEmployeeName(employee.getEmployeeName());
            updatedEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
            updatedEmployee.setSalary(employee.getSalary());
            employeeRepository.save(updatedEmployee);
            return updatedEmployee;
        }
        throw new EmployeeNotFound("The employee with id " +employee.getEmployeeId() + " not found");
    }

    public String deleteEmployee(Integer employeeId) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFound("Employee with id " + employeeId + " not found");
        }
        employeeRepository.deleteById(employeeId);
        return "The employee with id " +employeeId + " is deleted";
    }
}
