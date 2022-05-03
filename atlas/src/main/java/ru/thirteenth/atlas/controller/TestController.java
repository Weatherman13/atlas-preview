package ru.thirteenth.atlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.thirteenth.atlas.entity.MarketCondition;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;

import java.net.URISyntaxException;

@RestController
public class TestController {
    MarketConditionServiceImpl marketService;

    @Autowired
    public TestController(MarketConditionServiceImpl marketService) {
        this.marketService = marketService;
    }

    @GetMapping(value = "/test")
    public String getFearAndGreed() throws URISyntaxException {
        var cond = marketService.getMarketCondition();
        return "Test output";

    }
}
