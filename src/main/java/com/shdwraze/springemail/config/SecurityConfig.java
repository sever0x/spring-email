package com.shdwraze.springemail.config;

import com.shdwraze.springemail.mapper.Mappers;
import com.shdwraze.springemail.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(c -> c
                .requestMatchers(antMatcher("/h2/**")).permitAll()
                .requestMatchers("/send").permitAll()
                .requestMatchers(POST, "/forgot-password").permitAll()
                .requestMatchers("/error").permitAll()
                .anyRequest().permitAll());
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(
            UserRepository repository,
            Mappers mapper
    ) {
        return name -> repository.findByEmailIgnoreCase(name)
                .map(mapper::toUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(name + " not found"));
    }
}