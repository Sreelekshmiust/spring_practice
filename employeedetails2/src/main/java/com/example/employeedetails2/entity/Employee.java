package com.example.employeedetails2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private double salary;

    @Column(name = "skill")
    private String skill;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addressList;

}