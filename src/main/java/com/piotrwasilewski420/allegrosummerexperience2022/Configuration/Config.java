package com.piotrwasilewski420.allegrosummerexperience2022.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
