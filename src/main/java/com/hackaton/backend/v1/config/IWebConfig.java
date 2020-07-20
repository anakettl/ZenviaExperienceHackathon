package com.hackaton.backend.v1.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

public interface IWebConfig {

    void addCorsMappings(CorsRegistry registry);

    void addResourceHandlers(ResourceHandlerRegistry registry);

    void configure(AuthenticationManagerBuilder auth) throws Exception;

    void configure(HttpSecurity http) throws Exception;
}
