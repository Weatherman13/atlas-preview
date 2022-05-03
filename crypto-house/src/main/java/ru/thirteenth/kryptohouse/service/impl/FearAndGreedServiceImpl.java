package ru.thirteenth.kryptohouse.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.kryptohouse.dto.FearAndGreed;
import ru.thirteenth.kryptohouse.dto.FearAndGreedRequest;
import ru.thirteenth.kryptohouse.exception.FearAndGreedRequestIsEmptyException;
import ru.thirteenth.kryptohouse.service.FearAndGreedIndexService;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class FearAndGreedServiceImpl implements FearAndGreedIndexService {

    private final String FEAR_AND_GREED_END = "https://api.alternative.me/fng";

    private final RestTemplate restTemplate;

    public FearAndGreedServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FearAndGreed getFearAndGreedIndex() throws URISyntaxException {
        var response =
                restTemplate.getForEntity(new URI(FEAR_AND_GREED_END), FearAndGreedRequest.class);

        return response
                .getBody()
                .getFngList()
                .stream()
                .findFirst()
                .orElseThrow(FearAndGreedRequestIsEmptyException::new);
    }


}
