package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Value;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    @Schema(description = "Cryptocurrency ID")
    @JsonProperty("no")
    private int id;
    @Schema(description = "The abbreviated name of the cryptocurrency")
    @JsonProperty("symbol")
    private String symbol;
    @Schema(description = "Name of the cryptocurrency")
    @JsonProperty("name")
    private String name;
    @Schema(description = "Name in English")
    @JsonProperty("nameEn")
    private String nameEn;
    @Schema(description = "Name in Chinese")
    @JsonProperty("nameCh")
    private String nameCh;
    @Schema(description = "Pair")
    @JsonProperty("pair")
    private String pair;
    @Schema(description = "Currency exchange rate")
    @JsonProperty("rate")
    private String rate;
    @Schema(description = "Volatility of the first currency")
    @JsonProperty("vol_a")
    private String volA;
    @Schema(description = "Volatility of the second currency")
    @JsonProperty("vol_b")
    private String volB;
    @Schema(description = "The abbreviated name of the first cryptocurrency")
    @JsonProperty("curr_a")
    private String currA;
    @Schema(description = "The abbreviated name of the second cryptocurrency")
    @JsonProperty("curr_b")
    private String currB;
    @Schema(description = "The abbreviated name of the second cryptocurrency")
    @JsonProperty("curr_suffix")
    private String currSuffix;
    @Schema(description = "The percentage of volatility in 24 hours")
    @JsonProperty("rate_percent")
    private String ratePercent;
    @Schema(description = "Trend")
    @JsonProperty("trend")
    private String trend;
    @Schema(description = "Cryptocurrency Supply")
    @JsonProperty("supply")
    private String supply;
    @Schema(description = "Cryptocurrency Capitalization")
    @JsonProperty("marketcap")
    private String marketCap;
    @JsonProperty("lq")
    private String lq;
    @JsonProperty("p_rate")
    private int pRate;
    @Schema(description = "High in 24 hours")
    @JsonProperty("high")
    private String high;
    @Schema(description = "Low in 24 hours")
    @JsonProperty("low")
    private String low;


}
