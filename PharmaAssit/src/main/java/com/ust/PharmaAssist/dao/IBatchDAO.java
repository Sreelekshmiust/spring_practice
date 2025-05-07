package com.ust.PharmaAssist.dao;

import com.ust.PharmaAssist.entity.BatchInfo;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;

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
}
