package ru.thirteenth.kryptohouse.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.URISyntaxException;

public interface ToRubConverterService {

    double toRubConvert(String targetCurrency) throws URISyntaxException, JsonProcessingException;
}
