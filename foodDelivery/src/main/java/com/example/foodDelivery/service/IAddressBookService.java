package com.example.foodDelivery.service;

import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import com.example.foodDelivery.exception.DuplicateAddressException;
import com.example.foodDelivery.exception.NoEntriesException;
import com.example.foodDelivery.exception.NoEntryException;

import java.util.List;

/**
 * Service Interface
 */
public interface IAddressBookService {

    /**
     * @param address
     * @return Address
     */
    public Address addAddress(Address address) throws DuplicateAddressException;

    /**
     * @param addressId
     * @return Address
     * @throws NoEntryException
     */
    public Address getAddressById(AddressId addressId) throws NoEntryException;

    /**
     * @return List<Address>
     * @throws NoEntriesException
     */
    public List<Address> getAllAddress() throws NoEntriesException;

    /**
     * @param address
     * @return Address
     */
    public Address updateAddress(Address address) throws NoEntryException;

    /**
     * @param addressId
     * @return String
     */
    public String removeAddress(AddressId addressId) throws NoEntryException, NoEntriesException;
}
