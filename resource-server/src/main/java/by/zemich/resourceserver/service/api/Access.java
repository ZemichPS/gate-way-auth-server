package by.zemich.resourceserver.service.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public interface Access {
    @PreAuthorize("hasAuthority('SCOPE_email')")
    default String getSecretCode() {

        var jwt = SecurityContextHolder.getContext()
                .getAuthentication();

        return "secret";
    }
}
