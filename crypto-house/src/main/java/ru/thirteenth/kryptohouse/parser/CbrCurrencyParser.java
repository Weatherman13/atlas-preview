package ru.thirteenth.kryptohouse.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.thirteenth.kryptohouse.dto.cbr.CbrCurrencyDTO;

import java.util.Locale;

@Component
public class CbrCurrencyParser {

    public CbrCurrencyDTO parseTargetCurrency(String json, String targetCurrency) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        var currency = targetCurrency.toUpperCase(Locale.ROOT);
        try {
            jsonNode = mapper.readTree(json);

        } catch (JsonProcessingException e) {

        }
        if (!jsonNode.equals(null)) {
            String id = String.valueOf(jsonNode.get("Valute").get(currency).get("ID"));
            String numCode = String.valueOf(jsonNode.get("Valute").get(currency).get("NumCode"));
            String charCode = String.valueOf(jsonNode.get("Valute").get(currency).get("CharCode"));
            int nominal = Integer.valueOf(
                    String.valueOf(jsonNode.get("Valute").get(currency).get("Nominal")));
            String name = String.valueOf(jsonNode.get("Valute").get(currency).get("Name"));
            double value = Double.valueOf(
                    String.valueOf(jsonNode.get("Valute").get(currency).get("Value")));
            double previous = Double.valueOf(
                    String.valueOf(jsonNode.get("Valute").get(currency).get("Previous")));

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

        throw new JsonInvalidCbrParseException();
    }
}
