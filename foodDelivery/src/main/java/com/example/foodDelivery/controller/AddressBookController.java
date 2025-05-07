package com.example.foodDelivery.controller;

import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import com.example.foodDelivery.exception.DuplicateAddressException;
import com.example.foodDelivery.exception.NoEntriesException;
import com.example.foodDelivery.exception.NoEntryException;
import com.example.foodDelivery.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AddressBook Controller
 */
@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;


    /**
     * @param address
     * @return Address
     * @throws DuplicateAddressException
     */
    @PostMapping
    public ResponseEntity<Address> addAddress(Address address) throws DuplicateAddressException {
        Address createdAddress= iAddressBookService.addAddress(address);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }


    /**
     * @param firstName
     * @param lastName
     * @return ResponseEntity<Address>
     * @throws NoEntryException
     */
    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<Address> getAddressById(@PathVariable String firstName, @PathVariable String lastName) throws NoEntryException{
        AddressId addressId = new AddressId(firstName, lastName);
        Address fetchedAddress= iAddressBookService.getAddressById(addressId);
        return new ResponseEntity<>(fetchedAddress, HttpStatus.OK);
    }

    /**
     * @return ResponseEntity<List<Address>>
     * @throws NoEntriesException
     */
    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() throws NoEntriesException{
        List<Address> fetchedAllAddress = iAddressBookService.getAllAddress();
        return new ResponseEntity<>(fetchedAllAddress,HttpStatus.OK);
    }

    /**
     * @param address
     * @return Address
     * @throws NoEntryException
     */
    @PutMapping
    public ResponseEntity<Address> updateAddress(Address address) throws NoEntryException {
        Address updatedAddress = iAddressBookService.updateAddress(address);
        return new ResponseEntity<>(updatedAddress, HttpStatus.OK);
    }

    @DeleteMapping("/{firstName}/{lastName}")
    public ResponseEntity<String> removeAddress(@PathVariable String firstName, @PathVariable String lastName) throws NoEntriesException, NoEntryException {
        AddressId addressId = new AddressId(firstName, lastName);
        String response = iAddressBookService.removeAddress(addressId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
