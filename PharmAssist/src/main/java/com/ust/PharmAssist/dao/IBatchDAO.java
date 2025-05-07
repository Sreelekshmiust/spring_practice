package com.ust.PharmAssist.dao;

import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

/**
 * DAO Interface
 */
public interface IBatchDAO {

    /**
     * adding the new batch to database
     * @param batchInfo
     * @return boolean true/false
     * @throws PharmaException
     */
    public boolean addDetails(BatchInfo batchInfo) throws PharmaException;

    /**
     * method to get the shipping charge from the database
     * @param medicineType
     * @param weightRange
     * @return BigDecimal
     * @throws PharmaBusinessException
     */
    public BigDecimal getShippingChargeFromDatabase(String medicineType, String weightRange) throws PharmaBusinessException;

    /**
     * checks if the medicine code already exist in database
     * @param medicineCode
     * @return boolean true/false
     */
    public boolean checkMedicineCode(String medicineCode);

    /**
     * checks if the batch code already exist in database
     * @param batchCode
     * @return boolean true/false
     */
    public boolean checkBatchCode(String batchCode);

    /**
     * @param pageable
     * @return Page<BatchInfo>
     */
    Page<BatchInfo> fetchBatch(Pageable pageable);
}
