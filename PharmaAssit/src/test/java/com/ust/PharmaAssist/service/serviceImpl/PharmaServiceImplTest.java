package com.ust.PharmaAssist.service.serviceImpl;

import com.ust.PharmaAssist.dao.IBatchDAO;
import com.ust.PharmaAssist.dto.BatchVO;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;
import com.ust.PharmaAssist.service.PharmaServiceImpl;
import com.ust.PharmaAssist.validation.Validation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {PharmaServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class PharmaServiceImplTest {


    PharmaServiceImpl pharmaServiceImpl;

    @MockBean
    IBatchDAO iBatchDAO;


    @Mock
    Validation validation;

    @Before
    public void setUp()
    {
        pharmaServiceImpl = new PharmaServiceImpl();


    }

    @Test
    public void addBatchTest() throws PharmaException, PharmaBusinessException {

        BatchVO batchVO = new BatchVO();
        batchVO.setBatchCode("BTC-1234");
        batchVO.setPrice(new BigDecimal(5000));
        batchVO.setMedicineCode("MC_301");
        batchVO.setMedicineTypeCode("C");
        batchVO.setWeight(new BigDecimal(1000));
        batchVO.setRefrigeration("yes");
//        doNothing().when(validation).validateMandatoryFields(Mockito.any());
//        doNothing().when(validation).validateBatchVO(Mockito.any());
//        when(iBatchDAO.getShippingChargeFromDatabase(Mockito.any(),Mockito.any())).thenReturn(new BigDecimal(5000));
        when(pharmaServiceImpl.addBatch(batchVO)).thenReturn(true);
        when(pharmaServiceImpl.calculateShippingCharges(batchVO)).thenReturn(new BigDecimal(500));
        pharmaServiceImpl.addBatch(batchVO);


    }
}
