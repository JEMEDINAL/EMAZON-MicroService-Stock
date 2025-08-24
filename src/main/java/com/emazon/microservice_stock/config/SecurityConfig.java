package com.emazon.microservice_stock.config;

import com.emazon.microservice_stock.adapter.out.util.JwtUtils;
import com.emazon.microservice_stock.config.filter.JwtTokenValidator;
import com.emazon.microservice_stock.domain.constant.category.CategoryBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http ->{

                    http.requestMatchers(HttpMethod.GET,"/api/category/all").permitAll();
                    http.requestMatchers(HttpMethod.GET,"/api/brand/all").permitAll();
                    http.requestMatchers(HttpMethod.GET,"/api/article/all").permitAll();

                    http.requestMatchers(HttpMethod.POST,"/api/category/create").hasAuthority(CategoryBusinessRules.ACCESS_ROL);
                    http.requestMatchers(HttpMethod.POST,"/api/brand/create").hasAuthority(CategoryBusinessRules.ACCESS_ROL);
                    http.requestMatchers(HttpMethod.POST,"/api/article/create").hasAuthority(CategoryBusinessRules.ACCESS_ROL);



                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return  authenticationConfiguration.getAuthenticationManager();
    }
}
