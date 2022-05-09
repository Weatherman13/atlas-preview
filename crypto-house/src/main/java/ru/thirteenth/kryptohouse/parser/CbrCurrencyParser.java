package ru.thirteenth.kryptohouse.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.thirteenth.kryptohouse.dto.cbr.CbrCurrencyDTO;

import java.util.Locale;

@Component
@Slf4j
public class CbrCurrencyParser {

    public CbrCurrencyDTO parseTargetCurrency(String json, String targetCurrency) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        var currency = targetCurrency.toUpperCase(Locale.ROOT);

        log.debug("Parse currency: " + " STARTED");
        try {
            jsonNode = mapper.readTree(json);


            if (!jsonNode.equals(null)) {

                String id = String.valueOf(jsonNode.get("Valute").get(currency).get("ID"));
                String numCode = String.valueOf(jsonNode.get("Valute").get(currency).get("NumCode"));
                String charCode = String.valueOf(jsonNode.get("Valute").get(currency).get("CharCode"));
                int nominal = Integer.parseInt(
                        String.valueOf(jsonNode.get("Valute").get(currency).get("Nominal")));
                String name = String.valueOf(jsonNode.get("Valute").get(currency).get("Name"));
                double value = Double.parseDouble(
                        String.valueOf(jsonNode.get("Valute").get(currency).get("Value")));
                double previous = Double.parseDouble(
                        String.valueOf(jsonNode.get("Valute").get(currency).get("Previous")));

                log.debug("Parse currency: " + " SUCCESSFUL");

                return CbrCurrencyDTO.builder()
                        .id(id)
                        .numCode(numCode)
                        .charCode(charCode)
                        .nominal(nominal)
                        .name(name)
                        .value(value)
                        .previous(previous)
                        .build();
            }

            log.debug("Parse currency: " + " FAILED");
            throw new JsonInvalidCbrParseException();

        } catch (JsonProcessingException e) {
            log.debug("Parse currency: " + " FAILED");
            throw new RuntimeException("JSON node is invalid");
        }
    }
}
