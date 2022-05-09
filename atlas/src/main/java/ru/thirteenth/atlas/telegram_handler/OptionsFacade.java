package ru.thirteenth.atlas.telegram_handler;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.model.Language;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.UserServiceImpl;

@Component
@RequiredArgsConstructor
public class OptionsFacade {
    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;



    public SendMessage getOptionMenu(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.OPTION_MENU);

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("OptionMenuHeader"))
                .replyMarkup(buttonService.getOptionMenu(bundle))
                .build();
    }

    public SendMessage getOptionMenu(CallbackQuery callBack) {
        var userTelegramId = callBack.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.OPTION_MENU);

        return SendMessage.builder()
                .chatId(callBack.getMessage().getChatId().toString())
                .text(bundle.getString("OptionMenuHeader"))
                .replyMarkup(buttonService.getOptionMenu(bundle))
                .build();
    }

    public SendMessage getOptionLanguageMenu(CallbackQuery callBack) {
        var userTelegramId = callBack.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.OPTION_LANGUAGE_MENU);

        return SendMessage.builder()
                .chatId(callBack.getMessage().getChatId().toString())
                .text(bundle.getString("ChooseLanguage"))
                .replyMarkup(buttonService.getOptionLanguageMenu(bundle))
                .build();
    }

    public SendMessage setRuLanguage(CallbackQuery callBack) {
        var userTelegramId = callBack.getFrom().getId();

        userService.updateUserLanguageByTelegramId(userTelegramId, Language.RU);
        userService.updateUserStateByTelegramId(userTelegramId, State.OPTION_MENU);

        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        return SendMessage.builder()
                .chatId(callBack.getMessage().getChatId().toString())
                .text(bundle.getString("CountryChoose"))
                .replyMarkup(buttonService.getNavigationMenu(bundle))
                .build();
    }

    public SendMessage setEnLanguage(CallbackQuery callBack) {
        var userTelegramId = callBack.getFrom().getId();

        userService.updateUserLanguageByTelegramId(userTelegramId, Language.EN);
        userService.updateUserStateByTelegramId(userTelegramId, State.OPTION_MENU);

        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        return SendMessage.builder()
                .chatId(callBack.getMessage().getChatId().toString())
                .text(bundle.getString("CountryChoose"))
                .replyMarkup(buttonService.getNavigationMenu(bundle))
                .build();
    }


}
