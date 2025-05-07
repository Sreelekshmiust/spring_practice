package com.example.employeeDetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "address")
    private String address;
//    @ManyToOne
//    @JoinColumn(name = "employee_id",insertable=false,updatable = false)
//    @JsonIgnore
//    private Employee employee;


//    public Address(String address) {
//        this.address = address;
//    }

}
