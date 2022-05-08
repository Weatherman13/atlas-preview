package ru.thirteenth.atlas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ru.thirteenth.atlas.dto.CurrencyDTO;
import ru.thirteenth.atlas.model.CurrencyModel;

@Mapper(componentModel = "spring")
public interface CurrencyDtoModelMapper {
    CurrencyDtoModelMapper INSTANCE = Mappers.getMapper(CurrencyDtoModelMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "currencyDTO.id"),
            @Mapping(target = "symbol", source = "currencyDTO.symbol"),
            @Mapping(target = "name", source = "currencyDTO.name"),
            @Mapping(target = "pairModel.currencyA", source = "currencyDTO.currA"),
            @Mapping(target = "pairModel.currencyB", source = "currencyDTO.currB"),
            @Mapping(target = "rate", source = "currencyDTO.rate"),
            @Mapping(target = "volA", source = "currencyDTO.volA"),
            @Mapping(target = "volB", source = "currencyDTO.volB"),
            @Mapping(target = "currA", source = "currencyDTO.currA"),
            @Mapping(target = "currB", source = "currencyDTO.currB"),
            @Mapping(target = "ratePercent", source = "currencyDTO.ratePercent"),
            @Mapping(target = "trend", source = "currencyDTO.trend"),
            @Mapping(target = "supply", source = "currencyDTO.supply"),
            @Mapping(target = "marketCup", source = "currencyDTO.marketCap"),
            @Mapping(target = "marketCupS", source = "currencyDTO.marketCap"),
            @Mapping(target = "lq", source = "currencyDTO.lq"),
            @Mapping(target = "high", source = "currencyDTO.high"),
            @Mapping(target = "low", source = "currencyDTO.low"),
    })
    CurrencyModel currencyDtoToModel(CurrencyDTO currencyDTO);

    default long stringToLong(String string) {
        if (string.contains(",")) return Long.parseLong(string.replace(",", ""));
        else return Long.parseLong(string);
    }

    default double stringToDouble(String string) {
        if (string.contains(",")) return Double.parseDouble(
                string.replace(",", ""));
        else return Double.parseDouble(
                String.format("%.3f", Double.parseDouble(string.replace(" ", ""))));
    }

//    CurrencyDTO currencyModelToDto(CurrencyModel currencyModel);
}
