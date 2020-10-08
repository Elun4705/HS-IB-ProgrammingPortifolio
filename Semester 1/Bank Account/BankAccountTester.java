/**
* This class just displays the actual result of the Bank Account
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-10-06
*/

import java.util.Scanner;

public class BankAccountTester {
  public static void main(String[] args) {

    BankAccount account = new BankAccount();

    System.out.print("This is your balance $");
    double balnum = account.getBalance();
    System.out.println(balnum);

    System.out.print("You have now placed $");
    double depnum = account.deposit(500.00);
    System.out.println(depnum);

    System.out.print("You have now removed $");
    int withnum = account.withdrawal(100.00);
    System.out.println(withnum);

    

  }
}
