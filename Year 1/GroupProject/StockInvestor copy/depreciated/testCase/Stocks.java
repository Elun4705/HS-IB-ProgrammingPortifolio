import java.math.BigDecimal;

/**
 * Created by 9485974 on 5/13/2016.
 */

public class Stocks {
    private String symbol;
    private BigDecimal priceBoughtAt,currentMarketPrice;

    public Stocks(String symbol, BigDecimal priceBoughtAt, BigDecimal currentMarketPrice){
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

    public BigDecimal getPriceBoughtAt() {
        return priceBoughtAt;
    }

    public void setPriceBoughtAt(BigDecimal priceBoughtAt) {
        this.priceBoughtAt = priceBoughtAt;
    }

    public BigDecimal getCurrentMarketPrice() {
        return currentMarketPrice;
    }

    public void setCurrentMarketPrice(BigDecimal currentMarketPrice) {
        this.currentMarketPrice = currentMarketPrice;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "symbol='" + symbol + '\'' +
                ", priceBoughtAt=" + priceBoughtAt +
                ", currentMarketPrice=" + currentMarketPrice +
                '}';
    }
}