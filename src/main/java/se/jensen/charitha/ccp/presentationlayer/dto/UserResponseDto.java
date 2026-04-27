package se.jensen.charitha.ccp.presentationlayer.dto;

import se.jensen.charitha.ccp.businesslayer.entity.UserRole;

public class UserResponseDto {

    private Long userId;
    private String name;
    private String username;
    private UserRole role;
    private String contactInfo;

    public UserResponseDto() {
    }

    public UserResponseDto(Long userId, String name, String username, UserRole role, String contactInfo) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.role = role;
        this.contactInfo = contactInfo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
