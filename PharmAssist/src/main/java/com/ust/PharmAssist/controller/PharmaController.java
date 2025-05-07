package com.ust.PharmAssist.controller;


import com.ust.PharmAssist.constants.CommonConstants;
import com.ust.PharmAssist.dto.BatchVO;
import com.ust.PharmAssist.entity.BatchInfo;
import com.ust.PharmAssist.exception.PharmaBusinessException;
import com.ust.PharmAssist.exception.PharmaException;
import com.ust.PharmAssist.service.IPharmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Implement Rest Api to save new batch
 */
@RestController
@RequestMapping
public class PharmaController {
    private Logger logger = LoggerFactory.getLogger(PharmaController.class);

    @Autowired
    IPharmaService iPharmaService;


    /**
     * @param batchVO
     * @return ResponseEntity<String>
     * @throws PharmaException
     * @throws PharmaBusinessException
     */
    @PostMapping
    public ResponseEntity<String> addBatch(@RequestBody BatchVO batchVO) throws PharmaException, PharmaBusinessException {
        logger.info("Invoked controller method addBatch" + batchVO);
        boolean response = iPharmaService.addBatch(batchVO);
        if (response) {
            return ResponseEntity.ok(CommonConstants.ADDED_SUCCESSFULLY);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping
    public ResponseEntity<Page<BatchInfo>> fetchBatch(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){

        logger.info("Invoked controller method fetchBatch" +" parameter 1: " + pageNumber +" parameter 1: "+ pageSize );
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<BatchInfo> batchPage = iPharmaService.fetchBatch(pageable);

        logger.info("Method Exit method_name fetchBatch :" + batchPage);
        return ResponseEntity.ok(batchPage);
    }
}
