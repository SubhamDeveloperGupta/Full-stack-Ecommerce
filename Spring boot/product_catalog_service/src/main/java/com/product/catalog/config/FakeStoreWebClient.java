package com.product.catalog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class FakeStoreWebClient {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://fakestoreapi.com")
                .build();
    }

}
