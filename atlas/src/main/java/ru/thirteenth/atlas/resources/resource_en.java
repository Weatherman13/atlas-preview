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
                    {"Top15Header", "\uD83D\uDCCA TOP 15 MARKET CAP"},
                    {"Top15Tail", "NOTE: USDT, USDC, UST are not included in the top."},
                    {"WelcomeBodyP1", "Welcome! " + "Nice to see you, "},
                    {"WelcomeBodyP2", "!" + "\n" +
                            "Select a language, please:"},
                    {"СryptoCurrencyMenuHeader", "₿ Сryptocurrency ₿"},
                    {"CoinInfoButton", "Information about cryptocurrency ❓"},
                    {"CoinInfoMenuHeader", "❓ Information about cryptocurrency ❓" + "\n\n"},
                    {"CoinInfoMenuBody", "Choose in which format you want to search:\n" +
                            "- by name (Bitcoin)\n" +
                            "- by suffix (BTC)"},
                    {"namePatternCoinInfoButton", "Name"},
                    {"suffixPatternCoinInfoButton", "Suffix"},
                    {"GetNamePatternCoinInfo", "Enter the name of the cryptocurrency you are interested in," +
                            "please\n\n"+ "For example: 'Bitcoin' or 'bitcoin' "},
                    {"GetSuffixPatternCoinInfo", "Enter the suffix of the cryptocurrency you are interested in," +
                            "please\n\n" + "For example: 'BTC' or 'btc'"},
                    {"InvalidCryptocurrencyInfoSuffixPatternBody", "Incorrect input type of suffix " +
                            "or this cryptocurrency is missing." +
                            " Try again, as in the example.\n\n" + "Example: 'BTC' or 'btc'"},
                    {"InvalidCryptocurrencyInfoNamePatternBody", "Incorrect input type of name " +
                            "or this cryptocurrency is missing." +
                            " Try again, as in the example.\n\n"+"Example: 'Bitcoin' or 'bitcoin' "},
                    {"InvalidCryptocurrencyInfoSuffixPatternHeader", "❌ Invalid suffix ❌\n\n"},
                    {"InvalidCryptocurrencyInfoNamePatternHeader", "❌ Invalid name ❌\n\n"},
                    {"CurrencyModelName", "Name"},
                    {"CurrencyModelSymbol", "Suffix"},
                    {"CurrencyModelRate", "Rate(USDT)"},
                    {"CurrencyModelRatePercent", "Percent of volatility(24h)"},
                    {"CurrencyModelTrend", "Trend"},
                    {"CurrencyModelMarketCap", "Market cap"},
                    {"CurrencyModelHigh", "High"},
                    {"CurrencyModelLow", "Low"},
                    {"CoinConverterButton", "Currency сonverter \uD83D\uDD03"},
                    {"СryptocurrencyConverterMenuHeader", "Currency сonverter \uD83D\uDD03\n\n"},
                    {"СryptocurrencyConverterMenuBody", "Choose from what to what you want to convert.\n" +
                            "For example, from fiat to cryptocurrency or vice versa."},
                    {"ToFiatButton", "₿  --->  \uD83D\uDCB2"},
                    {"ToCryptoButton", "\uD83D\uDCB2  --->  ₿ "},
                    {"CryptoToFiatHeader", "₿  --->  \uD83D\uDCB2 \n\n\n"},
                    {"CryptoToFiatBody", "Enter the suffix of the cryptocurrency you want " +
                            "to convert and its amount, as in the example below.\n\n" +
                            "Example: 'BTC, 1' or 'btc, 0.5'"},
                    {"ConvertCryptocurrencyToCurrencyInvalidInputHeader", "❌ Incorrect input ❌\n\n" },
                    {"ConvertCryptocurrencyToCurrencyInvalidInputBody", "Either the cryptocurrency you " +
                            "entered is not supported, or you used the wrong template when" +
                            " entering data. Please check out the input template below.\n\n" +
                            "Template: 'BTC, 1' or 'btc, 0.5'"},
                    {"ConvertCryptocurrencyToCurrencyCorrectInputHeader", "✔️ Conversion has been completed ✔️\n\n"},
                    {"ConvertCryptocurrencyToCurrencyCorrectInputBody", "At the current rate: "},
                    {"FiatToCryptoHeader", "\uD83D\uDCB2  --->  ₿ \n\n\n"},
                    {"FiatToCryptoBody", "Enter the suffix of the cryptocurrency you want to convert your currency" +
                            " into and the amount of currency.\n\n" + "Example: 'BTC, 10000' or 'btc, 8999.35'"},


            };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
