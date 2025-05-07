package com.ust.PharmAssist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * BatchInfo entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "batch_info")
public class BatchInfo implements Serializable {

    private static final long serialVersionUID = 9083749023847239847L;

    @Id
    private String batchCode;
    private BigDecimal weight;
    private BigDecimal price;
    private BigDecimal shippingCharge;
    private String careLevel;
    private String medicineTypeCode;
    private String medicineCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatchInfo batchInfo = (BatchInfo) o;
        return Objects.equals(batchCode, batchInfo.batchCode) && Objects.equals(weight, batchInfo.weight) && Objects.equals(price, batchInfo.price) && Objects.equals(shippingCharge, batchInfo.shippingCharge) && Objects.equals(careLevel, batchInfo.careLevel) && Objects.equals(medicineTypeCode, batchInfo.medicineTypeCode) && Objects.equals(medicineCode, batchInfo.medicineCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchCode, weight, price, shippingCharge, careLevel, medicineTypeCode, medicineCode);
    }

    @Override
    public String toString() {
        return "BatchInfo{" +
                "batchCode='" + batchCode + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", shippingCharge=" + shippingCharge +
                ", careLevel='" + careLevel + '\'' +
                ", medicineTypeCode='" + medicineTypeCode + '\'' +
                ", medicineCode='" + medicineCode + '\'' +
                '}';
    }
}
