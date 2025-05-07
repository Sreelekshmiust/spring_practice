package com.example.foodDelivery.service.serviceImpl;

import com.example.foodDelivery.dao.IAddressDAO;
import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import com.example.foodDelivery.exception.DuplicateAddressException;
import com.example.foodDelivery.exception.NoEntriesException;
import com.example.foodDelivery.exception.NoEntryException;
import com.example.foodDelivery.repository.IAddressRepository;
import com.example.foodDelivery.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AddressBook Service Implementation
 */
@Service
public class AddressBookServiceImpl implements IAddressBookService {

    @Autowired
    IAddressDAO iAddressDAO;

    /**
     * @param address
     * @return Address
     */
    @Override
    public Address addAddress(Address address) throws DuplicateAddressException {
        return iAddressDAO.addAddress(address);
    }

    /**
     * @param addressId
     * @return Address
     * @throws NoEntryException
     */
    @Override
    public Address getAddressById(AddressId addressId) throws NoEntryException {
        return iAddressDAO.getAddressById(addressId);
    }

    /**
     * @return List<Address>
     * @throws NoEntriesException
     */
    @Override
    public List<Address> getAllAddress() throws NoEntriesException {
        return iAddressDAO.getAllAddress();
    }

    /**
     * @param address
     * @return Address
     */
    @Override
    public Address updateAddress(Address address) throws NoEntryException {
        return iAddressDAO.updateAddress(address);
    }

    /**
     * @param addressId
     * @return String
     */
    @Override
    public String removeAddress(AddressId addressId) throws NoEntryException, NoEntriesException {
       return iAddressDAO.removeAddress(addressId);
    }
}
