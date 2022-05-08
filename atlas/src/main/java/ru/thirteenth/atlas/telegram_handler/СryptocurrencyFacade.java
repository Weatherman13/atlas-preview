package ru.thirteenth.atlas.telegram_handler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.thirteenth.atlas.model.State;
import ru.thirteenth.atlas.service.*;

import java.net.URISyntaxException;


@Component
@RequiredArgsConstructor
public class СryptocurrencyFacade {
    private final UserServiceImpl userService;

    private final ButtonFactoryService buttonService;

    private final CryptocurrencyInformationService cryptocurrencyInformationService;

    private final RubConvertorServiceImpl rubConvertorService;

    private final UsdConvertorServiceImpl usdConvertorService;

    public SendMessage getСryptoCurrencyMenu(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPTOCURRENCY_MENU);

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("СryptoCurrencyMenuHeader"))
                .replyMarkup(buttonService.getСryptoсurrencyMenu(bundle))
                .build();
    }

    public SendMessage getСryptoCurrencyMenu(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPTOCURRENCY_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString("СryptoCurrencyMenuHeader"))
                .replyMarkup(buttonService.getСryptoсurrencyMenu(bundle))
                .build();
    }

    public SendMessage getCoinInfoMenu(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.COIN_INFO_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString("CoinInfoMenuHeader") + bundle.getString("CoinInfoMenuBody"))
                .replyMarkup(buttonService.getCoinInfoMenu(bundle))
                .build();
    }


    public SendMessage getCoinInfoPattern(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();
        var payload = callback.getData();


        if (payload.equals("GetSuffixPatternCoinInfo")) {
            userService.updateUserStateByTelegramId(userTelegramId, State.COIN_INFO_SUFFIX_PATTERN);
        } else {
            userService.updateUserStateByTelegramId(userTelegramId, State.COIN_INFO_NAME_PATTERN);
        }

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString(payload))
                .replyMarkup(buttonService.getBackToCoinInfoMenu(bundle))
                .build();
    }

    public SendMessage getCryptocurrencyInfoBySuffix(Message message) throws URISyntaxException {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();
        var pattern = message.getText();

        var resultCurrency = cryptocurrencyInformationService.getCoinInfoBySuf(pattern);
        System.out.println(resultCurrency);

        if (resultCurrency.getSymbol().equals("none"))
            return SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(bundle.getString("InvalidCryptocurrencyInfoSuffixPatternHeader") +
                            bundle.getString("InvalidCryptocurrencyInfoSuffixPatternBody"))
                    .replyMarkup(buttonService.getBackToCoinInfoMenu(bundle))
                    .build();

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(resultCurrency.toStringInfo(bundle))
                .replyMarkup(buttonService.getBackToCoinInfoMenu(bundle))
                .build();
    }

    @SneakyThrows
    public SendMessage getCryptocurrencyInfoByName(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();
        var pattern = message.getText();

        var resultCurrency = cryptocurrencyInformationService.getCoinInfoByName(pattern);
        System.out.println(resultCurrency);

        if (resultCurrency.getSymbol().equals("none"))
            return SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(bundle.getString("InvalidCryptocurrencyInfoNamePatternHeader") +
                            bundle.getString("InvalidCryptocurrencyInfoNamePatternBody"))
                    .replyMarkup(buttonService.getBackToCoinInfoMenu(bundle))
                    .build();

        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(resultCurrency.toStringInfo(bundle))
                .replyMarkup(buttonService.getBackToCoinInfoMenu(bundle))
                .build();
    }


    public SendMessage getСryptocurrencyConvertatorMenu(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CONVERTATOR_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString("СryptocurrencyConverterMenuHeader") +
                        bundle.getString("СryptocurrencyConverterMenuBody"))
                .replyMarkup(buttonService.getСryptocurrencyConvertatorMenu(bundle))
                .build();
    }


    public SendMessage getCryptoToFiatConverterMenu(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPT_TO_FIAT_CONVERTATOR_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString("CryptoToFiatHeader") +
                        bundle.getString("CryptoToFiatBody"))
                .replyMarkup(buttonService.getCryptoToFiatConverterMenu(bundle))
                .build();
    }

    public EditMessageReplyMarkup getCryptoToFiatSelectRub(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPTO_TO_FIAT_SELECT_RUB);

        return EditMessageReplyMarkup.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .messageId(callback.getMessage().getMessageId())
                .replyMarkup(buttonService.getCryptoToFiatConverterMenuSelectRub(bundle))
                .build();
    }

    public EditMessageReplyMarkup getCryptoToFiatSelectUsd(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPTO_TO_FIAT_SELECT_USD);

        return EditMessageReplyMarkup.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .messageId(callback.getMessage().getMessageId())
                .replyMarkup(buttonService.getCryptoToFiatConverterMenuSelectUsd(bundle))
                .build();
    }

    @SneakyThrows
    public SendMessage getConvertCryptocurrencyToCurrency(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();
        var curNameAndCount = message.getText().replace(" ", "").split(",");

        if ((curNameAndCount.length == 2) &&
                !(cryptocurrencyInformationService
                        .getCoinInfoBySuf(curNameAndCount[0])
                        .getSymbol()
                        .equals("none"))){

            var cryptocurName = curNameAndCount[0];
            var currencyCount = Double.parseDouble(curNameAndCount[1]);

            if (user.getState().equals("CRYPTO_TO_FIAT_SELECT_RUB")) {

                var rate = rubConvertorService.convertCryptoCurToRub(cryptocurName,currencyCount);

                return SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text(bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputHeader")+
                                bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputBody") +
                                currencyCount + " " + cryptocurName.toUpperCase() + " = "
                                + rate.toEngineeringString() + " RUB")
                        .replyMarkup(buttonService.getCryptoToFiatConverterMenuSelectRub(bundle))
                        .build();
            }
            var rate = usdConvertorService.convertCryptoCurToUsd(cryptocurName,currencyCount);

            return SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputHeader")+
                            bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputBody") +
                            currencyCount + " " + cryptocurName.toUpperCase() + " = "
                            + rate.toEngineeringString() + " USD")
                    .replyMarkup(buttonService.getCryptoToFiatConverterMenuSelectUsd(bundle))
                    .build();

        }
        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("ConvertCryptocurrencyToCurrencyInvalidInputHeader")+
                        bundle.getString("ConvertCryptocurrencyToCurrencyInvalidInputBody"))
                .build();
    }

    @SneakyThrows
    public SendMessage getConvertCurrencyToCryptocurrency(Message message) {
        var userTelegramId = message.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();
        var curNameAndCount = message.getText().replace(" ", "").split(",");

        if ((curNameAndCount.length == 2) &&
                !(cryptocurrencyInformationService
                        .getCoinInfoBySuf(curNameAndCount[0])
                        .getSymbol()
                        .equals("none"))){

            var cryptocurName = curNameAndCount[0];
            var currencyCount = Double.parseDouble(curNameAndCount[1]);

            if (user.getState().equals("FIAT_TO_CRYPTO_SELECT_RUB")) {

                var rate = rubConvertorService.convertRubToCryptoCur(cryptocurName,currencyCount);

                return SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text(bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputHeader")+
                                bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputBody") +
                                currencyCount + " RUB" + " = "
                                + rate.toEngineeringString() + " " + cryptocurName.toUpperCase())
                        .replyMarkup(buttonService.getFiatToCryptoConverterMenuSelectRub(bundle))
                        .build();
            }
            var rate = usdConvertorService.convertUsdToCryptoCur(cryptocurName,currencyCount);

            return SendMessage.builder()
                    .chatId(message.getChatId().toString())
                    .text(bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputHeader")+
                            bundle.getString("ConvertCryptocurrencyToCurrencyCorrectInputBody") +
                            currencyCount + " USD" + " = "
                            + rate.toEngineeringString() + " " + cryptocurName.toUpperCase())
                    .replyMarkup(buttonService.getCryptoToFiatConverterMenuSelectUsd(bundle))
                    .build();

        }
        return SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(bundle.getString("ConvertCryptocurrencyToCurrencyInvalidInputHeader")+
                        bundle.getString("ConvertCryptocurrencyToCurrencyInvalidInputBody"))
                .build();
    }

    public SendMessage getFiatToCryptoConverterMenu(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.CRYPT_TO_FIAT_CONVERTATOR_MENU);

        return SendMessage.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .text(bundle.getString("FiatToCryptoHeader") +
                        bundle.getString("FiatToCryptoBody"))
                .replyMarkup(buttonService.getFiatToCryptoConverterMenu(bundle))
                .build();
    }

    public EditMessageReplyMarkup getFiatToCryptoSelectUsd(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.FIAT_TO_CRYPTO_SELECT_USD);

        return EditMessageReplyMarkup.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .messageId(callback.getMessage().getMessageId())
                .replyMarkup(buttonService.getFiatToCryptoConverterMenuSelectUsd(bundle))
                .build();
    }

    public EditMessageReplyMarkup getFiatToCryptoSelectRub(CallbackQuery callback) {
        var userTelegramId = callback.getFrom().getId();
        var user = userService.getUserByTelegramId(userTelegramId);
        var bundle = user.getResourceBundle();

        userService.updateUserStateByTelegramId(userTelegramId, State.FIAT_TO_CRYPTO_SELECT_RUB);

        return EditMessageReplyMarkup.builder()
                .chatId(callback.getMessage().getChatId().toString())
                .messageId(callback.getMessage().getMessageId())
                .replyMarkup(buttonService.getFiatToCryptoConverterMenuSelectRub(bundle))
                .build();
    }

}
