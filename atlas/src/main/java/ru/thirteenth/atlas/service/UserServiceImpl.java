package ru.thirteenth.atlas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.thirteenth.atlas.dao.UserRepository;
import ru.thirteenth.atlas.model.Language;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.entity.UserEntity;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserEntity userEntity) {
        repository.save(userEntity);

        log.debug( "User: " + userEntity.getId() + "successfully added to the database");
    }

    public void updateUserStateByTelegramId(long telegramId, State state) {
        var user = repository.findUserByTelegramId(telegramId);

        log.debug( "User: " + user.getTelegramId() +" " + "changed the state: " +
                user.getState() + " --> " + state.toString());

        user.setState(state.toString());
        repository.save(user);
    }

    public void updateUserLanguageByTelegramId(long telegramId, Language language){
        var user = repository.findUserByTelegramId(telegramId);

        log.debug( "User: " + user.getTelegramId() +" " + "changed the language: " +
                user.getLanguage() + " --> " + language.toString());

        user.setLanguage(language.toString());
        repository.save(user);
    }

    public String getStateUserById(long telegramId){
        return repository.findUserByTelegramId(telegramId).getState();
    }

    public boolean existsUserByTelegramId(long telegramId) {
        return repository.existsUserByTelegramId(telegramId);
    }


    public String getUserStateById(long telegramId, State state) {
        return repository.findUserByTelegramId(telegramId).getState();
    }

    public UserEntity getUserByUsername(String username){
        return repository.findUserByUsername(username);
    }

    public UserEntity getUserByTelegramId(long telegramId){
        return repository.findUserByTelegramId(telegramId);
    }

}
