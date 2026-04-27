package se.jensen.charitha.ccp.businesslayer.mapper;

import org.springframework.stereotype.Component;
import se.jensen.charitha.ccp.businesslayer.entity.User;
import se.jensen.charitha.ccp.presentationlayer.dto.UserResponseDto;

@Component
public class UserMapper {

    public UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getName(),
                user.getUsername(),
                user.getRole(),
                user.getContactInfo()
        );
    }
}
