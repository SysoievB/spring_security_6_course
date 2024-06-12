package com.section_5_authentication_provider.config;

import com.section_5_authentication_provider.repo.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Objects.nonNull;

@Component
@AllArgsConstructor
public class CustomUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    private final CustomerJpaRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        val customer = repository.findByEmail(username);
        if (nonNull(customer)) {
            if (passwordEncoder.matches(pwd, customer.getPwd())) {
                return new UsernamePasswordAuthenticationToken(
                        username,
                        pwd,
                        List.of(new SimpleGrantedAuthority(customer.getRole())));
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}