package se.jensen.charitha.ccp.presentationlayer.dto;

public class CcpRequestDto {

    private String parameterName;
    private String description;
    private int minLimit;
    private int maxLimit;

    public CcpRequestDto() {
    }

    public CcpRequestDto(String parameterName, String description, int minLimit, int maxLimit) {
        this.parameterName = parameterName;
        this.description = description;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
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
