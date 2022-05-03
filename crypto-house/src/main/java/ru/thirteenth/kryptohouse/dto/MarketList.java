package ru.thirteenth.kryptohouse.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketList {
    @JsonProperty("result")
    private String result;
    @JsonProperty("data")
    private List<Currency> marketList;
}
