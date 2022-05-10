package ru.thirteenth.kryptohouse.dto.gateio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.thirteenth.kryptohouse.dto.gateio.Currency;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketList {
    @Schema(description = "Result request")
    @JsonProperty("result")
    private String result;
    @Schema(description = "List of cryptocurrency pairs")
    @JsonProperty("data")
    private List<Currency> marketList;
}
