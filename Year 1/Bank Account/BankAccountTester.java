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

    System.out.println("This is your balance $" + account.getBalance());

    account.deposit(500.00);
    System.out.println("This is you new balance $" + account.getBalance());
    System.out.println("Your balance should be $500");

    account.withdrawal(100.00);
    System.out.println("This is now the balance $" + account.getBalance());
    System.out.println("Your balance should be $400");

    account.deductMonthlyCharge();
    System.out.println("This is now the balance for the monthly charge$" + account.getBalance());

  }
}
