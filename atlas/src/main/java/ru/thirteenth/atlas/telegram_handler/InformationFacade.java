package ru.thirteenth.atlas.telegram_handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.exception.UserNotFoundException;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.UserServiceImpl;

@Component
@RequiredArgsConstructor
public class InformationFacade {
    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;

    public SendMessage getInfo(Message message){
        var userTelegramId = message.getFrom().getId();
        var userIsPresentInRep = userService.existsUserByTelegramId(userTelegramId);
        if (userIsPresentInRep){
            userService.updateUserStateByTelegramId(userTelegramId, State.INFO_PAGE);
            var user = userService.getUserByTelegramId(userTelegramId);
            var bundle = user.getResourceBundle();
            return SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(bundle.getString("BotInformationBody"))
                    .build();
        }

        throw new UserNotFoundException("The user was not found in the repository");
    }
}
