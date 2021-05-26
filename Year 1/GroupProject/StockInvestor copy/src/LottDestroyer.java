
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

// Allos the user to cancel operation from the start and through the rest of
// run time
public class LottDestroyer {
    public static void cancelTimer(Timer timer, String sen) {
      if(sen != null) {
        timer.cancel();
      }
    }

    // This creates the timer that will loop the LottDestroyer to buy and sell
    // stonks
    public static void main(String[] args) throws IOException {
        Trader trader = new Trader();
        Timer timer = new Timer();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // dtf.format(now) // prints out date and time as string
        System.out.println("Started LottDestroyer at: " + now);

        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                try {
                    trader.theBigBoy();
                } catch (IOException ex) {
                    System.out.println("Oops bad things happens");
                }
            }
        }, 10*60*1000,10*60*1000); // 10 minutes
    }
}
