package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.thirteenth.atlas.model.CurrencyModel;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Locale;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsdConvertorServiceImpl implements UsdConvertorService {
    private final CryptocurrencyInformationService coinInfoService;

    @Override

    public BigDecimal convertCryptoCurToUsd(String cryptocurName, double cryptoCurCount) {
        CurrencyModel coinInfo = null;

        log.debug("Сonversion " + cryptocurName.toUpperCase() + " --> USDT :" + " STARTED");
        coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);

        var cryptocurrencyUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf(cryptocurrencyUsdtRate * cryptoCurCount);
        var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.6f", result)));

        log.debug("Сonversion " + cryptocurName.toUpperCase() + " --> USDT :" + " SUCCESSFUL");
        return result2;

    }

    @Override
    public BigDecimal convertUsdToCryptoCur(String cryptocurName, double usdCount) {
        CurrencyModel coinInfo = null;

        log.debug("Сonversion " + "USDT --> " + cryptocurName.toUpperCase(Locale.ROOT) + " :" + " STARTED");
        coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);

        var cryptocurrencyUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf(usdCount / cryptocurrencyUsdtRate);
        var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.8f", result)));

        log.debug("Сonversion " + "USDT --> " + cryptocurName.toUpperCase(Locale.ROOT) + " :" + " SUCCESSFUL");

        return result2;

    }
}
