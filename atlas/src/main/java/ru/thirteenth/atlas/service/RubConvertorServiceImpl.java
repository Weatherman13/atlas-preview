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
@RequiredArgsConstructor
@Slf4j
public class RubConvertorServiceImpl implements RubConvertorService {
    private final CryptocurrencyInformationService coinInfoService;
    private final RubUsdRateService rubUsdRateService;


    @Override
    public BigDecimal convertCryptoCurToRub(String cryptocurName, double rubCount) {
        CurrencyModel coinInfo = null;

        log.debug("Сonversion " + cryptocurName.toUpperCase() + " --> RUB :" + " STARTED");

        try {
            coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName.toLowerCase(Locale.ROOT));


            var rubUsdRate = rubUsdRateService.getRubUsdRate();
            var coinUsdtRate = coinInfo.getRate();

            var result = BigDecimal.valueOf(rubCount * coinUsdtRate * rubUsdRate);
            var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.3f", result)));

            log.debug("Сonversion " + cryptocurName.toUpperCase() + " --> RUB :" + " SUCCESSFUL");

            return result2;
        } catch (URISyntaxException e) {

            log.debug("Сonversion " + cryptocurName.toUpperCase() + " --> RUB :" + " FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }
    }

    @Override
    public BigDecimal convertRubToCryptoCur(String cryptocurName, double rubCount) {
        CurrencyModel coinInfo = null;

        log.debug("Сonversion " + "RUB --> " + cryptocurName.toUpperCase(Locale.ROOT) + " :" + " STARTED");
        try {
            coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);

            var rubUsdRate = rubUsdRateService.getRubUsdRate();
            var coinUsdtRate = coinInfo.getRate();

            var result = BigDecimal.valueOf(rubCount / rubUsdRate / coinUsdtRate);
            var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.8f", result)));

            log.debug("Сonversion " + "RUB --> " + cryptocurName.toUpperCase(Locale.ROOT) + " :" + " SUCCESSFUL");

            return result2;
        } catch (URISyntaxException e) {

            log.debug("Сonversion " + "RUB --> " + cryptocurName.toUpperCase(Locale.ROOT) + " :" + " FAILED");
            throw new RuntimeException("Endpoint is invalid");
        }


    }
}
