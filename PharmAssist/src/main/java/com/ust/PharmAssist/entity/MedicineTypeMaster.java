package com.ust.PharmAssist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Medicine Type Master Entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "medicine_type_master")
public class MedicineTypeMaster implements Serializable {

    private static final long serialVersionUID = 3874023984723984723L;

    @Id
    private String medicineTypeCode;
    private String medicineTypeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineTypeMaster that = (MedicineTypeMaster) o;
        return Objects.equals(medicineTypeCode, that.medicineTypeCode) && Objects.equals(medicineTypeName, that.medicineTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineTypeCode, medicineTypeName);
    }

    @Override
    public String toString() {
        return "MedicineTypeMaster{" +
                "medicineTypeCode='" + medicineTypeCode + '\'' +
                ", medicineTypeName='" + medicineTypeName + '\'' +
                '}';
    }
}
