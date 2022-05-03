package ru.thirteenth.atlas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.thirteenth.atlas.CryptoBotConfig.CryptoBot;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;


@SpringBootApplication
@EnableEurekaClient
public class AtlasApplication {


    public static void main(String[] args) {

        SpringApplication.run(AtlasApplication.class, args);

    }

}
