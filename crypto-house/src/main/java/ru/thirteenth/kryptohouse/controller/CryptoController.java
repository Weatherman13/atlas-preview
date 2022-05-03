package ru.thirteenth.kryptohouse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.thirteenth.kryptohouse.dto.*;
import ru.thirteenth.kryptohouse.service.impl.CoinInfoServiceImpl;
import ru.thirteenth.kryptohouse.service.impl.FearAndGreedServiceImpl;


import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class CryptoController {
    private final CoinInfoServiceImpl coinService;

    private final FearAndGreedServiceImpl fngService;


    public CryptoController(CoinInfoServiceImpl coinService, FearAndGreedServiceImpl fngService) {

        this.coinService = coinService;
        this.fngService = fngService;
    }

    @GetMapping(value = "/coin-all")
    public MarketList getAllCurrency() throws URISyntaxException {
        return coinService.getAllCurrency();
    }

    @PostMapping(value = "/coin-info",
            consumes = "application/json",
            produces = "application/json")
    public Set<Currency> getCurrencyInfo(@RequestBody Set<String> currencyNames) throws URISyntaxException {

        return coinService.getCurrencyInfo(currencyNames);

    }

    @PostMapping(value = "/pair",
            consumes = "application/json",
            produces = "application/json")
    public List<Currency> getPair(@RequestBody Map<String, String> pair) throws URISyntaxException {
        return coinService.getPair(pair);
    }

    @PostMapping(value = "/pair-info",
            consumes = "application/json",
            produces = "application/json")
    public PairInfo getPairInfo(@RequestBody Pair pair) throws URISyntaxException {
        return coinService.getPairInfo(pair);
    }

    @GetMapping(value = "/fng")
    public FearAndGreed getFearAndGreed() throws URISyntaxException {
        return fngService.getFearAndGreedIndex();
    }
}


