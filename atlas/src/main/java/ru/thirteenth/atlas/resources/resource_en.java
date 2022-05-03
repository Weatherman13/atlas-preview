package ru.thirteenth.atlas.resources;

import java.util.ListResourceBundle;

public class resource_en extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"Profile" , "\uD83D\uDE4D\u200D♂️Profile"},
                    {"Options" , "⚙️Options"},
                    {"Market" , "\uD83C\uDFDBMarket"},
                    {"Nav_Сryptocurrency" , "₿ Сryptocurrency"},
                    {"BotInformation" , "\uD83D\uDDD2BotInformation"}
            };
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
