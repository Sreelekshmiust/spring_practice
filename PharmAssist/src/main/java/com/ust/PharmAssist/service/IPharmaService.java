package com.ust.PharmAssist.service;

import com.ust.PharmAssist.dto.BatchVO;
import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Pharma Service Interface
 */
public interface IPharmaService {
    /**
     * add new batch after validation
     *
     * @param batchVO
     * @return boolean true/false
     * @throws PharmaBusinessException
     * @throws PharmaException
     */
    boolean addBatch(BatchVO batchVO) throws PharmaBusinessException, PharmaException;


    /**
     * @param pageable
     * @return Page<BatchInfo>
     */
    Page<BatchInfo> fetchBatch(Pageable pageable);
}
