package by.zemich.authserver.service.impl;

import by.zemich.authserver.dao.entity.UserEntity;
import by.zemich.authserver.service.api.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity foundUserEntity = userService.getByLogin(username);
        UserDetails userDetails = User.builder()
                .username(foundUserEntity.getLogin())
                .password(foundUserEntity.getPassword())
                .roles(foundUserEntity.getRole().name())
                .accountExpired(false)
                .accountLocked(false)
                .disabled(false)
                .build();

        return userDetails;
    }
}
