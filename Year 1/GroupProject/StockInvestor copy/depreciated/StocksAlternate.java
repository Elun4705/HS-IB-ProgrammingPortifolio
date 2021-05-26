import java.text.DecimalFormat;
import java.util.Array;

public class Stock {

private String symbol;
private int totalShares;
private double totalCost;
private double currentPrice;
private double totalProfitOrLoss;
private Array[] history;

    public Stock(String theSymbol) {
        Symbol = theSymbol;
        TotalShares = 0;
        CurrentPrice = 0.00;
        TotalCost = 0.00;
        TotalProfitOrLoss = 0.00;
    }

    public int getTotalShares () {
      	return TotalShares;
    }

    public double getTotalCost () {
      	return TotalCost;
    }

    public double getTotalProfitOrLoss () {
      	return TotalProfitOrLoss;
    }

    public double checkMarket() {
      	double CurrentPrice = 0.00;
      	CurrentPrice = TotalShares * CurrentPrice;
        return CurrentPrice - TotalCost;
    }

    public void buy (int shares, double pricePerShare) {
      	TotalShares += shares;
        TotalCost += shares * pricePerShare;
    }

    public double sell (int shares, double pricePerShare) {
        TotalProfitOrLoss += (TotalShares)*(TotalCost - pricePerShare);
        return TotalProfitOrLoss;
    }

    public String toString() {
        return "Stock Symbol" + Symbol + "\nTotal Shares" + TotalShares + "\nTotal cost for the" + TotalShares + "owned:" + TotalCost + "\nAccumulated profit or loss: " + CurrentPrice;
    }
}
