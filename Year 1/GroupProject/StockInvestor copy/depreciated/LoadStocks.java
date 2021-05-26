/*
* author Reggii peck
*/
import java.io.IOException;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class LoadStocks {

	public static void main(String[] args) throws IOException {

		Stock aapl = YahooFinance.get("AAPL");
		System.out.println(aapl.getName());
		System.out.println(aapl.getStats());
		System.out.println(aapl.getCurrency());
		System.out.println(aapl.getSymbol());
		System.out.println(aapl.getDividend());
		System.out.println(aapl.getHistory());
		System.out.println(aapl.getQuote());

		/* returns this
		 * 
		Apple Inc.
		EPS: 8.98, PE: 10.06, PEG: 1.21
		USD
		AAPL
		Pay date: Wed Feb 10 22:00:00 MST 2016, Ex date: Wed May 04 22:00:00 MDT 2016, Annual yield: 2.46%
		
		[AAPL@2016-05-01: 89.470001-95.900002, 93.970001->90.339996 (90.339996), AAPL@2016-03-31: 92.510002-112.389999, 108.779999->93.739998 (93.172722), AAPL@2016-02-29: 97.419998-110.419998, 97.650002->108.989998 (108.330437), AAPL@2016-01-31: 92.589996-98.889999, 96.470001->96.690002 (96.104874), AAPL@2016-01-03: 92.389999-105.849998, 102.610001->97.339996 (96.228775), AAPL@2015-11-30: 104.82-119.860001, 118.75->105.260002 (104.058365), AAPL@2015-11-01: 111.00-123.82, 120.800003->118.300003 (116.949501), AAPL@2015-09-30: 107.309998-121.220001, 109.07->119.50 (117.632263), AAPL@2015-08-31: 107.360001-116.889999, 110.150002->110.300003 (108.576057), AAPL@2015-08-02: 92.00-122.57, 121.50->112.760002 (110.997612), AAPL@2015-06-30: 119.220001-132.970001, 126.900002->121.300003 (118.866096), AAPL@2015-05-31: 124.480003-131.389999, 130.279999->125.43 (122.913223), AAPL@2015-05-12: 125.870003-132.970001, 126.150002->130.279999 (127.665909)]
		Ask: 90.36, Bid: 90.35, Price: 90.35, Prev close: 90.34
		Ask: 90.36, Bid: 90.35, Price: 90.35, Prev close: 90.34
		 */
	}

}
