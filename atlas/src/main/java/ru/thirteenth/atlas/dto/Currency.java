package ru.thirteenth.atlas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    @JsonProperty("no")
    private int id;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nameEn")
    private String nameEn;
    @JsonProperty("nameCh")
    private String nameCh;
    @JsonProperty("pair")
    private String pair;
    @JsonProperty("rate")
    private String rate;
    @JsonProperty("vol_a")
    private String volA;
    @JsonProperty("vol_b")
    private String volB;
    @JsonProperty("curr_a")
    private String currA;
    @JsonProperty("curr_b")
    private String currB;
    @JsonProperty("curr_suffix")
    private String currSuffix;
    @JsonProperty("rate_percent")
    private String ratePercent;
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("supply")
    private String supply;
    @JsonProperty("marketcap")
    private String marketCap;
    @JsonProperty("lq")
    private String lq;
    @JsonProperty("p_rate")
    private int pRate;
    @JsonProperty("high")
    private String high;
    @JsonProperty("low")
    private String low;


}
