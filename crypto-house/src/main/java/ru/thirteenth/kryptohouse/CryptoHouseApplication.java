package ru.thirteenth.kryptohouse;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class CryptoHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoHouseApplication.class, args);
    }



}


