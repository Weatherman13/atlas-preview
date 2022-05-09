package ru.thirteenth.atlas.telegram_handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.mapper.UserTelegramEntityMapper;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;
import ru.thirteenth.atlas.service.UserServiceImpl;

import java.net.URISyntaxException;

@Service
@RequiredArgsConstructor
public class CommandFacade {

    private final MarketConditionServiceImpl marketConditionService;

    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;


    public SendMessage start(Message message) {
        var userTelegramId = message.getFrom().getId();
        var userIsPresentInRepository = userService.existsUserByTelegramId(userTelegramId);

        if (!userIsPresentInRepository) {
            var newUser = UserTelegramEntityMapper.INSTANCE.userTelegramToEntity(message.getFrom());
            newUser.setLanguage("RU");
            newUser.setState(State.START.toString());
            userService.save(newUser);
        }
        if (userIsPresentInRepository){
            userService.updateUserStateByTelegramId(userTelegramId, State.START);
        }
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("WelcomeBodyP1") + message.getFrom().getUserName() +
                        bundle.getString("WelcomeBodyP2"))
                .replyMarkup(buttonService.getStartOptionLanguageMenu(bundle))
                .build();
    }


}
