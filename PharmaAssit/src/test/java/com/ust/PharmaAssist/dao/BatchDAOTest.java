package com.ust.PharmaAssist.dao;

import com.ust.PharmaAssist.entity.BatchInfo;
import com.ust.PharmaAssist.exception.PharmaException;
import com.ust.PharmaAssist.repository.IBatchInfoRepository;
import com.ust.PharmaAssist.repository.IMedicineMasterRepository;
import com.ust.PharmaAssist.repository.IShippingMasterRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//@ContextConfiguration(classes = {BatchDAO.class})
//@ExtendWith(SpringExtension.class)

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class BatchDAOTest {

    @Autowired
    private BatchDAO batchDAO;

    @Mock
    private IBatchInfoRepository batchInfoRepository;

    @Mock
    private IShippingMasterRepository shippingMasterRepository;

    @Mock
    private IMedicineMasterRepository medicineMasterRepository;



//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void addDetails_Success() throws PharmaException {
        BatchInfo batchInfo = new BatchInfo();
        batchInfo.setBatchCode("123");
//        doNothing().when(batchInfoRepository).save(batchInfo);

        assertTrue(batchDAO.addDetails(batchInfo));
        verify(batchInfoRepository, times(1)).save(batchInfo);
    }
}
