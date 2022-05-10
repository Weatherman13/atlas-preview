package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PairInfoDTO {
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("quoteVolume")
    private String quoteVolume;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("baseVolume")
    private String baseVolume;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("highestBid")
    private String highestBid;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("high24hr")
    private String high24hr;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("last")
    private String last;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("lowestAsk")
    private String lowestAsk;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("elapsed")
    private String elapsed;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("result")
    private String result;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("low24hr")
    private String low24hr;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("percentChange")
    private String percentChange;

}
