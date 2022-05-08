package ru.thirteenth.atlas.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class RubConvertorServiceImpl implements RubConvertorService {
    private final CryptocurrencyInformationService coinInfoService;
    private final RubUsdRateServiceImpl rubUsdRateService;


    @Override
    @SneakyThrows
    public BigDecimal convertCryptoCurToRub(String cryptocurName, double rubCount) {
        var coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName.toLowerCase(Locale.ROOT));


        var rubUsdRate = rubUsdRateService.getRubUsdRate();
        var coinUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf( rubCount * coinUsdtRate * rubUsdRate);
        var result2 =BigDecimal.valueOf(Double.parseDouble(String.format("%.3f", result)));

        return result2;

    }

    @Override
    @SneakyThrows
    public BigDecimal convertRubToCryptoCur(String cryptocurName, double rubCount) {
        var coinInfo = coinInfoService.getCoinInfoBySuf(cryptocurName);


        var rubUsdRate = rubUsdRateService.getRubUsdRate();
        var coinUsdtRate = coinInfo.getRate();

        var result = BigDecimal.valueOf( rubCount / rubUsdRate / coinUsdtRate);
        var result2 = BigDecimal.valueOf(Double.parseDouble(String.format("%.8f", result)));

        return result2;

    }
}
