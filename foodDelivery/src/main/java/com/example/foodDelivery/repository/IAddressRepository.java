package com.example.foodDelivery.repository;

import com.example.foodDelivery.entity.Address;
import com.example.foodDelivery.entity.AddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address Repository
 */
@Repository
public interface IAddressRepository extends JpaRepository<Address, AddressId> {
}
