package ru.thirteenth.kryptohouse.service;

import ru.thirteenth.kryptohouse.dto.gateio.Currency;
import ru.thirteenth.kryptohouse.dto.gateio.PairInfoDTO;
import ru.thirteenth.model.PairModel;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CoinInfoService {


    Set<Currency> getCurrencyInfo(Set<String> currencyNames) throws URISyntaxException;

    List<Currency> getPair(Map<String, String> pair) throws URISyntaxException;

    PairInfoDTO getPairInfo(PairModel pair) throws URISyntaxException;
}
