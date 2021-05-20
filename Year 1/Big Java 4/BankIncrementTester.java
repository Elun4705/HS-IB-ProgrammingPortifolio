/**
* This class just displays the actual result of the Bank Account
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-10-20
*/

import java.util.Scanner;

public class BankIncrementTester {
  public static void main(String[] args) {

    BankIncrement account = new BankIncrement();

    System.out.println("This is your balance $" + account.getBalance());
    System.out.println("This is your annual intrest - " + account.getIntrest() + "%");

    System.out.println("Your balance should be 1005.00 on the 2st month - $" + account.getBalanceIntrest());
    System.out.println("Your balance should be 1010.03 on the 2nd month - $" + account.getBalanceIntrest());
    System.out.println("Your balance should be 1015.08 on the 3rd month - $" + account.getBalanceIntrest());
  }
}