package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoRateMarketDTO {
    @JsonProperty("market")
    private String market;
    @JsonProperty("price")
    private String price;
    @JsonProperty("volume")
    private double volume;

}
