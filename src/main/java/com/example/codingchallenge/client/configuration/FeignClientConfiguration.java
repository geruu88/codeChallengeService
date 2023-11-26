package com.example.codingchallenge.client.configuration;

import com.example.codingchallenge.exception.CustomErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public CustomErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
