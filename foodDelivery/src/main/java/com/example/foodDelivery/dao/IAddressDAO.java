package com.example.foodDelivery.dao;

import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import com.example.foodDelivery.exception.DuplicateAddressException;
import com.example.foodDelivery.exception.NoEntriesException;
import com.example.foodDelivery.exception.NoEntryException;

import java.util.List;

/**
 * DAO Interface
 */
public interface IAddressDAO {

    /**
     * @param address
     * @return Address
     * @throws DuplicateAddressException
     */
    public Address addAddress(Address address) throws DuplicateAddressException;

    /**
     * @param addressId
     * @return Address
     * @throws NoEntryException
     */
    public Address getAddressById(AddressId addressId) throws NoEntryException;

    /**
     * @return LIst<Address>
     * @throws NoEntriesException
     */
    public List<Address> getAllAddress() throws NoEntriesException;

    /**
     * @param address
     * @return Address
     * @throws NoEntryException
     */
    public Address updateAddress(Address address) throws NoEntryException;

    /**
     * @param addressId
     * @return String
     * @throws NoEntryException
     * @throws NoEntriesException
     */
    public String removeAddress(AddressId addressId) throws NoEntryException, NoEntriesException;

}