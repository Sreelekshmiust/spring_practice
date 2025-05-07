package com.ust.PharmAssist.service;

import com.ust.PharmAssist.dao.IBatchDAO;
import com.ust.PharmAssist.dto.BatchVO;
import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import com.ust.PharmAssist.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


public class PharmaServiceImplTest {

    @Mock
    private IBatchDAO ibatchDAO;

    @Mock
    private Validation validation;

    @InjectMocks
    PharmaServiceImpl pharmaServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addBatchTest() throws PharmaException, PharmaBusinessException {

        BatchVO batchVO = new BatchVO();
        batchVO.setBatchCode("BTC-1238");
        batchVO.setMedicineCode("MC_301");
        batchVO.setWeight(BigDecimal.valueOf(1200));
        batchVO.setPrice(BigDecimal.valueOf(300));
        batchVO.setMedicineTypeCode("C");
        batchVO.setRefrigeration("no");
        when(ibatchDAO.addDetails(Mockito.any())).thenReturn(true);
        when(ibatchDAO.getShippingChargeFromDatabase(Mockito.any(),Mockito.any())).thenReturn(BigDecimal.valueOf(1500));
        Boolean response = pharmaServiceImpl.addBatch(batchVO);
        Assertions.assertTrue(response);
    }

    @Test
    public void FetchBatchTest() {

        BatchInfo batchInfo1 = new BatchInfo();
        BatchInfo batchInfo2 = new BatchInfo();
        BatchInfo batchInfo3 = new BatchInfo();
        List<BatchInfo> batchInfos = Arrays.asList(batchInfo1, batchInfo2, batchInfo3);
        Page<BatchInfo> batchPage = new PageImpl<>(batchInfos);
        Mockito.when(ibatchDAO.fetchBatch(Mockito.any(Pageable.class))).thenReturn(batchPage);
        Page<BatchInfo> result = pharmaServiceImpl.fetchBatch(Pageable.unpaged());
        Assertions.assertEquals(batchInfos.size(), result.getTotalElements());
        Assertions.assertEquals(batchInfos, result.getContent());
    }

}
