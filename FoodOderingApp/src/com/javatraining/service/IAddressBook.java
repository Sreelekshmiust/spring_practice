package com.javatraining.service;

import com.javatraining.exceptions.NoEntriesException;
import com.javatraining.exceptions.NoEntryException;
import com.javatraining.exceptions.DuplicateAddressException;
import com.javatraining.model.Address;

import java.util.Set;

/**
 * Service Interface
 */
public interface IAddressBook {

    /**
     * @param address
     * @return boolean true/false
     * @throws DuplicateAddressException
     * @throws NullPointerException
     */
    public boolean addAddress(final Address address) throws DuplicateAddressException,NullPointerException;

    /**
     * @param firstName
     * @return boolean true/false
     * @throws NoEntriesException
     * @throws NoEntryException
     * @throws NullPointerException
     */
    public boolean removeAddress(final String firstName) throws NoEntriesException, NoEntryException,NullPointerException;

    /**
     * @return Set<Address>
     * @throws NoEntriesException
     */
    default Set<Address> getAllAddressEntries()throws NoEntriesException{
        return null;
    }
}
