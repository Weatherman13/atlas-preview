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
                    {"BotInformationBody", "❓ ИНФОРМАЦИЯ ❓" + "\n \n" + "Данный бот предоставляет информацию " +
                            "о текущем состоянии рынка криптовалют, позволяет узнать текущее состояние" +
                            " разнообразных криптоактивов, и позволяет конвертировать криптовалюту в фиат и обратно."
                            + "\n \n" + "Бот не предназначен для коммерческого использования."},
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
                    {"Top15Header", "⚠️Топ 15 криптоактивов по капитализации⚠️"},
                    {"Top15Tail", "ВНИМАНИЕ: USDT, USDC, UST не включены в топ."}
            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
