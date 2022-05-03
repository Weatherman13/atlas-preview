package ru.thirteenth.kryptohouse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.kryptohouse.dto.Currency;
import ru.thirteenth.kryptohouse.dto.MarketList;
import ru.thirteenth.kryptohouse.dto.Pair;
import ru.thirteenth.kryptohouse.dto.PairInfo;
import ru.thirteenth.kryptohouse.service.CoinInfoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CoinInfoServiceImpl implements CoinInfoService {
    private final String MARKET_LIST_END = "https://data.gateapi.io/api2/1/marketlist";

    private final String CURRENCY_PAIR_END = "https://data.gateapi.io/api2/1/ticker/";

    private final RestTemplate restTemplate;

    @Autowired
    public CoinInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    public Set<Currency> getCurrencyInfo(Set<String> currencyNames) throws URISyntaxException {
        var response = restTemplate.getForEntity(new URI(MARKET_LIST_END), MarketList.class);

        return response
                .getBody()
                .getMarketList()
                .stream()
                .filter(currency -> currencyNames.contains(currency.getSymbol())
                        && currency.getCurrB().equals("USDT"))
                .collect(Collectors.toSet());

    }

    public MarketList getAllCurrency() throws URISyntaxException {
        var response = restTemplate.getForEntity(new URI(MARKET_LIST_END), MarketList.class);

        return response.getBody();
    }


    @Override
    public List<Currency> getPair(Map<String,String> pair) throws URISyntaxException {
        var response =
                restTemplate.getForEntity(new URI(MARKET_LIST_END),MarketList.class);
        return response
                .getBody()
                .getMarketList()
                .stream()
                .filter(currency -> pair.containsKey(currency.getCurrA()) && pair.containsValue(currency.getCurrB()))
                .collect(Collectors.toList());
    }

    @Override
    public PairInfo getPairInfo(Pair pair) throws URISyntaxException {
        var response =
                restTemplate.getForEntity(new URI(CURRENCY_PAIR_END)
                        + pair.getCurrencyA().toLowerCase()
                        +"_"
                        + pair.getCurrencyB().toLowerCase(), PairInfo.class);

        return response.getBody();
    }
}
