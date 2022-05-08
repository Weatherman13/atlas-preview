package ru.thirteenth.atlas.service;

import java.math.BigDecimal;

public interface RubConvertorService {
    BigDecimal convertCryptoCurToRub(String cur, double curCount);

    BigDecimal convertRubToCryptoCur(String cur, double curCount);
}
