package ru.thirteenth.atlas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.UnsupportedEncodingException;
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

    public InlineKeyboardMarkup getСryptoCurrencyMenu() {
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
                        .text("Crypto Сonverter")
                        .callbackData("GetCryptoСonverter")
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

    public InlineKeyboardMarkup getCoinInfoMenu() {
        List<InlineKeyboardButton> backButtons = new ArrayList<>();
        List<List<InlineKeyboardButton>> middleButtons = new ArrayList<>();

        var availableCoinButton =
                InlineKeyboardButton
                        .builder()
                        .text("Available сryptocurrencies")
                        .callbackData("GetAvailableCryptocurrencies")
                        .build();


        var backButton =
                InlineKeyboardButton
                        .builder()
                        .text("Back")
                        .callbackData("GetCryptocurrencies")
                        .build();

        backButtons.add(backButton);
        middleButtons.add(Arrays.asList(availableCoinButton));

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
                .text(bundle.getString("Nav_Сryptocurrency"))
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
}
