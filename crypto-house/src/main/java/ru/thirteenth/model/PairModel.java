package ru.thirteenth.model;

import lombok.Data;

import java.util.Locale;

@Data
public class PairModel {
    private String cur1;
    private String cur2;

    public PairModel(String cur1, String cur2) {
        this.cur1 = cur1.toLowerCase(Locale.ROOT);
        this.cur2 = cur2.toLowerCase(Locale.ROOT);
    }
}
