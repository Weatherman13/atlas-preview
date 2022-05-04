package ru.thirteenth.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
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
public class MarketConditionServiceImpl implements MarketConditionService {

    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/";
    private final RestTemplate restTemplate;


    @Autowired
    public MarketConditionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public FearAndGreedModel getMarketCondition() throws URISyntaxException {
        var responseFnG =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "fng"), FearAndGreedDTO.class);

        var fng = responseFnG.getBody();

        var valueFnG = Integer.valueOf(fng.getValue());
        var valueClassification = fng.getValueClassification();

        return new FearAndGreedModel(valueFnG, valueClassification);
    }

    public List<CurrencyModel> getTopCurrency() throws URISyntaxException {
        var responseTop =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketListDTO.class);

        return responseTop
                .getBody()
                .getMarketList()
                .stream()
                .map(obj -> CurrencyDtoModelMapper.INSTANCE.currencyDtoToModel(obj))
                .filter(cur -> cur.getPairModel().getCurrencyB().equals("USDT"))
                .sorted(Comparator.comparing(CurrencyModel::getMarketCup).reversed())
                .limit(15)
                .collect(Collectors.toList());

    }
}
