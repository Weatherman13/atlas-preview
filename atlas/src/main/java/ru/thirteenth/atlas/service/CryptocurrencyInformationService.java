package ru.thirteenth.atlas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.MarketListDTO;

import ru.thirteenth.atlas.mapper.CurrencyDtoModelMapper;
import ru.thirteenth.atlas.model.CurrencyModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

@Service
public class CryptocurrencyInformationService {
    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/api-v1/gate-io/";
    private final RestTemplate restTemplate;

    private final CurrencyDtoModelMapper currencyMapper = CurrencyDtoModelMapper.INSTANCE;

    @Autowired
    public CryptocurrencyInformationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CurrencyModel getCoinInfoBySuf(String sufPattern) throws URISyntaxException {

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "cryptocurrency-pair"), MarketListDTO.class);

        return response.getBody()
                .getMarketList()
                .stream()
                .filter(coin -> coin.getCurrA().toLowerCase().equals(sufPattern.toLowerCase(Locale.ROOT)) &&
                        coin.getCurrB().equals("USDT"))
                .parallel()
                .map(coin -> currencyMapper.currencyDtoToModel(coin))
                .findFirst()
                .orElse(new CurrencyModel("none"));
    }

    public CurrencyModel getCoinInfoByName(String namePattern) throws URISyntaxException {

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE +
                        "cryptocurrency-pair"), MarketListDTO.class);

        return response.getBody()
                .getMarketList()
                .stream()
                .filter(coin -> coin.getName().toLowerCase().equals(namePattern.toLowerCase(Locale.ROOT)) &&
                        coin.getCurrB().equals("USDT"))
                .parallel()
                .map(obj -> currencyMapper.currencyDtoToModel(obj))
                .findFirst()
                .orElse(new CurrencyModel("none"));
    }

}
