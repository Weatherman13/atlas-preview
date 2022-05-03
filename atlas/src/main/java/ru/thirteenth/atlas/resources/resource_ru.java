package ru.thirteenth.atlas.resources;

import java.util.ListResourceBundle;

public class resource_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"Profile" , "\uD83D\uDE4D\u200D♂️Профиль"},
                    {"Options" , "⚙️Дополнительно"},
                    {"Market" , "\uD83C\uDFDBРынок"},
                    {"Nav_Сryptocurrency" , "₿ Криптовалюта"},
                    {"BotInformation" , "\uD83D\uDDD2Информация"}
            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
