package com.example.employeeDetails.service.serviceImpl;

import com.example.employeeDetails.entity.Address;
import com.example.employeeDetails.entity.Employee;
import com.example.employeeDetails.exception.AddressNotFound;
import com.example.employeeDetails.exception.EmployeeNotFound;
import com.example.employeeDetails.repository.AddressRepository;
import com.example.employeeDetails.repository.EmployeeRepository;
import com.example.employeeDetails.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Employee createEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFound("Employee with id " + employeeId + " not found");
        }
        Employee fetchedEmployee = optionalEmployee.get();
        return fetchedEmployee;
    }

    @Override
    public Address getAddressById(Long employeeId) throws AddressNotFound {
        Optional<Address> optionalAddress = addressRepository.findById(employeeId);
        if(optionalAddress.isEmpty()){
            throw new AddressNotFound("Address not found for the employee with id "+ employeeId );
        }
        Address fetchedAddress = optionalAddress.get();
        return fetchedAddress;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFound {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employeeId);
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setSkill(employee.getSkill());
            return employeeRepository.save(existingEmployee);
        } else {
            throw new EmployeeNotFound("Employee with id " + employeeId + " not found");
        }
    }

    @Override
    public Address updateAddress(Long employeeId, Address address) throws AddressNotFound {
        Optional<Address> existingAddressOptional = addressRepository.findById(employeeId);
        if (existingAddressOptional.isPresent()) {
            Address existingAddress = existingAddressOptional.get();
            existingAddress.setAddress(address.getAddress());
            return addressRepository.save(existingAddress);
        } else {
            throw new AddressNotFound("Address not found for the employee with id "+ employeeId );
        }
    }

    @Override
    public boolean deleteEmployee(Long employeeId) throws EmployeeNotFound {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
            return true;
        } else {
            throw new EmployeeNotFound("Employee with id " + employeeId + " not found");
        }
    }

    @Override
    public boolean deleteAddress(Long addressId) throws AddressNotFound {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            addressRepository.delete(optionalAddress.get());
            return true;
        } else {
            throw new AddressNotFound("Address not found for the employee with id "+ addressId );
        }
    }

}
