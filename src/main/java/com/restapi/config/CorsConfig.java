package com.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class CorsConfig {
    @Bean
    WebMvcConfigurer corsMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public  void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedMethods("*");
            }
        };
    }       
}

