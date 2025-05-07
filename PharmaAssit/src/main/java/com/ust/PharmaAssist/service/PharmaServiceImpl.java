package com.ust.PharmaAssist.service;

import com.ust.PharmaAssist.constants.CommonConstants;
import com.ust.PharmaAssist.dao.IBatchDAO;
import com.ust.PharmaAssist.dto.BatchVO;
import com.ust.PharmaAssist.entity.BatchInfo;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;
import com.ust.PharmaAssist.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Pharma Service Implementation of {@link IPharmaService}
 */

@Service
public class PharmaServiceImpl implements IPharmaService {

    private Logger logger = LoggerFactory.getLogger(PharmaServiceImpl.class);

    @Autowired
    private IBatchDAO ibatchDAO;

    @Autowired
    private Validation validation;



    /**
     * add new batch after validation
     * @param batchVO
     * @return boolean true/false
     * @throws PharmaException
     * @throws PharmaBusinessException
     */
    @Override
    public boolean addBatch(BatchVO batchVO) throws PharmaException, PharmaBusinessException {
        logger.info("Invoked service method addBatch"+batchVO);
        validation.validateMandatoryFields(batchVO);
        validation.validateBatchVO(batchVO);

        BigDecimal shippingCharges = calculateShippingCharges(batchVO);

        BatchInfo batchInfo = new BatchInfo();
        batchInfo.setBatchCode(batchVO.getBatchCode());
        batchInfo.setWeight(batchVO.getWeight());
        batchInfo.setPrice(batchVO.getPrice());
        batchInfo.setShippingCharge(shippingCharges);
        batchInfo.setMedicineCode(batchVO.getMedicineCode());
        batchInfo.setMedicineTypeCode(batchVO.getMedicineTypeCode());
        batchInfo.setCareLevel(generateCareLevel(batchVO.getMedicineTypeCode()));
        logger.info("Method Exit method_name addBatch :" + ibatchDAO.addDetails(batchInfo));
        return ibatchDAO.addDetails(batchInfo);
    }

    /**
     * calculate the shipping charges for the new batch
     * @param batchVO
     * @return BigDecimal
     * @throws PharmaBusinessException
     */
     BigDecimal calculateShippingCharges(BatchVO batchVO) throws PharmaBusinessException {

        logger.info("Invoked method calculateShippingCharges "+ batchVO);
        BigDecimal weight = batchVO.getWeight();
        String medicineType = batchVO.getMedicineTypeCode();
        BigDecimal shippingCharge;

        String weightRange;
        if (weight.compareTo(BigDecimal.valueOf(500)) <= 0) {
            weightRange = CommonConstants.WEIGHT_ONE;
        } else if (weight.compareTo(BigDecimal.valueOf(1000)) <= 0) {
            weightRange = CommonConstants.WEIGHT_TWO;
        } else {
            weightRange = CommonConstants.WEIGHT_THREE;
        }
        BigDecimal actualShippingCharge = ibatchDAO.getShippingChargeFromDatabase(medicineType,weightRange);
        if (batchVO.getRefrigeration().equalsIgnoreCase("yes")) {
            BigDecimal refrigerationCharge = actualShippingCharge.multiply(BigDecimal.valueOf(0.05));
            shippingCharge = actualShippingCharge.add(refrigerationCharge);
        } else {
            shippingCharge = actualShippingCharge;
        }
        logger.info("Method Exit method_name : calculateShippingCharges " +shippingCharge);
        return shippingCharge;
    }

    /**
     * generate the care level message
     * @param medicineType
     * @return
     */
    private String generateCareLevel(String medicineType){
        logger.info("Invoked method generateCareLevel "+medicineType);
        if (medicineType.equalsIgnoreCase("C")){
            logger.info("Method Exit method_name generateCareLevel: " +CommonConstants.NORMAL_CARE_LEVEL);
            return CommonConstants.NORMAL_CARE_LEVEL;
        } else if (medicineType.equalsIgnoreCase("T")) {
            logger.info("Method Exit method_name generateCareLevel: " +CommonConstants.HIGH_CARE_LEVEL);
            return CommonConstants.HIGH_CARE_LEVEL;
        }else {
            logger.info("Method Exit method_name generateCareLevel: "+CommonConstants.EXTREMELY_HIGH_CARE_LEVEL);
            return CommonConstants.EXTREMELY_HIGH_CARE_LEVEL;
        }
    }
}
