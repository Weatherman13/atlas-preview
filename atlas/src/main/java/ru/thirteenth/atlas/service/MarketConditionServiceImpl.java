package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.FearAndGreedDTO;
import ru.thirteenth.atlas.dto.MarketListDTO;
import ru.thirteenth.atlas.mapper.CurrencyDtoModelMapper;
import ru.thirteenth.atlas.model.CurrencyModel;
import ru.thirteenth.atlas.model.FearAndGreedModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MarketConditionServiceImpl implements MarketConditionService {

    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/api-v1/gate-io/";
    private final RestTemplate restTemplate;



    public FearAndGreedModel getFearAndGreedIndex() {
        ResponseEntity<FearAndGreedDTO> responseFnG =
                null;
        log.debug("Getting the Fear and Greed Index : STARTED");
        try {
            responseFnG = restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "fng"), FearAndGreedDTO.class);


            var fng = responseFnG.getBody();

            var valueFnG = Integer.valueOf(fng.getValue());
            var valueClassification = fng.getValueClassification();

            log.debug("Getting the Fear and Greed Index : SUCCESSFUL");

            return new FearAndGreedModel(valueFnG, valueClassification);
        } catch (URISyntaxException e) {

            log.debug("Getting the Fear and Greed Index : FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }

    public List<CurrencyModel> getTopCurrency() {
        ResponseEntity<MarketListDTO> responseTop =
                null;
        log.debug("Getting the Top cap. 15 : STARTED");
        try {
            responseTop = restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "cryptocurrency-pair"), MarketListDTO.class);

            log.debug("Getting the Top cap. 15 : SUCCESSFUL");

            return responseTop
                    .getBody()
                    .getMarketList()
                    .stream()
                    .map(obj -> CurrencyDtoModelMapper.INSTANCE.currencyDtoToModel(obj))
                    .filter(cur -> cur.getPairModel().getCurrencyB().equals("USDT") &&
                            !cur.getPairModel().getCurrencyA().equals("AURORA"))
                    .sorted(Comparator.comparing(CurrencyModel::getMarketCup).reversed())
                    .limit(15)
                    .collect(Collectors.toList());
        } catch (URISyntaxException e) {

            log.debug("Getting the Top cap. 15 : FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }
}
