package com.ust.PharmAssist.dao;

import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.entity.MedicineMaster;
import com.ust.PharmAssist.entity.ShippingMaster;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import com.ust.PharmAssist.repository.IBatchInfoRepository;
import com.ust.PharmAssist.repository.IMedicineMasterRepository;
import com.ust.PharmAssist.repository.IShippingMasterRepository;
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
import java.util.Optional;

public class BatchDAOTest {

    @InjectMocks
    BatchDAO batchDAO;

    @Mock
    IBatchInfoRepository iBatchInfoRepository;

    @Mock
    IMedicineMasterRepository iMedicineMasterRepository;

    @Mock
    IShippingMasterRepository iShippingMasterRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addDetailsTest() throws PharmaException {

        BatchInfo batchInfo = new BatchInfo();
        batchInfo.setBatchCode("BTC-1238");
        batchInfo.setMedicineCode("MC_301");
        batchInfo.setWeight(BigDecimal.valueOf(1200));
        batchInfo.setPrice(BigDecimal.valueOf(300));
        batchInfo.setMedicineTypeCode("C");
        batchInfo.setCareLevel("Normal");
        batchInfo.setShippingCharge(BigDecimal.valueOf(1500));
        Mockito.when(iBatchInfoRepository.save(Mockito.any())).thenReturn(batchInfo);
        Boolean response = batchDAO.addDetails(batchInfo);
        Assertions.assertTrue(response);
    }

    @Test
    public void getShippingChargeFromDatabaseTest() throws PharmaException, PharmaBusinessException {

        ShippingMaster shippingMaster = new ShippingMaster("C", "W3", BigDecimal.valueOf(1500));
        Mockito.when(iShippingMasterRepository.findByMedicineTypeCodeAndWeightRange(Mockito.any(), Mockito.any())).thenReturn(shippingMaster);
        BigDecimal response = batchDAO.getShippingChargeFromDatabase("C", "W3");
        Assertions.assertEquals(BigDecimal.valueOf(1500), response);
    }

    @Test
    public void checkMedicineCodeTest() {

        MedicineMaster medicineMaster = new MedicineMaster("MC_301", "'Fepanil'");
        Optional<MedicineMaster> medicineMasterOptional = Optional.of(medicineMaster);
        Mockito.when(iMedicineMasterRepository.findById(Mockito.any())).thenReturn(medicineMasterOptional);
        Boolean response = batchDAO.checkMedicineCode("MC_301");
        Assertions.assertEquals(true, response);
    }

    @Test
    public void checkBatchCodeTest() {

        BatchInfo batchInfo = new BatchInfo("BTC-1234",BigDecimal.valueOf(1000),BigDecimal.valueOf(1000),BigDecimal.valueOf(1000),"Normal","C","MC_301");
        Optional<BatchInfo> batchInfoOptional = Optional.of(batchInfo);
        Mockito.when(iBatchInfoRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Boolean response = batchDAO.checkBatchCode("BTC-1288");
        Assertions.assertEquals(false, response);
    }
}