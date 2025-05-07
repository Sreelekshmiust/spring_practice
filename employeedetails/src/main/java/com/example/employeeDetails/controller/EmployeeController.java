package com.example.employeeDetails.controller;

import com.example.employeeDetails.entity.Address;
import com.example.employeeDetails.entity.Employee;
import com.example.employeeDetails.exception.AddressNotFound;
import com.example.employeeDetails.exception.EmployeeNotFound;
import com.example.employeeDetails.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmp(employee), HttpStatus.CREATED);
    }

    @PostMapping("/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return new ResponseEntity<>(employeeService.createAddress(address),HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId) throws EmployeeNotFound {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long employeeId) throws AddressNotFound {
        Address address = employeeService.getAddressById(employeeId);
        if (address != null) {
            return new ResponseEntity<>(address, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) throws EmployeeNotFound {
        Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
        if (updatedEmployee != null) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/address/{employeeId}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long employeeId, @RequestBody Address address) throws AddressNotFound {
        Address updatedAddress = employeeService.updateAddress(employeeId, address);
        if (updatedAddress != null) {
            return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId) throws EmployeeNotFound {
        boolean deleted = employeeService.deleteEmployee(employeeId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee with ID " + employeeId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with ID " + employeeId + " not found.");
        }
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long addressId) throws AddressNotFound {
        boolean deleted = employeeService.deleteAddress(addressId);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Address with ID " + addressId + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address with ID " + addressId + " not found.");
        }
    }


}
