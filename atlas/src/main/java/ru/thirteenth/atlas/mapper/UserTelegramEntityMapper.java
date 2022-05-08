package ru.thirteenth.atlas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.thirteenth.atlas.entity.UserEntity;
import ru.thirteenth.atlas.model.Language;

import static ru.thirteenth.atlas.model.State.START;

@Mapper(componentModel = "spring")
public interface UserTelegramEntityMapper {

    UserTelegramEntityMapper INSTANCE = Mappers.getMapper(UserTelegramEntityMapper.class);

    @Mappings({
            @Mapping(target = "telegramId", source = "user.id"),
            @Mapping(target = "username", source = "user.userName"),
    })
    UserEntity userTelegramToEntity(User user);


}
