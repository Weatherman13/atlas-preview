package ru.thirteenth.atlas.service;

import java.math.BigDecimal;

public interface UsdConvertorService {

    BigDecimal convertCryptoCurToUsd(String cur, double curCount);

    BigDecimal convertUsdToCryptoCur(String cur, double curCount);
}
