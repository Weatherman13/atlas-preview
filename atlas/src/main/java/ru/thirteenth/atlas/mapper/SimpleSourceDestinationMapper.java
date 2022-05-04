package ru.thirteenth.atlas.mapper;


import org.mapstruct.Mapper;
import ru.thirteenth.atlas.main.SimpleDestination;
import ru.thirteenth.atlas.main.SimpleSource;
@Mapper
public interface SimpleSourceDestinationMapper {
    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);
}
