package ru.thirteenth.atlas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.thirteenth.atlas.dto.CurrencyDTO;

import java.util.ResourceBundle;


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


    public String toStringInfo(ResourceBundle bundle) {
        return  this.getName().toUpperCase() + " \uD83E\uDE99" + "\n\n" +
                bundle.getString("CurrencyModelSymbol") + ": " + this.getSymbol().toUpperCase() + "\n" +
                bundle.getString("CurrencyModelTrend") + ": " + this.trendToString() + "\n" +
                bundle.getString("CurrencyModelRate") + ":  " + this.getRate() + " \uD83D\uDCB2" + "\n\n" +

                bundle.getString("CurrencyModelHigh") + ":  " + this.getHigh() + " \uD83D\uDCB2" + "\n" +
                bundle.getString("CurrencyModelLow") + ":  " + this.getLow() + " \uD83D\uDCB2" + "\n" +
                bundle.getString("CurrencyModelRatePercent") + ":  " + this.getRatePercent() + " %" + "\n\n" +

                bundle.getString("CurrencyModelMarketCap") + ":  " + this.getMarketCupS() + " \uD83D\uDCB2" + "\n" ;

    }

    public String trendToString() {
        if (this.getTrend().equals("up")) return "\uD83D\uDCC8";
        return "\uD83D\uDCC9";
    }


}