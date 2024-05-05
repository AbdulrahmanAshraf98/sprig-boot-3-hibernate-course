package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails abdo= User.builder().username("abdo").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails mustafa= User.builder().username("mustafa").password("{noop}123").roles("MANAGER").build();
        UserDetails islam= User.builder().username("islam").password("{noop}123").roles("ADMIN").build();
        return new  InMemoryUserDetailsManager(abdo,islam,mustafa);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ) throws Exception{
        httpSecurity.authorizeHttpRequests(
         configAuthorizationManagerRequestMatcherRegistry->configAuthorizationManagerRequestMatcherRegistry
                 .requestMatchers(HttpMethod.GET,"/api/employees").hasAnyRole("EMPLOYEE").
                 requestMatchers(HttpMethod.GET,"/api/employees/**").hasAnyRole("EMPLOYEE").
                requestMatchers(HttpMethod.POST,"/api/employees").hasAnyRole("MANAGER").
                 requestMatchers(HttpMethod.PUT,"/api/employees").hasAnyRole("MANAGER").
                 requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasAnyRole("ADMIN")
        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf->csrf.disable());
        return  httpSecurity.build();
    }
}
