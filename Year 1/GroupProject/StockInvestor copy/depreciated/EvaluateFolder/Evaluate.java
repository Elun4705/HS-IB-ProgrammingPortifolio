
import java.util.ArrayList;
//Simranpreet Saini
public class Evaluate {
	//Set %K and %D with the appropriate values using a getK method or something
	final int upperBound = 80;
	final int lowerBound = 20;
	int counterToBuy;
	int counterToSell;
	/*
	 * Creates a comparable stock object
	 * @param name and @param int
	 * 
	 * The percentK and percentD values here are for testing purposes only!
	 */
	ComparableStock aaplbuy = new ComparableStock("AAPL",counterToBuy, 10, 80, 14.96, 86, 1100.00);
	ComparableStock msftbuy = new ComparableStock("MSFT",counterToBuy, 5, 2, 67.93, 187, 69.32);
	ComparableStock googbuy = new ComparableStock("GOOG",counterToBuy, 70, 90, 2.45, 549, 6.93);
	ComparableStock aaplsell = new ComparableStock("AAPL",counterToSell, 10, 80, 14.96, 86, 1100.00);
	ComparableStock msftsell = new ComparableStock("MSFT",counterToSell, 5, 2, 67.93, 187, 69.32);
	ComparableStock googsell = new ComparableStock("GOOG",counterToSell, 70, 90, 2.45, 549, 6.93);
	
	//The arraylist that will store all the stocks that are suggested to buy and sell
	ArrayList<Object> initialListToBuy = new ArrayList<Object>();
	initialListToBuy.add(applbuy);
	initialListToBuy.add(msftbuy);
	initialListToBuy.add(googbuy);
	ArrayList<Object> initialListToSell = new ArrayList<Object>();
	initialListToSell.add(applsell);
	initialListToSell.add(msftsell);
	initialListToSell.add(googsell);
	ArrayList<Object> finalListToBuy = new ArrayList<Object>();
	ArrayList<Object> finalListToSell = new ArrayList<Object>();
	/*
	 * A method that suggests when to buy stocks
	 * when it takes in all essential conditions into consideration.
	 * As a stock passes an if statement, the counterToBuy is incremented
	 * by one. At the end of the method the object is put into an ArrayList
	 * which either sorts or goes through each index and returns the stocks 
	 * that passed the most conditions (indicated by the counterToBuy)
	 * logic researched from:
	 * //https://www.youtube.com/watch?v=vjQ9pS_ILvk and other
	 * websites from which I learned what %K and %D is.
	 */
	for(int i = 0; i<initialListToBuy.size - 1; i++){
		ComparableStock stock = (ComparableStock) initialListToBuy.get(i);
		if(stock.getPercentK() > stock.getPercentD() && stock.getPercentK() < lowerBound && stock.getPercentD() < lowerBound){
			counterToBuy++;
		}
		if(stock.getPricePerShareAtBuy() >15){
			counterToBuy++;
		}
		finalListToSell.add(stock);
	}
		
	/*
	 * A method that suggests when to sell stocks
	 * @ param k and @ param d
	 * logic researched from:
	 * //https://www.youtube.com/watch?v=vjQ9pS_ILvk and other
	 * websites from which I learned what %K and %D is.
	 */
	for(int s = 0; s<initialListToSell.size - 1; s++){
		ComparableStock stock = (ComparableStock) initialListToSell.get(i);
		if(stock.getPercentK() < stock.getPercentD() && stock.getPercentK() > upperBound && stock.getPercentD() > upperBound){
			counterToSell++;
		}
		if(stock.getCurrentPricePerShare() <= stock.getPricePerShareAtBuy()-stock.getPricePerShareAtBuy()*.08){
			System.out.println("Sell the stock: " + stock.getName());
		}
		finalListToSell.add(stock);
	}
	
	public void decideToBuy(){
		ComparableStock stock1 = (ComparableStock) finalListToBuy.get(0);
		ComparableStock stock2 = (ComparableStock) finalListToBuy.get(1);
		ComparableStock stock3 = (ComparableStock) finalListToBuy.get(2);
		if(stock1.getRank() > stock2.getRank() && stock1.getRank() > stock3.getRank()){
			System.out.println("Buy Stock: " + stock1.getName());
		}
		if(stock2.getRank() > stock1.getRank() && stock2.getRank() > stock3.getRank()){
			System.out.println("Buy Stock: " + stock2.getName());
		}
		if(stock3.getRank() > stock1.getRank() && stock3.getRank() > stock2.getRank()){
			System.out.println("Buy Stock: " + stock3.getName());
		}
	}
	
	public void decideToSell(){
		ComparableStock stock1 = (ComparableStock) finalListToSell.get(0);
		ComparableStock stock2 = (ComparableStock) finalListToSell.get(1);
		ComparableStock stock3 = (ComparableStock) finalListToSell.get(2);
		if(stock1.getRank() > stock2.getRank() && stock1.getRank() > stock3.getRank()){
			System.out.println("Sell Stock: " + stock1.getName());
		}
		if(stock2.getRank() > stock1.getRank() && stock2.getRank() > stock3.getRank()){
			System.out.println("Sell Stock: " + stock2.getName());
		}
		if(stock3.getRank() > stock1.getRank() && stock3.getRank() > stock2.getRank()){
			System.out.println("Sell Stock: " + stock3.getName());
		}
	}
}
