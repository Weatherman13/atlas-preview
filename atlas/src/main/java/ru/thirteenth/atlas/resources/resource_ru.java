package ru.thirteenth.atlas.resources;

import java.util.ListResourceBundle;

public class resource_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"Profile" , "\uD83D\uDE4D\u200D♂️Профиль"},
                    {"Options" , "⚙️Дополнительно"},
                    {"Market" , "\uD83C\uDFDBРынок"},
                    {"Nav_Сryptocurrency" , "₿ Криптовалюта"},
                    {"BotInformation" , "\uD83D\uDDD2Информация"},
                    {"BotInformationBody", "❓ ИНФОРМАЦИЯ ❓" + "\n \n" + "Что умеет бот?\n\n" +
                            " Предоставляет информацию о рынке криптовалют:\n" +
                            " - топ 15 крупнейших криптовалют по капитализации\n" +
                            " - индекс страха и жадности\n\n" +
                            " Предоставляет информацию о более чем 300 криптовалютах:\n" +
                            " - показывает актуальную информацию о состоянии выбранной криптовалюты (high,low,курс и т.д.)\n\n" +
                            " Позволяет конвертировать любую из поддерживаемых криптовалют в рубли или доллары и наоборот."},
                    {"OptionMenuHeader", "⚙️ НАСТРОЙКИ ⚙️"},
                    {"ChangeLanguageButton", "Изменить язык"},
                    {"ChooseLanguage", "\uD83C\uDF0D Пожалуйста, выберите язык \uD83C\uDF0D"},
                    {"RuLanguageButton", "Россия \uD83C\uDDF7\uD83C\uDDFA"},
                    {"EnLanguageButton", "Англия \uD83C\uDDEC\uD83C\uDDE7"},
                    {"BackButton", "Назад \uD83D\uDD19"},
                    {"CountryChoose", "Вы выбрали Русский \uD83C\uDDF7\uD83C\uDDFA"},
                    {"MarketMenuHeader", "\uD83C\uDFDB Рынок \uD83C\uDFDB"},
                    {"FaQButton", "Индекс страха и жадности \uD83D\uDD70"},
                    {"Top15Cap", "Топ 15 по капитализации \uD83D\uDE80"},
                    {"FaQBodyP1", "⚠️Текущее состояние рынка⚠️" + "\n" + "\n"
                            + "\uD83D\uDD70  Индекс страха и жадности: "},
                    {"FaQBodyP2", "\n" + "\uD83E\uDD28  Состояние: "},
                    {"Top15Header", "\uD83D\uDCCA Топ 15 криптоактивов по капитализации"},
                    {"Top15Tail", "ВНИМАНИЕ: USDT, USDC, UST не включены в топ."},
                    {"WelcomeBodyP1",
                            "Добро пожаловать! " + "Рад тебя видеть, "},
                    {"WelcomeBodyP2", "!" + "\n" +
                            "Выбери язык, пожалуйста:"},
                    {"СryptoCurrencyMenuHeader", "₿ Криптовалюта ₿"},
                    {"CoinInfoButton", "Информацию о криптоактиве ❓"},
                    {"CoinInfoMenuHeader", "❓ Информация о криптоактиве ❓" + "\n\n"},
                    {"CoinInfoMenuBody", "Пожалуйста, выберите в каком формате хотите произвести поиск:\n" +
                            "- по имени (Bitcoin)\n" +
                            "- по суффиксу (BTC)"},
                    {"namePatternCoinInfoButton", "Название"},
                    {"suffixPatternCoinInfoButton", "Суффикс"},
                    {"GetNamePatternCoinInfo", "Пожалуйста, введите название интересующего вас криптоактива \n\n"+
                            "Например: 'Bitcoin' или 'bitcoin' "},
                    {"GetSuffixPatternCoinInfo", "Пожалуйста, введите суффикс интересующего вас криптоактива" +
                            "please\n\n" + "Например: 'BTC' или 'btc'"},
                    {"InvalidCryptocurrencyInfoSuffixPatternBody", "Недопустимый тип ввода суффикса или такая криптовалюта отсутствует. " +
                            "Попробуй ещё раз, как в примере.\n\n" + "Пример: 'BTC' или 'btc'"},
                    {"InvalidCryptocurrencyInfoNamePatternBody", "Недопустимый тип ввода имени или такая криптовалюта отсутствует. " +
                            "Попробуйте ещё раз, как в примере.\n\n" + "Пример: 'Bitcoin' или 'bitcoin'"},
                    {"InvalidCryptocurrencyInfoSuffixPatternHeader", "❌ Неверный суффикс ❌\n\n"},
                    {"InvalidCryptocurrencyInfoNamePatternHeader", "❌ Неверное имя ❌\n\n"},
                    {"CurrencyModelName", "Название"},
                    {"CurrencyModelSymbol", "Суффикс"},
                    {"CurrencyModelRate", "Курс(USDT)"},
                    {"CurrencyModelRatePercent", "Процент волатильности(24ч)"},
                    {"CurrencyModelTrend", "Тренд"},
                    {"CurrencyModelMarketCap", "Капитализация"},
                    {"CurrencyModelHigh", "Высшая точка"},
                    {"CurrencyModelLow", "Низшая точка"},
                    {"CoinConverterButton", "Конвертация валют \uD83D\uDD03"},
                    {"СryptocurrencyConverterMenuHeader", "Конвертатор валют \uD83D\uDD03\n\n"},
                    {"СryptocurrencyConverterMenuBody", "Выберите из чего во что вы хотите произвести конвертацию.\n" +
                            "Например из фиата в криптовалюту, или наоборот."},
                    {"ToFiatButton", " ₿  --->  \uD83D\uDCB2"},
                    {"ToCryptoButton", "\uD83D\uDCB2  --->  ₿ "},
                    {"CryptoToFiatHeader", "₿  --->  \uD83D\uDCB2 \n\n\n"},
                    {"CryptoToFiatBody", "Введите суффикс нужной вам криптовалюты " +
                            "для конвертации и ее количества, как в примере ниже\n\n" +
                            "Пример: 'BTC, 1' или 'btc, 0.5'"},
                    {"ConvertCryptocurrencyToCurrencyInvalidInputHeader", "❌ Неверный ввод ❌\n\n" },
                    {"ConvertCryptocurrencyToCurrencyInvalidInputBody", "Либо введённая вами криптовалюта не " +
                            "поддерживается, либо вы использовали неправильный шаблон при вводе данных. " +
                            "Пожалуйста ознакомьтесь с шаблоном ввода ниже.\n\n" + "Шаблон: 'BTC, 1' или 'btc, 0.5'"},
                    {"ConvertCryptocurrencyToCurrencyCorrectInputHeader", "✔️ Конвертация выполнена успешно ✔️\n\n"},
                    {"ConvertCryptocurrencyToCurrencyCorrectInputBody", "По текущему курсу: "},
                    {"FiatToCryptoHeader", "\uD83D\uDCB2  --->  ₿ \n\n\n"},
                    {"FiatToCryptoBody", "Введите суффикс криптовалюты в которую хотите сконвертировать " +
                            "вашу валюту и количество валюты.\n\n" + "Пример: 'BTC, 10000' или 'btc, 12000.8'"},
                    {"Works...", "⚙ Данный раздел находится в разработке и станет доступен в будущем"}



            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
