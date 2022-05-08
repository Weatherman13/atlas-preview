package ru.thirteenth.kryptohouse.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.thirteenth.kryptohouse.service.impl.ToRubConverterServiceCbrImpl;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api-v1/cbr")
public class CbrDailyCotroller {

private final ToRubConverterServiceCbrImpl toRubService;

@Autowired
    public CbrDailyCotroller(ToRubConverterServiceCbrImpl toRubService) {
        this.toRubService = toRubService;
    }

    @GetMapping(value = "/{targetCurrency}")
    public double toRubConvert(@PathVariable String targetCurrency) throws URISyntaxException, JsonProcessingException {
        return toRubService.toRubConvert(targetCurrency);
    }
}
