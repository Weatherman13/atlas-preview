package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PairInfoDTO {
    @JsonProperty("quoteVolume")
    private String quoteVolume;
    @JsonProperty("baseVolume")
    private String baseVolume;
    @JsonProperty("highestBid")
    private String highestBid;
    @JsonProperty("high24hr")
    private String high24hr;
    @JsonProperty("last")
    private String last;
    @JsonProperty("lowestAsk")
    private String lowestAsk;
    @JsonProperty("elapsed")
    private String elapsed;
    @JsonProperty("result")
    private String result;
    @JsonProperty("low24hr")
    private String low24hr;
    @JsonProperty("percentChange")
    private String percentChange;

}
