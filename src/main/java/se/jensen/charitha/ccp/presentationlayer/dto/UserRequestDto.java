package se.jensen.charitha.ccp.presentationlayer.dto;

import se.jensen.charitha.ccp.businesslayer.entity.UserRole;

public class UserRequestDto {

    private String name;
    private String username;
    private String password;
    private UserRole role;
    private String contactInfo;

    public UserRequestDto() {
    }

    public UserRequestDto(String name, String username, String password, UserRole role, String contactInfo) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
        this.contactInfo = contactInfo;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
