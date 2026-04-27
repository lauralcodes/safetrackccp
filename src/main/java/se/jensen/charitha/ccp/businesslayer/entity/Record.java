package se.jensen.charitha.ccp.businesslayer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "records")
public class Record {

    @Id
    @SequenceGenerator(name = "record_seq", sequenceName = "record_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_seq")
    private Long recordId;

    private Long operatorId;

    private LocalDateTime date;

    private String parameter;

    private Double measurementValue;

    private String unit;

    public Record() {
    }

    public Record(Long recordId, Long operatorId, LocalDateTime date, String parameter, Double measurementValue, String unit) {
        this.recordId = recordId;
        this.operatorId = operatorId;
        this.date = date;
        this.parameter = parameter;
        this.measurementValue = measurementValue;
        this.unit = unit;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(Double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
