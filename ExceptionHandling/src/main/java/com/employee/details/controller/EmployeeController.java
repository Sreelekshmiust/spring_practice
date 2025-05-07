package com.employee.details.controller;

import com.employee.details.entities.Employee;
import com.employee.details.exception.EmployeeAlreadyExist;
import com.employee.details.exception.EmployeeNotFound;
import com.employee.details.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<List<Employee>> createEmployee(@Valid @RequestBody List<Employee> employeeList) throws EmployeeAlreadyExist {

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeList));
    }

    @GetMapping("{employeeId}")
    public  ResponseEntity<Employee> fetchEmployeeById(@PathVariable Integer employeeId) throws EmployeeNotFound {

        return ResponseEntity.ok(employeeService.fetchEmployeeById(employeeId));
    }

    @GetMapping
    public List<Employee> fetchEmployeeList() {

        return employeeService.fetchEmployeeList();
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFound {

            return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) throws EmployeeNotFound {

        return employeeService.deleteEmployee(employeeId);
    }
}
