package com.section_3_using_jpa.config;

import com.section_3_using_jpa.repo.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final CustomerJpaRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.of(repository.findByEmail(username))
                .map(customer ->
                        new User(
                                customer.getEmail(),
                                customer.getPwd(),
                                List.of(new SimpleGrantedAuthority(customer.getRole()))
                        )
                )
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user : " + username));
    }
}
