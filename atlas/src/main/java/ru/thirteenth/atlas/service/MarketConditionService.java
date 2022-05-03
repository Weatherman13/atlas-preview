package ru.thirteenth.atlas.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.entity.MarketCondition;

import java.net.URISyntaxException;

public interface MarketConditionService {

    static MarketConditionService getInstance() {
        return new MarketConditionServiceImpl(new RestTemplate());
    }

    public MarketCondition getMarketCondition() throws URISyntaxException;
}
