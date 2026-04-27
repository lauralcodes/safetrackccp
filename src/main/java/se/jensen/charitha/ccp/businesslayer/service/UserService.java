package se.jensen.charitha.ccp.businesslayer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.jensen.charitha.ccp.businesslayer.entity.AuthRole;
import se.jensen.charitha.ccp.businesslayer.entity.AuthUser;
import se.jensen.charitha.ccp.businesslayer.entity.User;
import se.jensen.charitha.ccp.businesslayer.mapper.UserMapper;
import se.jensen.charitha.ccp.dataaccesslayer.repository.AuthUserRepository;
import se.jensen.charitha.ccp.dataaccesslayer.repository.UserRepository;
import se.jensen.charitha.ccp.presentationlayer.dto.UserRequestDto;
import se.jensen.charitha.ccp.presentationlayer.dto.UserResponseDto;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserRepository authUserRepository;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            AuthUserRepository authUserRepository
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authUserRepository = authUserRepository;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public UserResponseDto createUser(UserRequestDto requestDto) {
        if (requestDto.getUsername() == null || requestDto.getUsername().isBlank()) {
            throw new IllegalArgumentException("username is required");
        }
        if (userRepository.existsByUsername(requestDto.getUsername()) || authUserRepository.existsByUsername(requestDto.getUsername())) {
            throw new IllegalArgumentException("username already exists");
        }
        if (requestDto.getRole() == null) {
            throw new IllegalArgumentException("role is required");
        }

        User user = new User();
        user.setName(requestDto.getName());
        user.setUsername(requestDto.getUsername());

        if (requestDto.getPassword() == null || requestDto.getPassword().isBlank()) {
            throw new IllegalArgumentException("password is required");
        }
        String passwordHash = passwordEncoder.encode(requestDto.getPassword());
        user.setPasswordHash(passwordHash);

        user.setRole(requestDto.getRole());
        user.setContactInfo(requestDto.getContactInfo());

        User savedUser = userRepository.saveAndFlush(user);

        AuthUser authUser = new AuthUser();
        authUser.setUsername(savedUser.getUsername());
        authUser.setPasswordHash(passwordHash);
        authUser.setRole(AuthRole.valueOf(savedUser.getRole().name()));
        authUserRepository.save(authUser);

        return userMapper.toResponseDto(savedUser);
    }

    @Transactional
    public boolean deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            return false;
        }

        userRepository.deleteById(id);
        return true;
    }
}
