package ru.thirteenth.kryptohouse.dto.faq;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FearAndGreed {
    @JsonProperty("value")
    private String value;
    @JsonProperty("value_classification")
    private String valueClassification;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("time_until_update")
    private String timeUntilUpdate;
}
