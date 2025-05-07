package com.javatraining.model;

import java.io.Serializable;

/**
 *
 */
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private int flatId;
    private String firstName;
    private String lastName;
    private long pincode;

    public Address() {
    }

    public Address(int flatId, String firstName, String lastName, long pincode) {
        this.flatId = flatId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pincode = pincode;
    }

    public int getFlatId() {
        return flatId;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "com.javatraining.exceptions.model.Address{" +
                "flatId=" + flatId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pincode=" + pincode +
                '}';
    }


}
