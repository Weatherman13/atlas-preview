package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pair {
    @JsonProperty("currencyA")
    private final String currencyA;
    @JsonProperty("currencyB")
    private final String currencyB;
}
