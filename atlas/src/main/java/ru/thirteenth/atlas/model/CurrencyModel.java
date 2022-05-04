package ru.thirteenth.atlas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyModel {
    private int id;
    private String symbol;
    private String name;
    private PairModel pairModel;
    private double rate;
    private double volA;
    private double volB;
    private String currA;
    private String currB;
    private double ratePercent;
    private String trend;
    private double supply;
    private long marketCup;
    private String marketCupS;
    private int lq;
    private int pRate;
    private double high;
    private double low;


    public CurrencyModel(String symbol) {
        this.symbol = symbol;
    }


    public String trendToString (CurrencyModel cur){
        if (cur.getTrend().equals("up")) return "\uD83D\uDCC8";
             return "\uD83D\uDCC9";
    }




}