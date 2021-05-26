
/**
* The LottDestroyer class is the entry point to the pragram and houses the
* difficult logic
*
* @author  Tyler Roache, Emmanuel Luna, Joseph Wardle, Max Tokhtuev
* @version 1.0
* @since   2020.12.09
*/

import java.io.*;
import yahoofinance.*;

import java.util.Timer;
import java.util.TimerTask;

import java.io.IOException;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Scanner;
import java.math.BigDecimal;

import java.util.ArrayList;

public class Tester {
    public static void cancelTimer(Timer timer, String sen) {
      if(sen != null) {
        timer.cancel();
      }
    }

    public static void main(String[] args) throws IOException {
        Trader trader = new Trader();
        Timer timer = new Timer();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // dtf.format(now) // prints out date and time as string

        // new java.util.Timer().schedule(new TimerTask() {
        //     @Override
        //     public void run() {
                trader.clearPortfolio();
                now = LocalDateTime.now();

                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Executed at " + dtf.format(now));

                System.out.println("Getting List of Tracked Stocks: ");

                ArrayList<Stock> trackedStocks = trader.getTrackedStocks();
                System.out.println();

                // Find the 5 best stocks
                System.out.println("Finding the 5 Best Stocks");
                BigDecimal maxPer = BigDecimal.ZERO;
                Stock[] best5 = {YahooFinance.get("INTC"),
                        YahooFinance.get("INTC"), YahooFinance.get("INTC"),
                        YahooFinance.get("INTC"), YahooFinance.get("INTC")};
                for(Stock stock : trackedStocks) {
                    if(stock.getQuote().getChangeInPercent().compareTo(maxPer) > 0) {
                        System.out.println("New Best!!! Symbol: " + stock.getSymbol());
                        maxPer = stock.getQuote().getChangeInPercent();
                        best5[4] = best5[3];
                        best5[3] = best5[2];
                        best5[2] = best5[1];
                        best5[1] = best5[0];
                        best5[0] = stock;
                    }
                }


                // Buy the 5 best stocks
                System.out.println("\nBuying the 5 best stocks");
                BigDecimal totalBalance = trader.getTotalBalance();

                for(Stock stock : best5){
                    System.out.println();
                    System.out.println("Symbol: " + stock.getSymbol() + " PercChange: " + stock.getQuote().getChangeInPercent());
                    BigDecimal price = stock.getQuote().getPrice();
                    System.out.println("Price: " + price);
                    int quantity = (totalBalance.intValue() / 5) / price.intValue();
                    while (price.multiply(new BigDecimal(quantity)).compareTo(trader.getTotalBalance().multiply(new BigDecimal(.2))) > 0) {
                        quantity --;
                    }
                    while (price.multiply(new BigDecimal(quantity)).compareTo(trader.getBalance()) > 0) {
                        quantity --;
                    }
                    trader.addPortfolio(stock.getSymbol(), quantity, price);
                }
                cancelTimer(timer, "test");
            }
        // }, 10*60*1000,10*60*1000); // 10 minutes
    }



// /**
// * This Class is purely for demonstration purposes and
// * should not be included in the final build.
// *
// * To compile: javac -cp ".;YahooFinanceAPI-3.15.0.jar;slf4j-api-1.7.9.jar;jackson-core-2.12.3.jar;jackson-databind-2.12.3.jar;jackson-annotations-2.12.3.jar;" Tester.java
// * To run: java -cp ".;YahooFinanceAPI-3.15.0.jar;slf4j-api-1.7.9.jar;jackson-core-2.12.3.jar;jackson-databind-2.12.3.jar;jackson-annotations-2.12.3.jar;" Tester
// */
//
// import yahoofinance.*;
// import java.math.BigDecimal;
// import java.io.*;
//
// public class Tester {
//     public static void main(String[] args) throws IOException {
//         // How to declare a Stock
//         Stock stock = YahooFinance.get("INTC");
//
//         // Most relevant draw calls (check the YahooFinance source on GitHub for complete list)
//         String symbol = stock.getSymbol();
//         BigDecimal price = stock.getQuote().getPrice();
//         BigDecimal change = stock.getQuote().getChangeInPercent();
//         BigDecimal peg = stock.getStats().getPeg();
//         BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
//
//         System.out.println();
//         System.out.println("Symbol: " + symbol);
//         System.out.println("Price: " + price);
//         System.out.println("Change in Percent: " + change);
//         System.out.println("Peg: " + peg);
//         System.out.println("Dividend: " + dividend);
//         System.out.println();
//
//         // Verbose information print.
//         stock.print();
//     }
// }
