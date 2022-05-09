package ru.thirteenth.kryptohouse.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.kryptohouse.dto.faq.FearAndGreed;
import ru.thirteenth.kryptohouse.dto.faq.FearAndGreedRequest;
import ru.thirteenth.kryptohouse.exception.FearAndGreedRequestIsEmptyException;
import ru.thirteenth.kryptohouse.service.FearAndGreedIndexService;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Slf4j
@RequiredArgsConstructor
public class FearAndGreedServiceImpl implements FearAndGreedIndexService {

    private final String FEAR_AND_GREED_END = "https://api.alternative.me/fng";

    private final RestTemplate restTemplate;


    @Override
    public FearAndGreed getFearAndGreedIndex() {

        ResponseEntity<FearAndGreedRequest> response =
                null;

        log.debug("Getting the Fear and Greed Index : STARTED");

        try {
            response = restTemplate.getForEntity(new URI(FEAR_AND_GREED_END), FearAndGreedRequest.class);

            log.debug("Getting the Fear and Greed Index : SUCCESSFUL");
            return response
                    .getBody()
                    .getFngList()
                    .stream()
                    .findFirst()
                    .orElseThrow(FearAndGreedRequestIsEmptyException::new);

        } catch (URISyntaxException e) {

            log.debug("Getting the Fear and Greed Index : FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }


}
