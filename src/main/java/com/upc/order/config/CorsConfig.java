package com.upc.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("Authorization","Content-Type")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);
            }
        };
    }

    @Bean
    public WebMvcConfigurer httpsRedirectConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry registry) {
                registry.addRedirectViewController("http://{host}:{port}/{path}", "https://{host}:{port}/{path}")
            }
        };
    }
}
