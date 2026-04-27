package se.jensen.charitha.ccp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.jensen.charitha.ccp.businesslayer.entity.AuthRole;
import se.jensen.charitha.ccp.businesslayer.entity.AuthUser;
import se.jensen.charitha.ccp.dataaccesslayer.repository.AuthUserRepository;

@Configuration
public class AdminUserSeeder {

    @Bean
    public ApplicationRunner seedAdminUser(
            AuthUserRepository authUserRepository,
            PasswordEncoder passwordEncoder,
            @Value("${ADMIN_USERNAME:}") String adminUsername,
            @Value("${ADMIN_PASSWORD:}") String adminPassword
    ) {
        return args -> {
            if (adminUsername == null || adminUsername.isBlank() || adminPassword == null || adminPassword.isBlank()) {
                return;
            }
            if (authUserRepository.existsByUsername(adminUsername)) {
                return;
            }

            AuthUser admin = new AuthUser();
            admin.setUsername(adminUsername);
            admin.setPasswordHash(passwordEncoder.encode(adminPassword));
            admin.setRole(AuthRole.ADMIN);
            authUserRepository.save(admin);
        };
    }
}
