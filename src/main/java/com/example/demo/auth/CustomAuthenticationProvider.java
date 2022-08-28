package com.example.demo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.Objects;

@RequiredArgsConstructor
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final CustomUserDetailsService detailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails userDetails = detailsService.loadUserByUsername(name);
        return checkPassword(userDetails,password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    private Authentication checkPassword(UserDetails user, String rawPassword) {
        if (Objects.equals(rawPassword, user.getPassword())) {
            User inputUser = new User(
                    user.getUsername(),
                    user.getPassword(),
                    user.getAuthorities()
            );
            return new UsernamePasswordAuthenticationToken(inputUser, user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("Invalid password");
        }
    }
}
