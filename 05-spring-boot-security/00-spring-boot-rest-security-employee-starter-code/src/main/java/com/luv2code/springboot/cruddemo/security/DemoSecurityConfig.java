package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails abdo= User.builder().username("abdo").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails mustafa= User.builder().username("mustafa").password("{noop}123").roles("EMPLOYEE","MANAGER").build();
        UserDetails islam= User.builder().username("islam").password("{noop}123").roles("EMPLOYEE","MANAGER","ADMIN").build();
        return new  InMemoryUserDetailsManager(abdo,islam,mustafa);
    }
}
