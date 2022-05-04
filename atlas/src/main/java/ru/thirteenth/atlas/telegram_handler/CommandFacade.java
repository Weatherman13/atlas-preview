package ru.thirteenth.atlas.telegram_handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.entity.User;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;
import ru.thirteenth.atlas.service.UserServiceImpl;

import java.net.URISyntaxException;

@Service
public class CommandFacade {

    private final MarketConditionServiceImpl marketConditionService;

    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;

    @Autowired
    public CommandFacade(MarketConditionServiceImpl marketConditionService, UserServiceImpl userService, ButtonFactoryService buttonService) {
        this.marketConditionService = marketConditionService;
        this.userService = userService;
        this.buttonService = buttonService;
    }

    public SendMessage start(Message message) {
        var userTelegramId = message.getFrom().getId();
        var userIsPresentInRepository = userService.existsUserByTelegramId(userTelegramId);

        if (!userIsPresentInRepository)
            userService.save(User.telegramUserMapper(message.getFrom()));
        if (userIsPresentInRepository)
            userService.updateUserStateByTelegramId(userTelegramId, State.START);

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text("Welcome! " + "Nice to see you, " + message.getFrom().getUserName() + "!" + "\n" +
                        "Choose the option you need, please.")
                .replyMarkup(buttonService.getMainMenu())
                .build();
    }

    public SendMessage checkMarketCondition(Message message) throws URISyntaxException {
        var marketCondition = this.marketConditionService.getMarketCondition();
        var userTelegramId = message.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.START);

        return SendMessage.builder()
                .chatId((message.getChatId().toString()))
                .text("⚠️CURRENT STATE OF THE MARKET⚠️" + "\n" + "\n"
                        + "\uD83D\uDD70  Fear and Greed Index: "
                        + marketCondition.getValueFnG() + "\n"
                        + "\uD83E\uDD28  Classification: " + marketCondition.getClassificationFnG())
                .replyMarkup(buttonService.getMainMenu())
                .build();
    }

    public SendMessage getTop15(Message message) throws URISyntaxException {
        var cur = marketConditionService.getTopCurrency();
        var userTelegramId = message.getFrom().getId();
        userService.updateUserStateByTelegramId(userTelegramId, State.START);

        return SendMessage.builder()
                .chatId((message.getChatId().toString()))
                .text("⚠️TOP 15 MARKET CAP⚠️" + "\n" + "\n" +
//                        cur.stream().map(CurrencyInfo::toString)
//                        ":  " + cur.get(0).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 2. " + cur.get(1).getSymbol() +
//                        ":  " + cur.get(1).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 3. " + cur.get(2).getSymbol() +
//                        ":  " + cur.get(2).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 4. " + cur.get(3).getSymbol() +
//                        ":  " + cur.get(3).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 5. " + cur.get(4).getSymbol() +
//                        ":  " + cur.get(4).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 6. " + cur.get(5).getSymbol() +
//                        ":  " + cur.get(5).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 7. " + cur.get(6).getSymbol() +
//                        ":  " + cur.get(6).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 8. " + cur.get(7).getSymbol() +
//                        ":  " + cur.get(7).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        " 9. " + cur.get(8).getSymbol() +
//                        ":  " + cur.get(8).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "10. " + cur.get(9).getSymbol() +
//                        ":  " + cur.get(9).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "11. " + cur.get(10).getSymbol() +
//                        ":  " + cur.get(10).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "12. " + cur.get(11).getSymbol() +
//                        ":  " + cur.get(11).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "13. " + cur.get(12).getSymbol() +
//                        ":  " + cur.get(12).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "14. " + cur.get(13).getSymbol() +
//                        ":  " + cur.get(13).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
//                        "15. " + cur.get(14).getSymbol() +
//                        ":  " + cur.get(14).getMarketCupS() + "\uD83D\uDCB2" + "\n" + "\n"
                         "NOTE: USDT, USDC, UST are not included in the top.")
                .replyMarkup(buttonService.getMainMenu())
                .build();
    }
}
