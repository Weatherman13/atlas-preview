package ru.thirteenth.atlas.resources;

import java.util.ListResourceBundle;

public class resource extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"hello", "привет"},
                    {"world", "мир"}
            };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}

