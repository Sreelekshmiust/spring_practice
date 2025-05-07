package com.example.foodDelivery.dao.daoImpl;

import com.example.foodDelivery.dao.IAddressDAO;
import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import com.example.foodDelivery.exception.DuplicateAddressException;
import com.example.foodDelivery.exception.NoEntriesException;
import com.example.foodDelivery.exception.NoEntryException;
import com.example.foodDelivery.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * AddressDAO Implementation
 */
@Repository
public class AddressDAOImpl implements IAddressDAO {

    private Set<Address> addressBook=new HashSet<>();

    @Autowired
    IAddressRepository iAddressRepository;

    /**
     * @param address
     * @return Address
     * @throws DuplicateAddressException
     */
    @Override
    public Address addAddress(Address address) throws DuplicateAddressException {
        boolean addAddressFlag = addressBook.add(address);
        if(!addAddressFlag){
            throw new DuplicateAddressException("Address might be duplicated");
        }
        return iAddressRepository.save(address);
    }

    /**
     * @param addressId
     * @return Address
     * @throws NoEntryException
     */
    @Override
    public Address getAddressById(AddressId addressId) throws NoEntryException {
        Optional<Address> optionalAddress = iAddressRepository.findById(addressId);
        Address fetchedAddress = optionalAddress.get();
        if(optionalAddress.isEmpty()){
            throw new NoEntryException("Address not found");
        }
        return fetchedAddress;
    }

    /**
     * @return LIst<Address>
     * @throws NoEntriesException
     */
    @Override
    public List<Address> getAllAddress() throws NoEntriesException {
        if(addressBook.isEmpty()){
            throw new NoEntriesException("No addresses");
        }
        return iAddressRepository.findAll();
    }

    /**
     * @param address
     * @return Address
     * @throws NoEntryException
     */
    @Override
    public Address updateAddress(Address address) throws NoEntryException {
        Optional<Address> optionalAddress = iAddressRepository.findById(address.getAddressId());
        if (optionalAddress.isPresent()){
            Address updatedAddress = optionalAddress.get();
            updatedAddress.setFlatId(address.getFlatId());
            updatedAddress.setStreetName(address.getStreetName());
            updatedAddress.setCity(address.getCity());
            updatedAddress.setStateName(address.getStateName());
            updatedAddress.setPincode(address.getPincode());
            addressBook.remove(optionalAddress);
            addressBook.add(updatedAddress);
            return updatedAddress;
        }
        throw new NoEntryException("Address not found");
    }

    /**
     * @param addressId
     * @return String
     * @throws NoEntryException
     * @throws NoEntriesException
     */
    @Override
    public String removeAddress(AddressId addressId) throws NoEntryException, NoEntriesException {
        if (addressBook.isEmpty()){
            throw new NoEntriesException("No Entries of addresses");
        }
        Optional<Address> optionalAddress = iAddressRepository.findById(addressId);
        if (optionalAddress.isEmpty()){
            throw new NoEntryException("No entry found");
        }
        iAddressRepository.deleteById(addressId);
        return "The address is deleted";
    }
}
