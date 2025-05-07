package com.ust.PharmaAssist.controller;

import com.ust.PharmaAssist.constants.CommonConstants;
import com.ust.PharmaAssist.dto.BatchVO;
import com.ust.PharmaAssist.exception.PharmaBusinessException;
import com.ust.PharmaAssist.exception.PharmaException;
import com.ust.PharmaAssist.service.IPharmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
     * Add a new batch
     * @param batchVO
     * @return ResponseEntity<String>
     */
    @PostMapping
    public ResponseEntity<String> addBatch(@RequestBody BatchVO batchVO){
        logger.info("Invoked controller method addBatch"+batchVO);
        try {
            boolean response = iPharmaService.addBatch(batchVO);
            if (response){
                return ResponseEntity.ok(CommonConstants.ADDED_SUCCESSFULLY);
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        }catch (PharmaBusinessException e) {
            return ResponseEntity.status(e.getErrorCode()).body(e.getMessage());
        } catch (PharmaException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
