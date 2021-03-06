package ru.thirteenth.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.*;

@Service
public class ButtonFactoryService {
    private final UserServiceImpl userService;

    @Autowired
    public ButtonFactoryService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public InlineKeyboardMarkup getMainMenu() {
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();
        List<InlineKeyboardButton> infoButtons = new ArrayList<>();

        var infoButton =
                InlineKeyboardButton
                        .builder()
                        .text("Info")
                        .callbackData("GetInfo")
                        .build();


        var marketInfoButton =
                InlineKeyboardButton
                        .builder()
                        .text("Market condition")
                        .callbackData("GetMarketCondition")
                        .build();

        var cryptoCurrencyInfoButton =
                InlineKeyboardButton
                        .builder()
                        .text("Cryptocurrencies")
                        .callbackData("GetCryptocurrencies")
                        .build();


        middleButtons.add(Arrays.asList(marketInfoButton, cryptoCurrencyInfoButton));
        infoButtons.add(infoButton);


        return InlineKeyboardMarkup.builder().clearKeyboard().keyboard(middleButtons).keyboardRow(infoButtons).build();
    }


    public InlineKeyboardMarkup getBackToMainMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();

        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text("Back")
                        .callbackData("GetBackToMainPage")
                        .build();

        backButtons.add(backButton);

        return InlineKeyboardMarkup.builder().keyboardRow(backButtons).build();
    }

    public InlineKeyboardMarkup getBackToMarketConditionMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();

        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text("Back")
                        .callbackData("GetBackToMarketConditionMenu")
                        .build();

        backButtons.add(backButton);

        return InlineKeyboardMarkup.builder().keyboardRow(backButtons).build();
    }

    public InlineKeyboardMarkup getMarketConditionMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();

        var fagButton =
                InlineKeyboardButton
                        .builder()
                        .text("Fear and Greed Index")
                        .callbackData("GetFaG")
                        .build();

        var top15Button =
                InlineKeyboardButton
                        .builder()
                        .text("Top 15 cryptocurrencies by capitalization")
                        .callbackData("GetTop15")
                        .build();

        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text("Back")
                        .callbackData("GetBackToMainPage")
                        .build();

        backButtons.add(backButton);
        middleButtons.add(Arrays.asList(fagButton, top15Button));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).keyboardRow(backButtons).build();
    }

    public InlineKeyboardMarkup get??ryptoCurrencyMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();

        var coinInfoButton =
                InlineKeyboardButton
                        .builder()
                        .text("Coin info")
                        .callbackData("GetCoinInfo")
                        .build();

        var converterButton =
                InlineKeyboardButton
                        .builder()
                        .text("Crypto ??onverter")
                        .callbackData("GetCrypto??onverter")
                        .build();

        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text("Back")
                        .callbackData("GetBackToMainPage")
                        .build();

        backButtons.add(backButton);
        middleButtons.add(Arrays.asList(coinInfoButton, converterButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).keyboardRow(backButtons).build();
    }

    public InlineKeyboardMarkup getCoinInfoMenu(ResourceBundle bundle) {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();

        var nameCoinButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("namePatternCoinInfoButton"))
                        .callbackData("GetNamePatternCoinInfo")
                        .build();

        var suffixCoinButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("suffixPatternCoinInfoButton"))
                        .callbackData("GetSuffixPatternCoinInfo")
                        .build();


        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCryptocurrenciesMenu")
                        .build();

        backButtons.add(backButton);
        middleButtons.add(Arrays.asList(nameCoinButton,suffixCoinButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).keyboardRow(backButtons).build();
    }

    //
    public ReplyKeyboardMarkup getNavigationMenu(ResourceBundle bundle) {


        var but1 = KeyboardButton
                .builder()
                .text(bundle.getString("Profile"))
                .build();

        var but2 = KeyboardButton
                .builder()
                .text(bundle.getString("Options"))
                .build();
        var but3 = KeyboardButton
                .builder()
                .text(bundle.getString("Market"))
                .build();
        var but4 = KeyboardButton
                .builder()
                .text(bundle.getString("Nav_??ryptocurrency"))
                .build();
        var but5 = KeyboardButton
                .builder()
                .text(bundle.getString("BotInformation"))
                .build();

        var buttons1 = new KeyboardRow(2);
        var buttons2 = new KeyboardRow(2);
        var buttons3 = new KeyboardRow(1);


        buttons1.add(but1);
        buttons1.add(but2);
        buttons2.add(but3);
        buttons2.add(but4);
        buttons3.add(but5);


        return ReplyKeyboardMarkup
                .builder()
                .keyboard(Collections.singleton(buttons2))
                .keyboard(Collections.singleton(buttons1))
                .keyboardRow(buttons3)
                .resizeKeyboard(true)
                .build();
    }

    public InlineKeyboardMarkup getOptionMenu (ResourceBundle bundle){
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();

        var changeLanguageButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("ChangeLanguageButton"))
                        .callbackData("GetLanguageOption")
                        .build();


        middleButtons.add(Arrays.asList(changeLanguageButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).build();
    }
    public InlineKeyboardMarkup getOptionLanguageMenu(ResourceBundle bundle){
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();
        List<InlineKeyboardButton> backButtons = new ArrayList<>();


        var ruButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("RuLanguageButton"))
                        .callbackData("SetRuLanguage")
                        .build();
        var enButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("EnLanguageButton"))
                        .callbackData("SetEnLanguage")
                        .build();
        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetOptionMenu")
                        .build();


        middleButtons.add(Arrays.asList(enButton,ruButton));
        backButtons.add(backButton);

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).keyboardRow(backButtons).build();
    }

    public InlineKeyboardMarkup getStartOptionLanguageMenu(ResourceBundle bundle){
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();



        var ruButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("RuLanguageButton"))
                        .callbackData("SetRuLanguage")
                        .build();
        var enButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("EnLanguageButton"))
                        .callbackData("SetEnLanguage")
                        .build();


        middleButtons.add(Arrays.asList(enButton,ruButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).build();
    }



    public InlineKeyboardMarkup getMarketMenu(ResourceBundle bundle){

        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();


        var fagButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("FaQButton"))
                        .callbackData("GetFaQ")
                        .build();

        var top15Button =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("Top15Cap"))
                        .callbackData("GetTop15Cap")
                        .build();


        middleButtons.add(Arrays.asList(top15Button,fagButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).build();
    }

    public InlineKeyboardMarkup get??rypto??urrencyMenu(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();


        var coinInfoButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("CoinInfoButton"))
                        .callbackData("GetCoinInfo")
                        .build();

        var coinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("CoinConverterButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(coinInfoButton);
        middleButtons2.add(coinConverterButton);

        return InlineKeyboardMarkup.builder().keyboardRow(middleButtons1).keyboardRow(middleButtons2).build();
    }
    public InlineKeyboardMarkup getBackToCoinInfoMenu(ResourceBundle bundle){

        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();


        var backToCoinInfoButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinInfo")
                        .build();




        middleButtons.add(Arrays.asList(backToCoinInfoButton));

        return InlineKeyboardMarkup.builder().keyboard(middleButtons).build();
    }

    public InlineKeyboardMarkup get??ryptocurrencyConvertatorMenu(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toFiatButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("ToFiatButton"))
                        .callbackData("GetCryptoToFiat")
                        .build();

        var toCryptocurrencyButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("ToCryptoButton"))
                        .callbackData("GetFiatToCrypto")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCryptocurrenciesMenu")
                        .build();




        middleButtons1.add(toFiatButton);
        middleButtons2.add(toCryptocurrencyButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }
    public InlineKeyboardMarkup getCryptoToFiatConverterMenu(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toFiatButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB")
                        .callbackData("GetCryptoToRUB")
                        .build();

        var toCryptocurrencyButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD")
                        .callbackData("GetCryptoToUSD")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toFiatButton);
        middleButtons2.add(toCryptocurrencyButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }


    public InlineKeyboardMarkup getCryptoToFiatConverterMenuSelectUsd(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toFiatButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB")
                        .callbackData("GetCryptoToRUB")
                        .build();

        var toCryptocurrencyButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD ??????")
                        .callbackData("GetCryptoToUSD")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toFiatButton);
        middleButtons2.add(toCryptocurrencyButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }

    public InlineKeyboardMarkup getCryptoToFiatConverterMenuSelectRub(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toFiatButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB ??????")
                        .callbackData("GetCryptoToRUB")
                        .build();

        var toCryptocurrencyButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD")
                        .callbackData("GetCryptoToUSD")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toFiatButton);
        middleButtons2.add(toCryptocurrencyButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }

    public InlineKeyboardMarkup getFiatToCryptoConverterMenu(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toFiatButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB")
                        .callbackData("GetRUBToCrypto")
                        .build();

        var toCryptocurrencyButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD")
                        .callbackData("GetUSDToCrypto")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toFiatButton);
        middleButtons2.add(toCryptocurrencyButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }

    public InlineKeyboardMarkup getFiatToCryptoConverterMenuSelectUsd(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toRubButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB")
                        .callbackData("GetRUBToCrypto")
                        .build();

        var toUsdButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD ??????")
                        .callbackData("GetUSDToCrypto")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toRubButton);
        middleButtons2.add(toUsdButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }

    public InlineKeyboardMarkup getFiatToCryptoConverterMenuSelectRub(ResourceBundle bundle){

        List<InlineKeyboardButton> middleButtons1 = new ArrayList<>();
        List<InlineKeyboardButton> middleButtons2 = new ArrayList<>();
        List<InlineKeyboardButton> backButtons3 = new ArrayList<>();


        var toRubButton =
                InlineKeyboardButton
                        .builder()
                        .text("RUB ??????")
                        .callbackData("GetRUBToCrypto")
                        .build();

        var toUsdButton =
                InlineKeyboardButton
                        .builder()
                        .text("USD")
                        .callbackData("GetUSDToCrypto")
                        .build();

        var backCoinConverterButton =
                InlineKeyboardButton
                        .builder()
                        .text(bundle.getString("BackButton"))
                        .callbackData("GetCoinConverter")
                        .build();




        middleButtons1.add(toRubButton);
        middleButtons2.add(toUsdButton);
        backButtons3.add(backCoinConverterButton);

        return InlineKeyboardMarkup.builder()
                .keyboardRow(middleButtons1)
                .keyboardRow(middleButtons2)
                .keyboardRow(backButtons3)
                .build();
    }

}
