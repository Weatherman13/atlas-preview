package ru.thirteenth.atlas.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.MarketListDTO;

import ru.thirteenth.atlas.mapper.CurrencyDtoModelMapper;
import ru.thirteenth.atlas.model.CurrencyModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class CryptocurrencyInformationService {
    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/api-v1/gate-io/";
    private final RestTemplate restTemplate;

    private final CurrencyDtoModelMapper currencyMapper = CurrencyDtoModelMapper.INSTANCE;


    public CurrencyModel getCoinInfoBySuf(String sufPattern) {

        ResponseEntity<MarketListDTO> response =
                null;

        log.debug("Getting the cryptocurrency info by suffix : STARTED");

        try {
            response = restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "cryptocurrency-pair"),
                    MarketListDTO.class);

            log.debug("Getting the cryptocurrency info by suffix : SUCCESSFUL");

            return response.getBody()
                    .getMarketList()
                    .stream()
                    .filter(coin -> coin.getCurrA().toLowerCase().equals(sufPattern.toLowerCase(Locale.ROOT)) &&
                            coin.getCurrB().equals("USDT"))
                    .parallel()
                    .map(coin -> currencyMapper.currencyDtoToModel(coin))
                    .findFirst()
                    .orElse(new CurrencyModel("none"));
        } catch (URISyntaxException e) {

            log.debug("Getting the cryptocurrency info by suffix : FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }

    public CurrencyModel getCoinInfoByName(String namePattern) {

        ResponseEntity<MarketListDTO> response = null;

        log.debug("Getting the cryptocurrency info by name : STARTED");
        try {
            response = restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE +
                    "cryptocurrency-pair"), MarketListDTO.class);

            log.debug("Getting the cryptocurrency info by name : SUCCESSFUL");

            System.out.println(response.getBody());
            return response.getBody()
                    .getMarketList()
                    .stream()
                    .filter(coin -> coin.getName().toLowerCase().equals(namePattern.toLowerCase(Locale.ROOT)) &&
                            coin.getCurrB().equals("USDT"))
                    .parallel()
                    .map(obj -> currencyMapper.currencyDtoToModel(obj))
                    .findFirst()
                    .orElse(new CurrencyModel("none"));
        } catch (URISyntaxException e) {

            log.debug("Getting the cryptocurrency info by name : FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }

}
