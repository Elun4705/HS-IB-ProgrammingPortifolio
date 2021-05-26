import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;

//Created by Mathew Beseris

public class Logs {
    //will take in either "buy" or "sell", index name and number of shares
    public static void logTrade(String type, String index, int shares) throws FileNotFoundException{
        String day = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        try {
            PrintWriter out = new PrintWriter(new FileWriter(day + ".txt", true));
            out.println(time + ": A trade order to " + type + " " + shares + " shares of " + index + " was executed.");
            out.close();
        } catch(IOException ex) {
            PrintWriter out = new PrintWriter(day + ".txt");
            out.println(time + ": A trade order to " + type + " " + shares + " shares of " + index + " was executed.");
            out.close();
        }
    }

    public void startup() {
        PrintWriter out = new PrintWriter(day + ".txt");
        out.println(time + ": The device has powered on.");
        out.close();
    }
}
