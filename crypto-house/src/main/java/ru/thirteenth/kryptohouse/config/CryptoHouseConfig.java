package ru.thirteenth.kryptohouse.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@OpenAPIDefinition
public class CryptoHouseConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
