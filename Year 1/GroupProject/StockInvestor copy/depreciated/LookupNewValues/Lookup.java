/*
JEFFREY WORLEY and BERNARD LI
*/

import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Lookup {
  
 	private ArrayList<Stocks> stocks;
	private long hours;
	private long minutes;
	private long delayHours;
	private long delayMinutes;
 	private Timer timer;
 	private OurTimerTask ott;
 	private Log log = new Log();

  	public Lookup(ArrayList<Stocks> stocks, long hours, long minutes, long delayHours, long delayMinutes) {
    		this.stocks = new ArrayList<Stocks>(stocks);
		    this.hours = hours;
    		this.minutes = minutes;
    		this.delayHours = delayHours;
    		this.delayMinutes = delayMinutes;
    		timer = new Timer();
    		ott = new OurTimerTask();
  	}
  
  	public void newVals()throws IOException{
    		//insert yahoo API here and use its values to create new Stock objects*
    		for(Stocks s : stocks) {
    	  	//change values in stocks to new values from Yahoo API objects*;
    			s.setCurrentMarketPrice(YahooFinance.get(s.getSymbol()).getQuote().getPrice());
    			if(s.getCurrentMarketPrice().compareTo(s.getPriceBoughtAt()) > 0){
    				s.setPriceBoughtAt(s.getCurrentMarketPrice());
                    System.out.println("a buy occured");
                }
    			log.writeToFile(s.getSymbol(), 1, s.getPriceBoughtAt());
    		}
  	}
  
	public void periodicCheck() {
	    timer.scheduleAtFixedRate(ott, (delayHours * 60 * 60000) + (delayMinutes * 60000), (hours * 60 * 60000) + (minutes * 60000));
	}
  
	public void stopChecking() {
	    timer.cancel();
	}

	public ArrayList<Stocks> getValues() {
	    return stocks;
	}

	public class OurTimerTask extends TimerTask{

		public OurTimerTask(){
			super();
		}

		public boolean shouldCheckingContinue(){
			Date currentTime = new Date();
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(currentTime);
			if(calendar.HOUR_OF_DAY >= 15 ){
				return false;
			} else if(calendar.DAY_OF_WEEK == 1 || calendar.DAY_OF_WEEK  == 7){
				return false;
			}
			return true;
		}

		public void run(){
			if(shouldCheckingContinue()){
				try{
					newVals();
					System.out.println("Hello World");
				}
				catch (IOException e){
					System.out.println("Error: " + e.getMessage());
				}

	      		}
		}
	}
}
