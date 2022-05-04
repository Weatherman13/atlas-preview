package ru.thirteenth.atlas.main;

import org.mapstruct.factory.Mappers;
import ru.thirteenth.atlas.dto.CurrencyDTO;
import ru.thirteenth.atlas.mapper.CurrencyDtoModelMapper;
import ru.thirteenth.atlas.mapper.SimpleSourceDestinationMapper;

public class Test {
    public static void main(String[] args) {
        SimpleSourceDestinationMapper mapper2
                = Mappers.getMapper(SimpleSourceDestinationMapper.class);
        CurrencyDtoModelMapper mapper = Mappers.getMapper(CurrencyDtoModelMapper.class);

        SimpleSource simpleSource = new SimpleSource();
        simpleSource.setName("Chang");
        simpleSource.setDescription("Hui");

        CurrencyDTO dto = new CurrencyDTO();
        dto.setId(1);
        dto.setSymbol("BTC");
        dto.setName("Bitcoin");
        dto.setRate("38774.96");
        dto.setVolA("7394.3656732059");
        dto.setVolB( "283.214302");
        dto.setCurrA("BTC");
        dto.setCurrB("USDT");
        dto.setCurrSuffix(" USDT");
        dto.setRatePercent("1.03");
        dto.setTrend("up");
        dto.setSupply("19029962.5");
        dto.setMarketCap("737,886,034,739");
        dto.setLq("0");
        dto.setPRate(4);
        dto.setHigh("39175.62");
        dto.setLow("37519.39");
        var result = mapper.currencyDtoToModel(dto);

        System.out.println(result);
    }
}
