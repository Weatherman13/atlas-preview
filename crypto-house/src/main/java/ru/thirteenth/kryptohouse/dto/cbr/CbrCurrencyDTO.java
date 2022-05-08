package ru.thirteenth.kryptohouse.dto.cbr;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CbrCurrencyDTO {
    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private double value;
    private double previous;
}
