package ru.thirteenth.atlas.CryptoBotConfig;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.thirteenth.atlas.service.ButtonFactoryService;
import ru.thirteenth.atlas.service.CryptocurrencyInformationService;
import ru.thirteenth.atlas.service.UserServiceImpl;
import ru.thirteenth.atlas.telegram_handler.*;


@Component
@RequiredArgsConstructor
@Slf4j
public class CryptoBot extends TelegramLongPollingBot {
    private final String BOT_TOKEN = "5304189702:AAHZQMFiaH0zU_XZy9IYb37G_t8oMHCV6Lc";
    private final String BOT2_TEST_TOKEN = "5398211762:AAHkE8t_QSo6CrE7sYLEkLHDARoOH-slJm8";

    private final String BOT_USERNAME = "atlas_syndicate_bot";
    private final String BOT2_TEST_USERNAME = "AtlasTestBot13";

    private final OptionsFacade optionsFacade;
    private final CommandFacade commandFacade;

    private final ButtonFactoryService buttonService;

    private final CallbackQueryFacade callbackFacade;

    private final CryptocurrencyInformationService cryptocurrencyInformationService;

    private final UserServiceImpl userService;

    private final InformationFacade informationFacade;

    private final MarketFacade marketFacade;

    private final СryptocurrencyFacade cryptoCurFacade;


    @Override
    public String getBotToken() {
        return BOT2_TEST_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT2_TEST_USERNAME;
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {


        if (update.hasCallbackQuery()) {
            var payLoad = update.getCallbackQuery().getData();
            var callBack = update.getCallbackQuery();
            var userId = callBack.getFrom().getId();

            log.debug("User: " + userId + ", sent a callback: " + payLoad);

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
                case "GetBackToMarketConditionMenu": {
                    execute(callbackFacade.getMarketConditionMenu(callBack));
                    return;
                }
                case "GetCryptocurrenciesMenu": {
                    execute(cryptoCurFacade.getСryptoCurrencyMenu(callBack));
                    return;
                }
                case "GetCoinInfo": {
                    execute(cryptoCurFacade.getCoinInfoMenu(callBack));
                    return;
                }
                case "GetLanguageOption": {
                    execute(optionsFacade.getOptionLanguageMenu(callBack));
                    return;
                }
                case "SetRuLanguage": {
                    execute(optionsFacade.setRuLanguage(callBack));
                    return;
                }
                case "SetEnLanguage": {
                    execute(optionsFacade.setEnLanguage(callBack));
                    return;
                }

                case "GetOptionMenu": {
                    execute(optionsFacade.getOptionMenu(callBack));
                    return;
                }
                case "GetTop15Cap": {
                    execute(marketFacade.getTop15(callBack));
                    return;
                }
                case "GetFaQ": {
                    execute(marketFacade.getFearAndGreed(callBack));
                    return;
                }
                case "GetSuffixPatternCoinInfo": {
                    execute(cryptoCurFacade.getCoinInfoPattern(callBack));
                    return;
                }
                case "GetNamePatternCoinInfo": {
                    execute(cryptoCurFacade.getCoinInfoPattern(callBack));
                    return;
                }
                case "GetCoinConverter": {
                    execute(cryptoCurFacade.getСryptocurrencyConvertatorMenu(callBack));
                    return;
                }
                case "GetCryptoToFiat": {
                    execute(cryptoCurFacade.getCryptoToFiatConverterMenu(callBack));
                    return;
                }
                case "GetCryptoToUSD": {
                    execute(cryptoCurFacade.getCryptoToFiatSelectUsd(callBack));
                    return;
                }
                case "GetCryptoToRUB": {
                    execute(cryptoCurFacade.getCryptoToFiatSelectRub(callBack));
                    return;
                }
                case "GetFiatToCrypto": {
                    execute(cryptoCurFacade.getFiatToCryptoConverterMenu(callBack));
                    return;
                }
                case "GetUSDToCrypto": {
                    execute(cryptoCurFacade.getFiatToCryptoSelectUsd(callBack));
                    return;
                }
                case "GetRUBToCrypto": {
                    execute(cryptoCurFacade.getFiatToCryptoSelectRub(callBack));
                    return;
                }


            }
        }

        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();

            switch (message.getText()) {
                case "\uD83D\uDDD2Information": {
                    execute(informationFacade.getInfo(message));
                    return;
                }
                case "\uD83D\uDDD2Информация": {
                    execute(informationFacade.getInfo(message));
                    return;
                }
                case "⚙️Settings": {
                    execute(optionsFacade.getOptionMenu(message));
                    return;
                }
                case "⚙️Дополнительно": {
                    execute(optionsFacade.getOptionMenu(message));
                    return;
                }
                case "\uD83C\uDFDBMarket": {
                    execute(marketFacade.getMarketMenu(message));
                    return;
                }
                case "\uD83C\uDFDBРынок": {
                    execute(marketFacade.getMarketMenu(message));
                    return;
                }
                case "₿ Сryptocurrency": {
                    execute(cryptoCurFacade.getСryptoCurrencyMenu(message));
                    return;
                }
                case "₿ Криптовалюта": {
                    execute(cryptoCurFacade.getСryptoCurrencyMenu(message));
                    return;
                }
                case "\uD83D\uDE4D\u200D♂️Profile": {
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(userService.getUserByTelegramId(message
                                            .getFrom()
                                            .getId())
                                    .getResourceBundle()
                                    .getString("Works..."))
                            .build());
                    return;
                }
                case "\uD83D\uDE4D\u200D♂️Профиль": {
                    execute(SendMessage.builder()
                            .chatId(message.getChatId().toString())
                            .text(userService.getUserByTelegramId(message
                                            .getFrom()
                                            .getId())
                                    .getResourceBundle()
                                    .getString("Works..."))
                            .build());
                    return;
                }
            }


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


            if (update.hasMessage() && !update.getMessage().hasEntities()) {
                var user = update.getMessage().getFrom();
                var userTelegramId = user.getId();
                var userState = userService.getStateUserById(userTelegramId);

                switch (userState) {
                    case "COIN_INFO_NAME_PATTERN": {
                        execute(cryptoCurFacade.getCryptocurrencyInfoByName(message));
                        return;
                    }
                    case "COIN_INFO_SUFFIX_PATTERN": {
                        execute(cryptoCurFacade.getCryptocurrencyInfoBySuffix(message));
                        return;
                    }
                    case "CRYPTO_TO_FIAT_SELECT_RUB": {
                        System.out.println(message.getText() + "rub");
                        execute(cryptoCurFacade.getConvertCryptocurrencyToCurrency(message));
                        return;
                    }
                    case "CRYPTO_TO_FIAT_SELECT_USD": {
                        System.out.println(message.getText() + "usd");
                        execute(cryptoCurFacade.getConvertCryptocurrencyToCurrency(message));
                        return;
                    }
                    case "FIAT_TO_CRYPTO_SELECT_USD": {
                        System.out.println(message.getText() + "usd");
                        execute(cryptoCurFacade.getConvertCurrencyToCryptocurrency(message));
                        return;
                    }
                    case "FIAT_TO_CRYPTO_SELECT_RUB": {
                        System.out.println(message.getText() + "rub");
                        execute(cryptoCurFacade.getConvertCurrencyToCryptocurrency(message));
                        return;
                    }
                }
//
            }
        }


    }

}
