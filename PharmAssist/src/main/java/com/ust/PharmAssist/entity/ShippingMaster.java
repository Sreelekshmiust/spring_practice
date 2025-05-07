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
 * Shipping Master Entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "shipping_master")
public class ShippingMaster implements Serializable {

    private static final long serialVersionUID = 8754298347298347298L;

    @Id
    private String medicineTypeCode;
    private String weightRange;
    private BigDecimal shippingCharge;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingMaster that = (ShippingMaster) o;
        return Objects.equals(medicineTypeCode, that.medicineTypeCode) && Objects.equals(weightRange, that.weightRange) && Objects.equals(shippingCharge, that.shippingCharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineTypeCode, weightRange, shippingCharge);
    }

    @Override
    public String toString() {
        return "ShippingMaster{" +
                "medicineTypeCode='" + medicineTypeCode + '\'' +
                ", weightRange='" + weightRange + '\'' +
                ", shippingCharge=" + shippingCharge +
                '}';
    }
}
