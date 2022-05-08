package ru.thirteenth.kryptohouse.controller;


import org.springframework.web.bind.annotation.*;
import ru.thirteenth.kryptohouse.dto.faq.FearAndGreed;
import ru.thirteenth.kryptohouse.dto.gateio.MarketList;
import ru.thirteenth.kryptohouse.dto.gateio.PairInfoDTO;
import ru.thirteenth.kryptohouse.service.impl.CoinInfoServiceImpl;
import ru.thirteenth.kryptohouse.service.impl.FearAndGreedServiceImpl;
import ru.thirteenth.model.PairModel;


import java.net.URISyntaxException;


@RestController
@RequestMapping("/api-v1/gate-io")
public class GateIoController {
    private final CoinInfoServiceImpl coinService;

    private final FearAndGreedServiceImpl fngService;


    public GateIoController(CoinInfoServiceImpl coinService, FearAndGreedServiceImpl fngService) {

        this.coinService = coinService;
        this.fngService = fngService;
    }

    @GetMapping(value = "/cryptocurrency-pair")
    public MarketList getAllCurrency() throws URISyntaxException {
        return coinService.getAllCurrency();
    }

    @GetMapping(value = "/cryptocurrency-pair/{cur1}-{cur2}")
    public PairInfoDTO getCurrencyInfo(@PathVariable("cur1") String cur1,
                                       @PathVariable("cur2") String cur2) throws URISyntaxException {

        return coinService.getPairInfo(new PairModel(cur1,cur2));

    }



    @GetMapping(value = "/fng")
    public FearAndGreed getFearAndGreed() throws URISyntaxException {
        return fngService.getFearAndGreedIndex();
    }

}


