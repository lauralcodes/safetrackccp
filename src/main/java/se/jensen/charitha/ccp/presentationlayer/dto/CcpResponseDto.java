package se.jensen.charitha.ccp.presentationlayer.dto;

public class CcpResponseDto {

    private Long ccpId;
    private String parameterName;
    private String description;
    private String unit;
    private int minLimit;
    private int maxLimit;

    public CcpResponseDto() {
    }

    public CcpResponseDto(Long ccpId, String parameterName, String description, String unit, int minLimit, int maxLimit) {
        this.ccpId = ccpId;
        this.parameterName = parameterName;
        this.description = description;
        this.unit = unit;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
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
