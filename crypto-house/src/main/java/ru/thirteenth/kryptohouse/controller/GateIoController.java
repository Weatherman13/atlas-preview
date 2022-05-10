package ru.thirteenth.kryptohouse.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Gate-Io-controller")
public class GateIoController {
    private final CoinInfoServiceImpl coinService;

    private final FearAndGreedServiceImpl fngService;


    public GateIoController(CoinInfoServiceImpl coinService, FearAndGreedServiceImpl fngService) {

        this.coinService = coinService;
        this.fngService = fngService;
    }

    @Operation(summary = "A test controller designed for the needs of the developer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/test")
    public void test() {
        coinService.getAllCurrency().getMarketList().stream()
                .filter(a -> a.getCurrB().equals("USDT") && a.getCurrA().equals("AURORA"))
                .forEach(System.out::println);
    }

    @Operation(summary = "Gets a list of supported cryptocurrency pairs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/cryptocurrency-pair")
    public MarketList getAllCurrency() {
        return coinService.getAllCurrency();
    }

    @Operation(summary = "Receives information about a certain cryptocurrency pair")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "400", description = "The entered currency pair is not supported. Try again."),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/cryptocurrency-pair/{cur1}-{cur2}")
    public PairInfoDTO getCurrencyInfo(@PathVariable("cur1") String cur1,
                                       @PathVariable("cur2") String cur2) {

        return coinService.getPairInfo(new PairModel(cur1, cur2));

    }


    @Operation(summary = "Converts the specified currency into RUB")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "503", description = "At the moment, information about the index " +
                    "is not available"),
            @ApiResponse(responseCode = "200", description = "Ok")})
    @GetMapping(value = "/fng")
    public FearAndGreed getFearAndGreed() {
        return fngService.getFearAndGreedIndex();
    }

}


