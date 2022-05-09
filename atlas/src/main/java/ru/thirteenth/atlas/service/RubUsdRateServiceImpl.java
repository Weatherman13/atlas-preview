package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.FearAndGreedDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class RubUsdRateServiceImpl implements RubUsdRateService {
    private final RestTemplate restTemplate;
    private final String CRYPTO_HOUSE_RUB_RATE = "http://cryptohouse/api-v1/cbr/usd";


    @Override
    public double getRubUsdRate() {

        ResponseEntity<String> response =
                null;
        log.debug("Getting the ruble exchange rate : STARTED");

        try {
            response = restTemplate.getForEntity(new URI(CRYPTO_HOUSE_RUB_RATE), String.class);

            log.debug("Getting the ruble exchange rate : SUCCESSFUL");

            return Double.parseDouble(response.getBody());

        } catch (URISyntaxException e) {

            throw new RuntimeException("Endpoint is invalid");
        }
    }
}
