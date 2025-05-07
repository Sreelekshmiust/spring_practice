package com.ust.PharmaAssist.service;

import com.ust.PharmaAssist.dto.BatchVO;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;

/**
 * Pharma Service Interface
 */
public interface IPharmaService {
    /**
     * add new batch after validation
     * @param batchVO
     * @return boolean true/false
     * @throws PharmaBusinessException
     * @throws PharmaException
     */
    boolean addBatch(BatchVO batchVO)throws PharmaBusinessException, PharmaException;
}
