package ru.vsu.cs.smart.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.vsu.cs.smart.db.model.User;
import ru.vsu.cs.smart.db.service.UserService;

import java.util.Collections;
import java.util.List;

public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        if (authentication.getName() == null || authentication.getCredentials() == null) {
            return null;
        }

        final String userEmail = authentication.getName();
        final Object userPassword = authentication.getCredentials();

        if (userEmail == null || userPassword == null) {
            return null;
        }

        if (userEmail.isEmpty() || userPassword.toString().isEmpty()) {
            return null;
        }

        User user = userService.findByUsername(userEmail);

        if (userEmail.equalsIgnoreCase(user.getUsername())
                && userPassword.equals(user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    userEmail, userPassword, getAuthority());
        }

        throw new UsernameNotFoundException("Invalid username or password.");
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Collections.emptyList();
    }
}
