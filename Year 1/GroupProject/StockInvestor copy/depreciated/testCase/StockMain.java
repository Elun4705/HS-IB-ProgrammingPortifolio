import java.io.IOException;
import java.util.ArrayList;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockMain{
	public static void main(String[] args)throws IOException

	{
		FileReader loadStock = new FileReader("C:\\Users\\9485974\\Desktop\\StockApp\\src\\test.txt");
		String[] stockSymbols = loadStock.readData();
		ArrayList<Stocks> StocksList = new ArrayList<>();

		for(String s : stockSymbols){
			StocksList.add(new Stocks(s, YahooFinance.get(s).getQuote().getPrice(), YahooFinance.get(s).getQuote().getPrice()));
			System.out.println(s + YahooFinance.get(s).getQuote().getPrice());
		}

		Lookup updater = new Lookup(StocksList, 0, 1, 0, 1);
		updater.periodicCheck();



	}
}