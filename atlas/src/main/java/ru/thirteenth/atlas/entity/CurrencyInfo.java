package ru.thirteenth.atlas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.thirteenth.atlas.dto.Currency;
import ru.thirteenth.atlas.dto.Pair;

import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInfo {
    private int id;
    private String symbol;
    private String name;
    private Pair pair;
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


    public CurrencyInfo(String symbol) {
        this.symbol = symbol;
    }

    public static CurrencyInfo currencyHandler(Currency currency) {

        int id = currency.getId();
        String symbol = currency.getSymbol();
        String name = currency.getName();
        Pair pair = new Pair(currency.getCurrA(), currency.getCurrB());
        double rate = Double.parseDouble(currency.getRate());
        double volA = Double.parseDouble(currency.getVolA().replace(",", ""));
        double volB = Double.parseDouble(currency.getVolB().replace(",", ""));
        String currA = currency.getCurrA();
        String currB = currency.getCurrB();
        double ratePercent = Double.parseDouble(currency.getRatePercent());
        String trend = currency.getTrend();
        double supply = Double.parseDouble(currency.getSupply().replace(",", ""));
        long marketCup = Long.parseLong(currency.getMarketCap().replace(",", ""));
        String marketCupS = currency.getMarketCap();
        int lq = Integer.parseInt(currency.getLq());
        int pRate = currency.getPRate();
        double high = Double.parseDouble(currency.getHigh());
        double low = Double.parseDouble(currency.getLow());

        return new CurrencyInfo(id, symbol, name, pair, rate, volA, volB, currA, currB, ratePercent, trend,
                supply, marketCup,marketCupS , lq, pRate, high, low);
    }

    public String trendToString (CurrencyInfo cur){
        if (cur.getTrend().equals("up")) return "\uD83D\uDCC8";
             return "\uD83D\uDCC9";
    }

}