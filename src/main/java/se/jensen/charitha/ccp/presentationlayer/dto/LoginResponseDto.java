package se.jensen.charitha.ccp.presentationlayer.dto;

public class LoginResponseDto {

    private String tokenType;
    private String token;
    private long expiresInSeconds;

    public LoginResponseDto() {
    }

    public LoginResponseDto(String tokenType, String token, long expiresInSeconds) {
        this.tokenType = tokenType;
        this.token = token;
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public void setExpiresInSeconds(long expiresInSeconds) {
        this.expiresInSeconds = expiresInSeconds;
    }
}

