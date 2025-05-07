package com.ust.PharmAssist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Medicine Master Entity class
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "medicine_master")
public class MedicineMaster implements Serializable {

    private static final long serialVersionUID = 7239847239847239847L;

    @Id
    @Column(name = "MEDICINE_CODE")
    private String medicineCode;
    @Column(name = "MEDICINE_NAME")
    private String medicineName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineMaster that = (MedicineMaster) o;
        return Objects.equals(medicineCode, that.medicineCode) && Objects.equals(medicineName, that.medicineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineCode, medicineName);
    }

    @Override
    public String toString() {
        return "MedicineMaster{" +
                "medicineCode='" + medicineCode + '\'' +
                ", medicineName='" + medicineName + '\'' +
                '}';
    }
}
