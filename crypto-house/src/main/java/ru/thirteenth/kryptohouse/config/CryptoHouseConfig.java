package ru.thirteenth.kryptohouse.config;


import org.springdoc.core.GroupedOpenApi;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class CryptoHouseConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("Crypto-House")
                .packagesToScan("ru.thirteenth.kryptohouse.controller")
                .pathsToMatch("/**")
                .build();
    }
}

