package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UsdConvertorServiceImpl implements UsdConvertorService {
    private final CryptocurrencyInformationService coinInfoService;

    @Override
    @SneakyThrows
    public BigDecimal convertCryptoCurToUsd(String cryptocurName, double cryptoCurCount) {
        var coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);


        var cryptocurrencyUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf( cryptocurrencyUsdtRate * cryptoCurCount);
        var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.6f", result)));

        return result2;

    }

    @Override
    @SneakyThrows
    public BigDecimal convertUsdToCryptoCur(String cryptocurName, double usdCount) {
        var coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);

        var cryptocurrencyUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf( usdCount / cryptocurrencyUsdtRate);
        var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.8f", result)));

        return result2;

    }
}
