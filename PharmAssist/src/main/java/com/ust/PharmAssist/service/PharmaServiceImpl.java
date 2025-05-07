package com.ust.PharmAssist.service;

import com.ust.PharmAssist.constants.CommonConstants;
import com.ust.PharmAssist.dao.IBatchDAO;
import com.ust.PharmAssist.dto.BatchVO;
import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import com.ust.PharmAssist.validation.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Pharma Service Implementation of {@link IPharmaService}
 */

@Service
public class PharmaServiceImpl implements IPharmaService {

    private Logger logger = LoggerFactory.getLogger(PharmaServiceImpl.class);

   @Autowired
    IBatchDAO ibatchDAO;

   @Autowired
    Validation validation;



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
     * @param pageable
     * @return Page<BatchInfo>
     */
    @Override
    public Page<BatchInfo> fetchBatch(Pageable pageable) {
        logger.info("Invoked service method fetchBatch with pageable: " + pageable);
        Page<BatchInfo> batchPage = ibatchDAO.fetchBatch(pageable);
        logger.info("Method Exit method_name fetchBatch: " + batchPage);
        return batchPage;
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
            logger.debug("Method Exit method_name generateCareLevel: " +CommonConstants.NORMAL_CARE_LEVEL);
            return CommonConstants.NORMAL_CARE_LEVEL;
        } else if (medicineType.equalsIgnoreCase("T")) {
            logger.debug("Method Exit method_name generateCareLevel: " +CommonConstants.HIGH_CARE_LEVEL);
            return CommonConstants.HIGH_CARE_LEVEL;
        }else {
            logger.debug("Method Exit method_name generateCareLevel: "+CommonConstants.EXTREMELY_HIGH_CARE_LEVEL);
            return CommonConstants.EXTREMELY_HIGH_CARE_LEVEL;
        }
    }
}
