package ru.thirteenth.kryptohouse.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.kryptohouse.dto.gateio.Currency;
import ru.thirteenth.kryptohouse.dto.gateio.MarketList;
import ru.thirteenth.kryptohouse.dto.gateio.PairInfoDTO;
import ru.thirteenth.kryptohouse.exception.PairDoesNotExistException;
import ru.thirteenth.kryptohouse.service.CoinInfoService;
import ru.thirteenth.model.PairModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CoinInfoServiceImpl implements CoinInfoService {
    private final String MARKET_LIST_END = "https://data.gateapi.io/api2/1/marketlist";

    private final String CURRENCY_PAIR_END = "https://data.gateapi.io/api2/1/ticker/";


    private final RestTemplate restTemplate;

    @Autowired
    public CoinInfoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public Set<Currency> getCurrencyInfo(Set<String> currencyNames) {
        ResponseEntity<MarketList> response = null;;
        log.debug("Getting information about the list of cryptocurrencies : STARTING");

        try {
            response = restTemplate.getForEntity(new URI(MARKET_LIST_END), MarketList.class);

            log.debug("Getting information about the list of cryptocurrencies : SUCCESSFUL");

            return response
                    .getBody()
                    .getMarketList()
                    .stream()
                    .filter(currency -> currencyNames.contains(currency.getSymbol())
                            && currency.getCurrB().equals("USDT"))
                    .collect(Collectors.toSet());
        } catch (URISyntaxException e) {
            log.debug("Getting information about the list of cryptocurrencies : FAILED");

            throw new RuntimeException("Endpoint is invalid");
        }

    }

    public MarketList getAllCurrency() {
        ResponseEntity<MarketList> response = null;;

        log.debug("Getting a list of supported cryptocurrency pairs : STARTING");

        try {
            response = restTemplate.getForEntity(new URI(MARKET_LIST_END), MarketList.class);

            log.debug("Getting a list of supported cryptocurrency pairs : SUCCESSFUL");

            return response.getBody();
        } catch (URISyntaxException e) {

            log.debug("Getting a list of supported cryptocurrency pairs : FAILED");

            throw new RuntimeException("Endpoint is invalid");
        }
    }


    @Override
    public List<Currency> getPair(Map<String, String> pair) {
        ResponseEntity<MarketList> response = null;;
        log.debug("Getting a Cryptocurrency-supported Pair : STARTING");

        try {
            response = restTemplate.getForEntity(new URI(MARKET_LIST_END), MarketList.class);

            log.debug("Getting a Cryptocurrency-supported Pair : SUCCESSFUL");

            return response
                    .getBody()
                    .getMarketList()
                    .stream()
                    .filter(currency -> pair.containsKey(currency.getCurrA()) &&
                            pair.containsValue(currency.getCurrB()))
                    .collect(Collectors.toList());

        } catch (URISyntaxException e) {

            log.debug("Getting a Cryptocurrency-supported Pair : FAILED");

            throw new RuntimeException("Endpoint is invalid");
        }
    }

    @Override
    public PairInfoDTO getPairInfo(PairModel pair) {
        ResponseEntity<PairInfoDTO> response = null;
        log.debug("Getting information about a cryptocurrency pair : STARTING");

        try {
            response = restTemplate.getForEntity(new URI(CURRENCY_PAIR_END)
                    + pair.getCur1()
                    + "_"
                    + pair.getCur2(), PairInfoDTO.class);

            if (response.getBody().getResult() == null) {
                log.debug("Getting information about a cryptocurrency pair : FAILED");

                throw new PairDoesNotExistException("This currency pair does not exist");
            }

            log.debug("Getting information about a cryptocurrency pair :  SUCCESSFUL");

            return response.getBody();
        } catch (URISyntaxException e) {
            log.debug("Getting information about a cryptocurrency pair : FAILED");

            throw new RuntimeException(e);
        }
    }


}
