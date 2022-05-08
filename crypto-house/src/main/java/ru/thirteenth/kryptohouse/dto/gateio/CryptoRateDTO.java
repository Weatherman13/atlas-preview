package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoRateDTO {
    @JsonProperty("base")
    private String baseSuf;
    @JsonProperty("target")
    private String targetSuf;
    @JsonProperty("price")
    private String price;
    @JsonProperty("volume")
    private String volume;
    @JsonProperty("change")
    private String change;
    @JsonProperty("markets")
    private List<CryptoRateMarketDTO> markets;
}
