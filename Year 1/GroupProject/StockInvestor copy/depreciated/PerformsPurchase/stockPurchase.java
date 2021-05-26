import java.util.ArrayList;
import java.text.DecimalFormat;
  
private ArrayList<Double> purchaseCommissions;
private int balance;
  
public Stock purchase(Stock stocks, int shares) {
  double commission;
  double tempBalance;
  Stock newStock = stocks;
  for(int i = 0; i<shares; i++) {
    tempBalance += stocks.getPrice();
  }
  commission = RoundTo2Decimals(tempBalance * 0.01);
  balance -= commission;  //double balance is the balance of our current resources in the super class
  purchaseCommissions.add(commission);
  return newStock;
}

public double RoundTo2Decimals(double val) {
  DecimalFormat df2 = new DecimalFormat("###.##");
  return Double.valueOf(df2.format(val));
}
 

/*This is submitted as a class but take the import statements and two methods and add them to the main class.
* Jonathan Tran and Alexei Garcia
*/
