package se.jensen.charitha.ccp.businesslayer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;

@Entity
public class Ccp {
    @Id
    @SequenceGenerator(name = "ccp_seq", sequenceName = "ccp_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ccp_seq")
    private Long ccpId;
    private String parameterName;
    private String description;
    private String unit;
    private int minLimit;
    private int maxLimit;

    public Ccp(Long ccpId, String parameterName, String description, String unit, int minLimit, int maxLimit) {
        this.ccpId = ccpId;
        this.parameterName = parameterName;
        this.description = description;
        this.unit = unit;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public Ccp() {

    }

    public Long getCcpId() {
        return ccpId;
    }

    public void setCcpId(Long ccpId) {
        this.ccpId = ccpId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }

}


