package com.example.demo.snake2camel;

import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

public class WebContextConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(processor());
    }

    @Bean
    protected Snake2CamelModelAttributeMethodProcessor processor() {
        return new Snake2CamelModelAttributeMethodProcessor(true);
    }
}

