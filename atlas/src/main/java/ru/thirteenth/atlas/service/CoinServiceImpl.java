package ru.thirteenth.atlas.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.thirteenth.atlas.dto.MarketListDTO;

import ru.thirteenth.atlas.mapper.CurrencyDtoModelMapper;
import ru.thirteenth.atlas.model.CurrencyModel;
import ru.thirteenth.atlas.model.PairModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoinServiceImpl {
    private final String CRYPTO_HOUSE_SERVICE = "http://cryptohouse/";
    private final RestTemplate restTemplate;

    private final CurrencyDtoModelMapper currencyMapper = CurrencyDtoModelMapper.INSTANCE;

    @Autowired
    public CoinServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // TODO: 5/4/2022 Переписать с учётом моделей и дтошек
    public List<String> getAllCoin() throws URISyntaxException {

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketListDTO.class);
        return response.getBody()
                .getMarketList()
                .stream()
                .filter(cur -> cur.getCurrB().equals("USDT"))
                .map(cur -> currencyMapper.currencyDtoToModel(cur))
                .sorted(Comparator.comparing(CurrencyModel::getMarketCup).reversed())
                .limit(121)
                .parallel()
                .map(a -> new PairModel(a.getCurrA(),a.getName()))
                .map(a -> a.getCurrencyB() + ": " + a.getCurrencyA())
                .collect(Collectors.toList());


    }

    public CurrencyModel getCoinInfo(String cur1) throws URISyntaxException{

        var response =
                restTemplate.getForEntity(new URI(CRYPTO_HOUSE_SERVICE + "coin-all"), MarketListDTO.class);

        return response.getBody()
                .getMarketList()
                .stream()
                .filter(a -> a.getCurrA().equals(cur1) && a.getCurrB().equals("USDT"))
                .map(obj -> currencyMapper.currencyDtoToModel(obj))
                .findFirst()
                .orElse(new CurrencyModel("nope"));
    }

}
