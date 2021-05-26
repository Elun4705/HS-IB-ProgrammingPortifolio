/**
 * Created by 9485974 on 5/13/2016.
 */

public class Stocks {

private String symbol;
private double priceBoughtAt,currentMarketPrice;

    public Stocks(String symbol, double priceBoughtAt, double currentMarketPrice){
        this.symbol = symbol;
        this.priceBoughtAt = priceBoughtAt;
        this.currentMarketPrice = currentMarketPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPriceBoughtAt() {
        return priceBoughtAt;
    }

    public void setPriceBoughtAt(double priceBoughtAt) {
        this.priceBoughtAt = priceBoughtAt;
    }

    public double getCurrentMarketPrice() {
        return currentMarketPrice;
    }

    public void setCurrentMarketPrice(double currentMarketPrice) {
        this.currentMarketPrice = currentMarketPrice;
    }
}
