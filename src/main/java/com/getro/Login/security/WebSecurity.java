package com.getro.Login.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .securityMatcher("/**")
                .authorizeHttpRequests(registry -> registry
                                .requestMatchers("/").permitAll() // disable the default configuration
                                .requestMatchers("/auth/login").permitAll() //authorize login endpoint
                                .anyRequest().authenticated() //user must be authenticated to access on any request
                        );
      return http.build();
    }
}
