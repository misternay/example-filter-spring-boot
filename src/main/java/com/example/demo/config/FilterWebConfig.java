package com.example.demo.config;

import com.example.demo.filters.HttpServletRequestCustomFilter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class FilterWebConfig implements WebMvcRegistrations, WebMvcConfigurer {
    private static final List<String> SECURE_URL = Arrays.asList("/hello", "/other");

    @Bean
    FilterRegistrationBean<HttpServletRequestCustomFilter> decryptFilter() {
        FilterRegistrationBean<HttpServletRequestCustomFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new HttpServletRequestCustomFilter());
        filterFilterRegistrationBean.setUrlPatterns(SECURE_URL);
        return filterFilterRegistrationBean;
    }
}
