package io.security.oauth2.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.httpBasic().authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        // 세션을 사용하지 않으면 매 요청 때마다 인증 과정을 거치게 된다
        // Context를 저장하지도 않는다
        // existingAuth == null
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
