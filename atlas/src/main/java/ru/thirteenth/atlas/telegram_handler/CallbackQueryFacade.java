package ru.thirteenth.atlas.telegram_handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.entity.State;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.CoinServiceImpl;
import ru.thirteenth.atlas.service.MarketConditionServiceImpl;
import ru.thirteenth.atlas.service.UserServiceImpl;

import java.net.URISyntaxException;

@Service
public class CallbackQueryFacade {
    private final MarketConditionServiceImpl marketConditionService;
    private final ButtonFactoryService buttonService;
    private final UserServiceImpl userService;

    private final CoinServiceImpl coinService;

    @Autowired
    public CallbackQueryFacade(MarketConditionServiceImpl marketConditionService
            , ButtonFactoryService buttonService, UserServiceImpl userService, CoinServiceImpl coinService) {
        this.marketConditionService = marketConditionService;
        this.buttonService = buttonService;
        this.userService = userService;
        this.coinService = coinService;
    }

    public SendMessage getInfo(CallbackQuery callback){
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.INFO_PAGE);


        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text("INFORMATION \n  \n"+ "This bot is intended for non-commercial use. It provides information about the state " +
                        "of the cryptocurrency market, and also allows you to convert cryptocurrency into fiat.\n \n" +
                        "To improve the user experience, write your ideas to me in private messages.")
                .replyMarkup(buttonService.getBackToMainMenu())
                .build();
    }

    public SendMessage getMainMenu(CallbackQuery callback){
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.MAIN_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text("MENU")
                .replyMarkup(buttonService.getMainMenu())
                .build();
    }

    public SendMessage getMarketConditionMenu(CallbackQuery callback){
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.MARKET_CONDITION_MAIN);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text("MARKET CONDITION MENU")
                .replyMarkup(buttonService.getMarketConditionMenu())
                .build();
    }

    public SendMessage getFearAndGreed(CallbackQuery callback) throws URISyntaxException {
        var marketCondition = this.marketConditionService.getMarketCondition();
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.CHECK_MARKET_CONDITION);

        return SendMessage.builder()
                .chatId((callback.getMessage().getChatId().toString()))
                .text("⚠️CURRENT STATE OF THE MARKET⚠️" + "\n" + "\n"
                        + "\uD83D\uDD70  Fear and Greed Index: "
                        + marketCondition.getValueFnG() + "\n"
                        + "\uD83E\uDD28  Classification: " + marketCondition.getClassificationFnG())
                .replyMarkup(buttonService.getBackToMarketConditionMenu())
                .build();
    }

    public SendMessage getTop15(CallbackQuery callback) throws URISyntaxException {
        var cur = marketConditionService.getTopCurrency();
        var userTelegramId = callback.getFrom().getId();
        userService.updateUserStateByTelegramId(userTelegramId, State.FEAR_AND_GREED);

        return SendMessage.builder()
                .chatId((callback.getMessage().getChatId().toString()))
                .text("⚠️TOP 15 MARKET CAP⚠️" + "\n" + "\n" +
                        " 1. " + cur.get(0).getSymbol() +
                        ":  " + cur.get(0).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 2. " + cur.get(1).getSymbol() +
                        ":  " + cur.get(1).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 3. " + cur.get(2).getSymbol() +
                        ":  " + cur.get(2).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 4. " + cur.get(3).getSymbol() +
                        ":  " + cur.get(3).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 5. " + cur.get(4).getSymbol() +
                        ":  " + cur.get(4).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 6. " + cur.get(5).getSymbol() +
                        ":  " + cur.get(5).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 7. " + cur.get(6).getSymbol() +
                        ":  " + cur.get(6).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 8. " + cur.get(7).getSymbol() +
                        ":  " + cur.get(7).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        " 9. " + cur.get(8).getSymbol() +
                        ":  " + cur.get(8).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "10. " + cur.get(9).getSymbol() +
                        ":  " + cur.get(9).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "11. " + cur.get(10).getSymbol() +
                        ":  " + cur.get(10).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "12. " + cur.get(11).getSymbol() +
                        ":  " + cur.get(11).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "13. " + cur.get(12).getSymbol() +
                        ":  " + cur.get(12).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "14. " + cur.get(13).getSymbol() +
                        ":  " + cur.get(13).getMarketCupS() + "\uD83D\uDCB2" + "\n" +
                        "15. " + cur.get(14).getSymbol() +
                        ":  " + cur.get(14).getMarketCupS() + "\uD83D\uDCB2" + "\n" + "\n"
                        + "NOTE: USDT, USDC, UST are not included in the top.")
                .replyMarkup(buttonService.getBackToMarketConditionMenu())
                .build();
    }

    public SendMessage getСryptoCurrencyMenu(CallbackQuery callback){
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPTOCURRENCY_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text("CRYPTOCURRENCY MENU")
                .replyMarkup(buttonService.getСryptoCurrencyMenu())
                .build();
    }

    public SendMessage getCoinInfoMenu(CallbackQuery callback){
        var userTelegramId = callback.getFrom().getId();

        userService.updateUserStateByTelegramId(userTelegramId, State.COIN_INFO_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text("COIN INFORMATION MENU \n\n" + "Enter the name of the cryptocurrency, please")
                .replyMarkup(buttonService.getCoinInfoMenu())
                .build();
    }

    public SendMessage getAvailableCoin(CallbackQuery callback) throws URISyntaxException {

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(coinService.getAllCoin().toString())
                .replyMarkup(buttonService.getCoinInfoMenu())
                .build();
    }

    // TODO: 5/1/2022 Перенести в другое место, тут не должно быть сообщений
    public SendMessage getInvalidInputCoin(Message message)  {

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text("Invalid input, try again.")
                .replyMarkup(buttonService.getCoinInfoMenu())
                .build();
    }



}
