package com.example.TimerManager.Configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for the application
                .authorizeHttpRequests(authz ->
                        authz
                                .requestMatchers("/api/v1/user/login", "/register", "/css/**", "/js/**", "/index", "/images/**").permitAll() // Allow access to login, register, static assets
                                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()  // Allow OPTIONS (preflight) requests for CORS
                                .requestMatchers(HttpMethod.GET, "/api/v1/user/profile", "/api/v1/timer/profile-current-week" , "/api/v1/timer/profile-current-day").permitAll()
                                .requestMatchers(HttpMethod.POST, "/api/v1/timer/save-day-timer" ,"/api/v1/timer/save-week-timer" ).permitAll()// Allow unauthenticated access to profile endpoint
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout") // Logout URL
                            .logoutSuccessUrl("/index") // Redirect after logout
                            .invalidateHttpSession(true) // Invalidate session
                            .clearAuthentication(true); // Clear authentication on logout
                })
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)  // Create session if needed
                        .maximumSessions(1)  // Allow only one active session per user
                        .expiredUrl("/session-expired")  // Redirect to session expired page if the session expires
                )
                .build();
    }

}