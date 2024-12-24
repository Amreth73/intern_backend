package com.example.intern_1.Cofig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()  // Disable CSRF for simplicity
            .authorizeHttpRequests()
            .requestMatchers("/api/users/register").permitAll() // Allow registration endpoint without authentication
            .requestMatchers("/api/**").permitAll() // Allow other /api/** requests
            .anyRequest().authenticated() // Require authentication for other endpoints
            .and()
            .httpBasic();  // Enable basic authentication for other endpoints

        return http.build();
    }
}
