package ru.thirteenth.atlas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FearAndGreedResponseDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("data")
    private List<FearAndGreedDTO> fngList;
}
