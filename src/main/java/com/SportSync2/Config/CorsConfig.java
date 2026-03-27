package com.SportSync2.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class CorsConfig {

    /**
     * Comma-separated origins or patterns, e.g.
     * http://localhost:3000,https://*.vercel.app,https://*.ngrok-free.dev
     * <p>
     * allowCredentials is false so wildcard headers work reliably for browser preflight (OPTIONS).
     * The app uses JSON + localStorage, not cross-origin cookies.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource(
            @Value("${cors.allowed-origins:http://localhost:3000,http://localhost:3001,http://127.0.0.1:3000,https://*.vercel.app,https://*.ngrok-free.dev,https://*.ngrok.app}") String allowedOrigins) {
        CorsConfiguration configuration = new CorsConfiguration();
        List<String> patterns = Arrays.stream(allowedOrigins.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        configuration.setAllowedOriginPatterns(patterns);
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("Authorization", "Content-Type"));
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
