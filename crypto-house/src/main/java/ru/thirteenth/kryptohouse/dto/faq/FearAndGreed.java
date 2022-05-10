package ru.thirteenth.kryptohouse.dto.faq;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FearAndGreed {
    @Schema(description = "The value of the fear and greed indicator")
    @JsonProperty("value")
    private String value;
    @Schema(description = "Verbal classification of the index value")
    @JsonProperty("value_classification")
    private String valueClassification;
    @Schema(description = "Timestamp")
    @JsonProperty("timestamp")
    private String timestamp;
    @Schema(description = "Time until update")
    @JsonProperty("time_until_update")
    private String timeUntilUpdate;
}
