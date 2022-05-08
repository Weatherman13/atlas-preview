package ru.thirteenth.atlas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.thirteenth.atlas.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    boolean existsUserByTelegramId(long TelegramMId);

    UserEntity findUserByTelegramId(long TelegramId);


    UserEntity findUserByUsername (String username);


}
