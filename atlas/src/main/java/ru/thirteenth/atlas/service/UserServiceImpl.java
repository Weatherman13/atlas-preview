package ru.thirteenth.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.thirteenth.atlas.dao.UserRepository;
import ru.thirteenth.atlas.model.Language;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserEntity userEntity) {
        repository.save(userEntity);
    }

    public void updateUserStateByTelegramId(long telegramId, State state) {
        var user = repository.findUserByTelegramId(telegramId);
        user.setState(state.toString());
        repository.save(user);
    }

    public void updateUserLanguageByTelegramId(long telegramId, Language language){
        var user = repository.findUserByTelegramId(telegramId);
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
