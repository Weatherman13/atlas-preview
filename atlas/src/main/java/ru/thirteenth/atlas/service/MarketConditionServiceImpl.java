package ru.thirteenth.atlas.service;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.Currency;
import ru.thirteenth.atlas.dto.FearAndGreed;
import ru.thirteenth.atlas.dto.MarketList;
import ru.thirteenth.atlas.entity.CurrencyInfo;
import ru.thirteenth.atlas.entity.MarketCondition;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MarketConditionServiceImpl implements MarketConditionService {

    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/";
    private final RestTemplate restTemplate;

    @Autowired
    public MarketConditionServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MarketCondition getMarketCondition() throws URISyntaxException {
        var responseFnG =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "fng"), FearAndGreed.class);

        var fng = responseFnG.getBody();

        var valueFnG = Integer.valueOf(fng.getValue());
        var valueClassification = fng.getValueClassification();

        return new MarketCondition(valueFnG, valueClassification);
    }

    public List<CurrencyInfo> getTopCurrency() throws URISyntaxException {
        var responseTop =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketList.class);

        return responseTop
                .getBody()
                .getMarketList()
                .stream()
                .map(CurrencyInfo::currencyHandler)
                .filter(cur -> cur.getPair().getCurrencyB().equals("USDT"))
                .sorted(Comparator.comparing(CurrencyInfo::getMarketCup).reversed())
                .limit(15)
                .collect(Collectors.toList());

    }
}
