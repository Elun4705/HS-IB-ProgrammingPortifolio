//Simranpreet Saini
//Thomas Campana
public class ComparableStock{
	String name;
	int rank;
	double percentK;
    double percentD;
    double pricePerShareAtBuy;
    int numberOfShares;
    double currentPricePerShare;
        
	public ComparableStock(String n, int r, int k, double d, double p, int num, double cp){
		name = n;
		rank = r;
		percentK = k;
        percentD = d;
        pricePerShareAtBuy = p;
        numberOfShares = num;
        currentPricePerShare = cp;
	}
	public int getRank(){
		return rank;
	}
	public String getName(){
		return name;
	}
	 public double getPercentK(){
        return percentK;
    }
     public double getPercentD(){
        return percentD;
    }
	public double getPricePerShareAtBuy(){
		return pricePerShareAtBuy;
	}
	public int getNumberOfShares(){
		return numberOfShares;
	}
	public double getCurrentPricePerShare(){
		return currentPricePerShare;
	}
}
