/**
* This class just displays the actual result
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-10-06
*/

public class BankAccount {
  private double balance;
  private double transactionFee;
  private double monthlyCharge;
  private int    transactionToFee;
  private int    requestMade;

  public BankAccount() {
    this.balance = 0.00;
    this.transactionFee = 0.10;
    this.monthlyCharge = 0;
  }

  /**
  * This method is used to leave the balance alone bu
  * print the current balance in this case 0
  * @param this.balance  This is the first parameter that is
  * being used, here it's untouched
  * @return int This returns the current value, in this
  * case untouched
  */
  public double getBalance() {
    return this.balance;
  }

  /**
  * This method is used to leave the value alone
  * @param amount  This is the first parameter that is
  * being used, here it's 500 in the  Tester screen
  * This request adds so that it can charge the monthly charge every time
  * moreover, this code behaves as if a month was over each time
  */
  public void deposit(double amount) {
    this.balance += amount;
    this.monthlyCharge++;
  }

  /**
  * This method is used to leave the value alone
  * @param amount  This is the second parameter that is
  * being used, here it's 100 in the  Tester screen
  * Total should be 400 afterwards
  * This request adds so that it can charge the monthly charge every time
  */
  public void withdrawal(double amount) {
    this.balance -= amount;
    this.monthlyCharge++;
  }

  /**
  * This method is used to leave the value alone
  * @param this.transactionFee  This is the third parameter that is
  * being used, here it's 0.10, not show for the user
  */
  public void setTransactionFee(double fee) {
    this.transactionFee = transactionFee;
  }

  /**
  * This method is used to leave the value alone
  * @param this.balance will change and deduct the price of the monthly charge
  */
  public void deductMonthlyCharge() {
    this.balance -= transactionFee * monthlyCharge;
    this.requestMade = 0;
  }

}
