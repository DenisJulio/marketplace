package com.denisjulio.marketplace.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] PERMITTED_PATHS = { "/", "/anuncios/**" };
    private static final String[] STATIC_RESOURCES = { "/icons/**", "/images/**", "/webjars/**", "/style.css" };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(PERMITTED_PATHS).permitAll()
                .requestMatchers(STATIC_RESOURCES).permitAll()
                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    UserDetailsManager users(DataSource dataSource) {
        var userQuery = """
                SELECT email, password, enabled
                FROM usuarios
                WHERE email = ?
                 """;
        var authQuery = """
                SELECT email, autorizacao
                FROM autorizacoes
                WHERE email = ?
                 """;
        var users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery(userQuery);
        users.setAuthoritiesByUsernameQuery(authQuery);
        return users;
    }
}