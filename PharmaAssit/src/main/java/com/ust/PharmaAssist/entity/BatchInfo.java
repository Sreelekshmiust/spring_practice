package com.ust.PharmaAssist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * BatchInfo entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "batch_info")
public class BatchInfo {

    @Id
    private String batchCode;
    private BigDecimal weight;
    private BigDecimal price;
    private BigDecimal shippingCharge;
    private String careLevel;
    private String medicineTypeCode;
    private String medicineCode;

}
