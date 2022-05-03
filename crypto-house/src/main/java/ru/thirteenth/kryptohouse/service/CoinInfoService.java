package ru.thirteenth.kryptohouse.service;

import ru.thirteenth.kryptohouse.dto.Currency;
import ru.thirteenth.kryptohouse.dto.Pair;
import ru.thirteenth.kryptohouse.dto.PairInfo;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CoinInfoService {


    Set<Currency> getCurrencyInfo(Set<String> currencyNames) throws URISyntaxException;

    List<Currency> getPair(Map<String, String> pair) throws URISyntaxException;

    PairInfo getPairInfo(Pair pair) throws URISyntaxException;
}
