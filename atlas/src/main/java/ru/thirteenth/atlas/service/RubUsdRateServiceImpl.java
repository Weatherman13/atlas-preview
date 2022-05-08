package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.FearAndGreedDTO;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class RubUsdRateServiceImpl implements RubUsdRateService{
    private final RestTemplate restTemplate;
    private final String CRYPTO_HOUSE_RUB_RATE = "http://cryptohouse:9090/api-v1/cbr/usd";


    @Override
    @SneakyThrows
    public double getRubUsdRate(){
        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_RUB_RATE), String.class);
        return Double.parseDouble(response.getBody());
    }
}
