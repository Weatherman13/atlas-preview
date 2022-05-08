package ru.thirteenth.kryptohouse.dto.faq;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.thirteenth.kryptohouse.dto.faq.FearAndGreed;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FearAndGreedRequest {
    @JsonProperty("name")
    private String name;
    @JsonProperty("data")
    private List<FearAndGreed> fngList;
}
