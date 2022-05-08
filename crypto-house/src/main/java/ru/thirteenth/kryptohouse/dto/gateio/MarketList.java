package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.thirteenth.kryptohouse.dto.gateio.Currency;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketList {
    @JsonProperty("result")
    private String result;
    @JsonProperty("data")
    private List<Currency> marketList;
}
