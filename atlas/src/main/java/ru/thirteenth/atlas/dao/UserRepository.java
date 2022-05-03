package ru.thirteenth.atlas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.thirteenth.atlas.entity.Language;
import ru.thirteenth.atlas.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsUserByTelegramId(long TelegramMId);

    User findUserByTelegramId(long TelegramId);


    User findUserByUsername (String username);


}
