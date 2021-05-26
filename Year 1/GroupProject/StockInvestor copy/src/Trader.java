/**
* The DataReadWriter class holds methods to interact with the .dat files needed
* for a non-volitile setup
* NOTE: The first line of portfolio.dat is the avalible balance. This should
* never change
*
* @author  Joseph Wardle
* @version 1.0
* @since   2021.05.20
*/

import yahoofinance.*;
import java.math.BigDecimal;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Trader {
    private Scanner TSScanner;
    private Scanner histScanner;
    private Scanner portScanner;
    private FileWriter histWriter;
    private DateTimeFormatter dtf;
    private LocalDateTime now;


    public Trader() throws IOException  {
        TSScanner = new Scanner(new File("trackedStocks.dat"));
        histScanner = new Scanner(new File("history.dat"));
        histScanner.useDelimiter("/n");
        portScanner = new Scanner(new File("portfolio.dat"));
        // histScanner.useDelimiter(" ");
        histWriter = new FileWriter("history.dat", true);
        now = LocalDateTime.now();
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    /**
    * returns an ArrayList containing every tracked stock
    *
    * @return   an ArrayList of type Stock
    * @throws   java.io.IOException when it cannot read trackedStocks.dat
    */
    public ArrayList<Stock> getTrackedStocks() throws IOException {
        TSScanner = new Scanner(new File("trackedStocks.dat"));
        ArrayList<Stock> trackedStocks = new ArrayList<Stock>();
        while(TSScanner.hasNext()) {
            String symbol = TSScanner.next();
            //System.out.println("Stock: " + symbol);
            trackedStocks.add(YahooFinance.get(symbol));
        }
        return trackedStocks;
    }

    /**
    * returns an ArrayList. Each ArrayList container is one complete line of history.dat
    *
    * @return   ArrayList of type String
    */
    public ArrayList<String> getHistory() throws IOException {
        histScanner = new Scanner(new File("history.dat"));
        ArrayList<String> history = new ArrayList<String>();
        while(histScanner.hasNext()) {
            history.add(histScanner.next());
        }
        return history;
    }

    /**
    * returns an ArrayList of string arrays. Each array contains the stock symbol
    * at [0] and the quantity owned at [1]
    *
    * @return   an ArrayList of type String[]
    */
    // public ArrayList<String> getPortfolio() {
    //     portScanner = new Scanner(new File("portfolio.dat"));
    //     ArrayList<String[]> portfolio = new ArrayList<String[]>();
    //     BigDecimal balance = new BigDecimal(portScanner.next());
    //     while(portScanner.hasNext()) {
    //         portfolio.add({portScanner.next(), portScanner.next()});
    //     }
    //     return portfolio;
    // }


    /**
    * appends history.dat with any transation information
    *
    * @param bought     whether or not the transaction was BUY or SELL. True for
    *                       bought, false for sell
    * @param symbol     symbol of traded stock
    * @param price      price of traded stock
    * @param quantity   quantity of stock being traded
    * @param time       time of transaction
    * @throws   java.io.IOException when it cannot find history.dat
    */
    public void addHistory(boolean bought, String symbol, BigDecimal price,
            int quantity, String time) throws IOException {
        if(bought) {
            histWriter.write("BOUGHT:  Symbol: " + symbol + "  Price: " + price
                    + "  Quantity: " + quantity + "  Time: " + time + "\n");
        } else {
            histWriter.write("SOLD:  Symbol: " + symbol + "  Price: " + price +
                    "  Quantity: " + quantity + "  Time: " + time + "\n");
        }
        histWriter.flush();
    }

    /**
    * adds a stock to portfolio.dat
    *
    * @param symbol     the symbol of the stock
    * @param quantity   the quantity purchased
    */
    public void addPortfolio(String symbol, int quantity, BigDecimal price) throws IOException {
        FileWriter portWriter = new FileWriter("portfolio.dat", true);
        portWriter.write(symbol + " " + quantity); //\n" + symbol + " " + quantity
        portWriter.flush();
        portWriter.close();
        //System.out.println(BigDecimal.ZERO.subtract(price).multiply(new BigDecimal(quantity)));
        addBalance(BigDecimal.ZERO.subtract(price).multiply(new BigDecimal(quantity)));
    }

    /**
    * sells every stock in the portfolio and adds the funds back to avalible
    * balance
    */
    public void clearPortfolio() throws IOException {
        portScanner = new Scanner(new File("portfolio.dat"));
        BigDecimal balance = getBalance();
        while (portScanner.hasNext()) {
            Stock stock = YahooFinance.get(portScanner.next());
            BigDecimal price = stock.getQuote().getPrice();
            BigDecimal quantity = new BigDecimal(portScanner.next());
            System.out.println("PRICE: " + price);
            System.out.println("QUANTITY: " + quantity);
            System.out.println("TOTAL VALUE: " + price.multiply(quantity));
            addBalance(price.multiply(quantity));
        }
    }

    /**
    * calculates total value of all assets in portfolio, including current
    * investments. This will be needed to calculate how much of each stock can
    * be purchased according to the rules of the Stock Market Game and may be a
    * useful log datapoint
    *
    * @return   total value
    */
    public BigDecimal getTotalBalance() throws IOException {
        portScanner = new Scanner(new File("portfolio.dat"));
        BigDecimal totalBalance = new BigDecimal(portScanner.next());
        while(portScanner.hasNext()) {
            BigDecimal price = YahooFinance.get(portScanner.next()).getQuote().getPrice();
            BigDecimal quantity = new BigDecimal(portScanner.next());
            totalBalance.add(price.multiply(quantity));
        }
        return totalBalance;
    }

    public BigDecimal getBalance() throws IOException {
        portScanner = new Scanner(new File("portfolio.dat"));
        BigDecimal balance;
        balance = new BigDecimal(portScanner.next());
        return balance;
    }

    public void addBalance(BigDecimal amount) throws IOException {
        BigDecimal balance = getBalance();
        BigDecimal newBalance = balance.add(amount);
        StringBuffer buffer = new StringBuffer();
        //Reading lines of the file and appending them to StringBuffer
        portScanner = new Scanner(new File("portfolio.dat"));
        while (portScanner.hasNextLine()) {
           buffer.append(portScanner.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        String oldLine = balance.toString();
        String newLine = newBalance.toString();
        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter("portfolio.dat");
        writer.write(fileContents);
        writer.flush();
    }

    public void theBigBoy() throws IOException {
        Trader trader = new Trader();
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
    }
}
