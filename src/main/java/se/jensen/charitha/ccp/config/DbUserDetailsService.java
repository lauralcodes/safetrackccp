package se.jensen.charitha.ccp.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.jensen.charitha.ccp.businesslayer.entity.AuthUser;
import se.jensen.charitha.ccp.dataaccesslayer.repository.AuthUserRepository;

@Service
public class DbUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;

    public DbUserDetailsService(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(authUser.getUsername())
                .password(authUser.getPasswordHash())
                .roles(authUser.getRole().name())
                .build();
    }
}
