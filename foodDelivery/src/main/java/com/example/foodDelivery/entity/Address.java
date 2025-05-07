package com.example.foodDelivery.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *Address Entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address implements Serializable {

    @EmbeddedId
    private AddressId addressId;
    private Integer flatId;
    private String streetName;
    private String city;
    private String stateName;
    private Long pincode;

}
