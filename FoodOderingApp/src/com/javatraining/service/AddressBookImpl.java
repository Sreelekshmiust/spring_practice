package com.javatraining.service;

import com.javatraining.exceptions.DuplicateAddressException;
import com.javatraining.exceptions.NoEntriesException;
import com.javatraining.exceptions.NoEntryException;
import com.javatraining.model.Address;

import java.util.HashSet;
import java.util.Set;

public class AddressBookImpl implements IAddressBook{
    private Set<Address> addressBook=new HashSet<>();

    /**
     * @param address
     * @return boolean true/false
     * @throws DuplicateAddressException
     * @throws NullPointerException
     */
    @Override
    public synchronized boolean addAddress(Address address) throws DuplicateAddressException, NullPointerException {
        final String METHOD_NAME = "addAddress";
        System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + address);
        if (address == null) {
            throw new NullPointerException("Address Reference Is Null");
        }
        boolean addAddressFlag = addressBook.add(address);
        if (!addAddressFlag) {
            throw new DuplicateAddressException("Address Might Be Duplicated !!! Have A Look Into");
        }
        System.out.println("Method Response:" + this.getClass().getName() + ":" + addAddressFlag);
        return addAddressFlag;
    }

    /**
     * @param firstName
     * @return boolean true/false
     * @throws NoEntriesException
     * @throws NoEntryException
     * @throws NullPointerException
     */
    @Override
    public synchronized boolean removeAddress(String firstName) throws NoEntriesException, NoEntryException, NullPointerException {
        final String METHOD_NAME = "removeAddress";
        System.out.println("Method Invoked:" + this.getClass().getName() + ":" + METHOD_NAME + ":" + firstName);
        boolean addressRemoveFlag;
        if (firstName == null || firstName.isEmpty() || firstName.isBlank()) {
            throw new NullPointerException("First Name Either Null||Empty||Blank Do Check!!!");
        }
        if (addressBook.isEmpty()) {
            throw new NoEntriesException("No Entries So Far In The Address Book!!!");
        } else {
            addressRemoveFlag = addressBook.removeIf(address -> firstName.equals(address.getFirstName()));
        if (!addressRemoveFlag){
                throw new NoEntryException("No Entry Found");
            }
        }
        System.out.println("Method Response:" + this.getClass().getName() + ":" + addressRemoveFlag);
        return addressRemoveFlag;
    }

    /**
     * @return Set<Address>
     * @throws NoEntriesException
     */
    @Override
    public Set<Address> getAllAddressEntries() throws NoEntriesException {
        return this.addressBook;
    }
}
