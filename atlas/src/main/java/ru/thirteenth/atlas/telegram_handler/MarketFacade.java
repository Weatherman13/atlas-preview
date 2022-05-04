package ru.thirteenth.atlas.telegram_handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;
import ru.thirteenth.atlas.service.UserServiceImpl;

import java.net.URISyntaxException;

@Component
public class MarketFacade {
    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;

    private final MarketConditionServiceImpl marketConditionService;

    @Autowired
    public MarketFacade(UserServiceImpl userService,
                        ButtonFactoryService buttonService, MarketConditionServiceImpl marketConditionService) {
        this.userService = userService;
        this.buttonService = buttonService;
        this.marketConditionService = marketConditionService;
    }

    public SendMessage getMarketMenu(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.MARKET_MENU);

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("MarketMenuHeader"))
                .replyMarkup(buttonService.getMarketMenu(bundle))
                .build();
    }

    public SendMessage getFearAndGreed(CallbackQuery callback) throws URISyntaxException {
        var userTelegramId = callback.getFrom().getId();
        var bundle = userService.getUserByTelegramId(userTelegramId).getResourceBundle();
        var marketCondition = this.marketConditionService.getMarketCondition();

        userService.updateUserStateByTelegramId(userTelegramId, State.FEAR_AND_GREED);

        return SendMessage.builder()
                .chatId((callback.getMessage().getChatId().toString()))
                .text(bundle.getString("FaQBodyP1") + marketCondition.getValueFnG() +
                        bundle.getString("FaQBodyP2") + marketCondition.getClassificationFnG())
                .replyMarkup(buttonService.getMarketMenu(bundle))
                .build();
    }

    public SendMessage getTop15(CallbackQuery callback) throws URISyntaxException {
        var currencyList = marketConditionService.getTopCurrency();
        System.out.println(currencyList);
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.TOP_15_CAP);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text( " 1. " + currencyList.get(0).getSymbol() +
                        ":  " + currencyList.get(0).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 2. " + currencyList.get(1).getSymbol() +
                        ":  " + currencyList.get(1).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 3. " + currencyList.get(2).getSymbol() +
                        ":  " + currencyList.get(2).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 4. " + currencyList.get(3).getSymbol() +
                        ":  " + currencyList.get(3).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 5. " + currencyList.get(4).getSymbol() +
                        ":  " + currencyList.get(4).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 6. " + currencyList.get(5).getSymbol() +
                        ":  " + currencyList.get(5).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 7. " + currencyList.get(6).getSymbol() +
                        ":  " + currencyList.get(6).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 8. " + currencyList.get(7).getSymbol() +
                        ":  " + currencyList.get(7).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 9. " + currencyList.get(8).getSymbol() +
                        ":  " + currencyList.get(8).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "10. " + currencyList.get(9).getSymbol() +
                        ":  " + currencyList.get(9).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "11. " + currencyList.get(10).getSymbol() +
                        ":  " + currencyList.get(10).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "12. " + currencyList.get(11).getSymbol() +
                        ":  " + currencyList.get(11).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "13. " + currencyList.get(12).getSymbol() +
                        ":  " + currencyList.get(12).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "14. " + currencyList.get(13).getSymbol() +
                        ":  " + currencyList.get(13).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "15. " + currencyList.get(14).getSymbol() +
                        ":  " + currencyList.get(14).getMarketCupS() + "\uD83D\uDCB2" + "\n" + "\n" +
                        "NOTE: USDT, USDC, UST are not included in the top.")
                .replyMarkup(buttonService.getMarketMenu(bundle))
                .build();
    }
}
