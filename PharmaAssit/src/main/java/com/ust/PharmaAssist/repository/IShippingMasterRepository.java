package com.ust.PharmaAssist.repository;

import com.ust.PharmaAssist.entity.ShippingMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ShippingMaster Repository
 */
@Repository
public interface IShippingMasterRepository extends JpaRepository<ShippingMaster,String> {
    /**
     * @param medicineType
     * @param weightRange
     * @return ShippingMaster
     */
    ShippingMaster findByMedicineTypeCodeAndWeightRange(String medicineType, String weightRange);
}
