package br.com.fatec.modulo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class RouteConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(
                                "/modulo-auth/api/v1/user/save/**",
                                "/modulo-auth/api/v1/auth/login/**"
                        )
                        .permitAll()
                        .anyExchange()
                        .authenticated()
                ).oauth2ResourceServer(oauth -> oauth.jwt())
                .build();
    }

}
