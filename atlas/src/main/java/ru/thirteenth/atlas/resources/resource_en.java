package ru.thirteenth.atlas.resources;

import java.util.ListResourceBundle;

public class resource_en extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"Profile", "\uD83D\uDE4D\u200D♂️Profile"},
                    {"Options", "⚙️Settings"},
                    {"Market", "\uD83C\uDFDBMarket"},
                    {"Nav_Сryptocurrency", "₿ Сryptocurrency"},
                    {"BotInformation", "\uD83D\uDDD2Information"},
                    {"BotInformationBody", "❓ INFORMATION ❓" + "\n\n" + "This bot provides information " +
                            " about the current state of the cryptocurrency market, allows you to find out the current state" +
                             "of various crypto assets, and allows you to convert cryptocurrency to fiat and back." +
                             "\n \n" + "The bot is not intended for commercial use."},
                    {"OptionMenuHeader", "⚙️ Settings ⚙️"},
                    {"ChangeLanguageButton", "Change the language"},
                    {"ChooseLanguage", "\uD83C\uDF0D Choose language, please \uD83C\uDF0D"},
                    {"RuLanguageButton", "RU \uD83C\uDDF7\uD83C\uDDFA"},
                    {"EnLanguageButton", "EN \uD83C\uDDEC\uD83C\uDDE7"},
                    {"BackButton", "Back \uD83D\uDD19"},
                    {"CountryChoose", "You have chosen English \uD83C\uDDEC\uD83C\uDDE7"},
                    {"MarketMenuHeader", "\uD83C\uDFDB Market \uD83C\uDFDB"},
                    {"FaQButton", "Fear and Greed Index \uD83D\uDD70"},
                    {"Top15Cap", "Top 15 by capitalization \uD83D\uDE80"},
                    {"FaQBodyP1", "⚠️CURRENT STATE OF THE MARKET⚠️" + "\n" + "\n"
                            + "\uD83D\uDD70  Fear and Greed Index: "},
                    {"FaQBodyP2", "\n" + "\uD83E\uDD28  Classification: "},
                    {"Top15Header", "⚠️TOP 15 MARKET CAP⚠️"},
                    {"Top15Tail", "NOTE: USDT, USDC, UST are not included in the top."}
            };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
