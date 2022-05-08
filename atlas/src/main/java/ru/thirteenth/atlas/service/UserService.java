package ru.thirteenth.atlas.service;

import ru.thirteenth.atlas.entity.UserEntity;
import ru.thirteenth.atlas.model.State;

public interface UserService {
    void save(UserEntity userEntity);

    void updateUserStateByTelegramId(long telegramId, State state);

    boolean existsUserByTelegramId(long telegramId);

    String getUserStateById(long telegramId, State state);
}
