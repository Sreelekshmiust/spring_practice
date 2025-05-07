package com.example.employeeDetails.service;

import com.example.employeeDetails.entity.Address;
import com.example.employeeDetails.entity.Employee;
import com.example.employeeDetails.exception.AddressNotFound;
import com.example.employeeDetails.exception.EmployeeNotFound;

public interface IEmployeeService {

    public Employee createEmp(Employee employee);

    public Address createAddress(Address address);

    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFound;

    public Address getAddressById(Long employeeId) throws AddressNotFound;

    public Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFound;

    public Address updateAddress(Long employeeId, Address address) throws AddressNotFound;

    public boolean deleteEmployee(Long employeeId) throws EmployeeNotFound;

    public boolean deleteAddress(Long employeeId) throws AddressNotFound;
}
