package com.ust.PharmaAssist.dao;

import com.ust.PharmaAssist.constants.CommonConstants;
import com.ust.PharmaAssist.controller.PharmaController;
import com.ust.PharmaAssist.entity.BatchInfo;
import com.ust.PharmaAssist.entity.MedicineMaster;
import com.ust.PharmaAssist.entity.ShippingMaster;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;
import com.ust.PharmaAssist.repository.IBatchInfoRepository;
import com.ust.PharmaAssist.repository.IMedicineMasterRepository;
import com.ust.PharmaAssist.repository.IShippingMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

/**
 *  DAO layer for adding Batch implementing {@link IBatchDAO} interface
 */
@Repository
public class BatchDAO  implements IBatchDAO{

    private Logger logger = LoggerFactory.getLogger(BatchDAO.class);

    @Autowired
    IBatchInfoRepository iBatchInfoRepository;

    @Autowired
    IShippingMasterRepository iShippingMasterRepository;

    @Autowired
    private IMedicineMasterRepository iMedicineMasterRepository;

    /**
     * adding the new batch to database
     * @param batchInfo
     * @return boolean true/false
     * @throws PharmaException
     */
    public boolean addDetails(BatchInfo batchInfo) throws PharmaException {

        logger.info("Invoked method addDetails"+ batchInfo);
        try{
            iBatchInfoRepository.save(batchInfo);
            logger.info("Method Exit method_name addDetails:" +true);
            return true;
        }catch (Exception e){
            logger.error(CommonConstants.ERROR_MESSAGE);
            throw new PharmaException(CommonConstants.ERROR_MESSAGE);
        }
    }

    /**
     * method to get the shipping charge from the database
     * @param medicineType
     * @param weightRange
     * @return BigDecimal
     * @throws PharmaBusinessException
     */
    public BigDecimal getShippingChargeFromDatabase(String medicineType, String weightRange) throws PharmaBusinessException {
        logger.info("Invoked method getShippingChargeFromDatabase : Parameter 1 "+medicineType + "Parameter 2"+ weightRange);
        ShippingMaster shippingMaster = iShippingMasterRepository.findByMedicineTypeCodeAndWeightRange(medicineType,weightRange);
        if(shippingMaster!=null){
            logger.info("Method Exit method_name getShippingChargeFromDatabase :" +shippingMaster.getShippingCharge());
            return shippingMaster.getShippingCharge();
        }else{
            logger.error("Shipping charge not found for batch code ");
            throw new PharmaBusinessException("Shipping charge not found for batch code " );
        }

    }

    /**
     * checks if the medicine code already exist in database
     * @param medicineCode
     * @return boolean true/false
     */
    public boolean checkMedicineCode(String medicineCode){
        logger.info("Invoked method isValidMedicineCode : "+ medicineCode);
        Optional<MedicineMaster> medicineMasterOptional = iMedicineMasterRepository.findById(medicineCode);
        logger.info("Method Exit method_name isValidMedicineCode :" + medicineMasterOptional.isPresent());
        return medicineMasterOptional.isPresent();
    }

    /**
     * checks if the batch code already exist in database
     * @param batchCode
     * @return boolean true/false
     */
    public boolean checkBatchCode(String batchCode){
        logger.info("Invoked method isBatchCodeExists : "+ batchCode);
        Optional<BatchInfo> batchInfoOptional = iBatchInfoRepository.findById(batchCode);
        logger.info("Method Exit method_name isBatchCodeExists :" + batchInfoOptional.isPresent());
        return batchInfoOptional.isPresent();
    }
}
