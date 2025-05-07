package com.employee.details.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @NotNull
    private Integer employeeId;
    @NotEmpty(message = "Employee name must not be empty")
    private String employeeName;
    @NotEmpty(message = "Employee department must not be empty")
    private  String employeeDepartment;
    List<String> skills;
    private float salary;
}
