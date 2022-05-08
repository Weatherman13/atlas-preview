package ru.thirteenth.kryptohouse.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.kryptohouse.dto.cbr.CurrencyTypeCbr;
import ru.thirteenth.kryptohouse.exception.CurrencyTypeNotSupportedException;
import ru.thirteenth.kryptohouse.parser.CbrCurrencyParser;
import ru.thirteenth.kryptohouse.service.ToRubConverterService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@Service
public class ToRubConverterServiceCbrImpl implements ToRubConverterService {

    private final String CBR_RATE_ALL_END = "https://www.cbr-xml-daily.ru/daily_json.js";

    private final RestTemplate restTemplate;

    private final CbrCurrencyParser curParser;

    @Autowired
    public ToRubConverterServiceCbrImpl(RestTemplate restTemplate, CbrCurrencyParser curParser) {
        this.restTemplate = restTemplate;
        this.curParser = curParser;
    }

    @Override
    public double toRubConvert(String targetCurrency) throws URISyntaxException {

        ResponseEntity<String> response =
                null;

            response = restTemplate.getForEntity(new URI(CBR_RATE_ALL_END), String.class);

        var typeCurrencyIsSupported = Arrays.stream(CurrencyTypeCbr.values())
                .anyMatch(type -> type.toString().equals(targetCurrency.toUpperCase()));

        if (typeCurrencyIsSupported) {

            var result = curParser.parseTargetCurrency(response.getBody(), targetCurrency);
            return result.getValue();
        }

        throw new CurrencyTypeNotSupportedException("The currency type does not supported");
    }
}
