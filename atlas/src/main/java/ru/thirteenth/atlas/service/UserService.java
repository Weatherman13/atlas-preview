package ru.thirteenth.atlas.service;

import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.entity.User;

public interface UserService {
    void save(User user);

    void updateUserStateByTelegramId(long telegramId, State state);

    boolean existsUserByTelegramId(long telegramId);

    String getUserStateById(long telegramId, State state);
}
