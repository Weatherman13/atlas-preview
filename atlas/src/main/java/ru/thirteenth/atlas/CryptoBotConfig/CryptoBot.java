package ru.thirteenth.atlas.CryptoBotConfig;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.CoinServiceImpl;
import ru.thirteenth.atlas.service.UserServiceImpl;
import ru.thirteenth.atlas.telegram_handler.CallbackQueryFacade;
import ru.thirteenth.atlas.telegram_handler.CommandFacade;


@Component
public class CryptoBot extends TelegramLongPollingBot {
    private final String BOT_TOKEN = "5304189702:AAHZQMFiaH0zU_XZy9IYb37G_t8oMHCV6Lc";
    private final String BOT_USERNAME = "atlas_syndicate_bot";

//    private final MarketConditionService serv = MarketConditionService.getInstance();

    private final CommandFacade commandFacade;

    private final ButtonFactoryService buttonService;

    private final CallbackQueryFacade callbackFacade;

    private final CoinServiceImpl coinService;

    private final UserServiceImpl userService;

    @Autowired
    public CryptoBot(CommandFacade commandFacade, ButtonFactoryService buttonService, CallbackQueryFacade callbackFacade, CoinServiceImpl coinService, UserServiceImpl userService) {
        this.commandFacade = commandFacade;
        this.buttonService = buttonService;
        this.callbackFacade = callbackFacade;
        this.coinService = coinService;
        this.userService = userService;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && !update.getMessage().hasEntities() && userService.getStateUserById(update
                .getMessage()
                .getFrom()
                .getId()).equals("COIN_INFO_MENU")) {
            var coinInfo = coinService.getCoinInfo(update.getMessage().getText().toUpperCase());

            if (!coinInfo.getSymbol().equals("nope"))
                execute(SendMessage.builder()
                        .chatId(update
                                .getMessage()
                                .getChatId()
                                .toString())
                        .text("Name: " + coinInfo.getName() + "\n" +
                                "Symbol: " + coinInfo.getSymbol() + "\n" +
                                "Rate: " + coinInfo.getRate()+" \uD83D\uDCB2" + "\n" +
                                "Volatility: " + coinInfo.getVolA()+" \uD83D\uDCB2" + "\n" +
                                "Rate percent: " + coinInfo.getRatePercent() + "\n" +
                                "Trend: " + coinInfo.trendToString(coinInfo) + "\n" +
                                "Marketcap: " + coinInfo.getMarketCup()+" \uD83D\uDCB2" + "\n" +
                                "High: " + coinInfo.getHigh()+" \uD83D\uDCB2" + "\n" +
                                "Low: " + coinInfo.getLow()+" \uD83D\uDCB2" + "\n\n\n" +
                                "Note: Continue typing or go back")
                        .replyMarkup(buttonService.getCoinInfoMenu())
                        .build());
            else execute(callbackFacade.getInvalidInputCoin(update.getMessage()));
        }


        if (update.hasCallbackQuery() ) {
            var payLoad = update.getCallbackQuery().getData();
            var callBack = update.getCallbackQuery();
            System.out.println(payLoad);

            switch (payLoad) {
                case "GetInfo": {
                    execute(callbackFacade.getInfo(callBack));
                    return;
                }
                case "GetBackToMainPage": {
                    execute(callbackFacade.getMainMenu(callBack));
                    return;
                }
                case "GetMarketCondition": {
                    execute(callbackFacade.getMarketConditionMenu(callBack));
                    return;
                }
                case "GetTop15": {
                    execute(callbackFacade.getTop15(callBack));
                    return;
                }
                case "GetFaG": {
                    execute(callbackFacade.getFearAndGreed(callBack));
                    return;
                }
                case "GetBackToMarketConditionMenu": {
                    execute(callbackFacade.getMarketConditionMenu(callBack));
                    return;
                }
                case "GetCryptocurrencies": {
                    execute(callbackFacade.getСryptoCurrencyMenu(callBack));
                    return;
                }
                case "GetCoinInfo": {
                    execute(callbackFacade.getCoinInfoMenu(callBack));
                    return;
                }
                case "GetAvailableCryptocurrencies": {
                    execute(callbackFacade.getAvailableCoin(callBack));
                    return;
                }

            }
        }

        if (update.hasMessage() ) {
            Message message = update.getMessage();

            if (message.hasEntities()) {

                var commandIsPresent = message.getEntities()
                        .stream()
                        .anyMatch(ent -> ent
                                .getType()
                                .equals("bot_command"));

                if (commandIsPresent) {

                    var command = message.getText();

                    switch (command) {
                        case "/start": {
                            execute(commandFacade.start(message));
                            return;
                        }
                        case "/check_market_condition": {
                            execute(commandFacade.checkMarketCondition(message));
                            return;
                        }
                        case "/get_top15": {

                            execute(commandFacade.getTop15(message));
                            return;
                        }
                        case "/test_button": {

                            execute(SendMessage.builder()
                                    .text("Please choose Orig")
                                    .chatId(message.getChatId().toString())
                                    .replyMarkup(buttonService.getMainMenu())
                                    .build());
                            return;
                        }
                        case "/test_keybutton": {
                            var user = userService.getUserByTelegramId(message.getFrom().getId());
                            var bundle = user.getResourceBundle();
                            execute(SendMessage.builder()
                                    .chatId(message.getChatId().toString())
                                    .text("check button")
                                    .replyMarkup(buttonService.getNavigationMenu(bundle))
                                    .build());
                            return;
                        }
                    }

                }
            }
        }


    }

}
