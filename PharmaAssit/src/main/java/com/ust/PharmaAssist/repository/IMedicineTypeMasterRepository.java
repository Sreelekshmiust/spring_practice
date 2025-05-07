package com.ust.PharmaAssist.repository;

import com.ust.PharmaAssist.entity.MedicineTypeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MedicineTypeMaster Repository
 */
@Repository
public interface IMedicineTypeMasterRepository extends JpaRepository<MedicineTypeMaster,String> {
}
