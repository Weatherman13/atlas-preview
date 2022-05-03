package ru.thirteenth.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.dto.Currency;
import ru.thirteenth.atlas.dto.MarketList;
import ru.thirteenth.atlas.dto.Pair;
import ru.thirteenth.atlas.entity.CurrencyInfo;
import ru.thirteenth.atlas.entity.State;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinServiceImpl {
    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/";
    private final RestTemplate restTemplate;

    @Autowired
    public CoinServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getAllCoin() throws URISyntaxException {

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketList.class);
        return response.getBody()
                .getMarketList()
                .stream()
                .filter(cur -> cur.getCurrB().equals("USDT"))
                .map(cur -> CurrencyInfo.currencyHandler(cur))
                .sorted(Comparator.comparing(CurrencyInfo::getMarketCup).reversed())
                .limit(121)
                .parallel()
                .map(a -> new Pair(a.getCurrA(),a.getName()))
                .map(a -> a.getCurrencyB() + ": " + a.getCurrencyA())
                .collect(Collectors.toList());


    }

    public CurrencyInfo getCoinInfo(String cur1) throws URISyntaxException{

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketList.class);

        return response.getBody()
                .getMarketList()
                .stream()
                .filter(a -> a.getCurrA().equals(cur1) && a.getCurrB().equals("USDT"))
                .map(CurrencyInfo::currencyHandler)
                .findFirst()
                .orElse(new CurrencyInfo("nope"));
    }


}
