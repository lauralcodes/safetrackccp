package se.jensen.charitha.ccp.presentationlayer.dto;

import java.time.LocalDateTime;

public class RecordResponseDto {

    private Long recordId;
    private Long operatorId;
    private LocalDateTime date;
    private String parameter;
    private Double measurementValue;
    private String unit;

    public RecordResponseDto() {
    }

    public RecordResponseDto(Long recordId, Long operatorId, LocalDateTime date, String parameter, Double measurementValue, String unit) {
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
