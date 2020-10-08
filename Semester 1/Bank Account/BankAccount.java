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

  public Account() {
    this.balance = 0.00;
    this.transactionFee = 0.10;
    this.monthlyCharge = 0;
  }

  public getBalance() {
    return this.balance;
  }

  public deposit(double amount) {
    this.balance += amount;
  }

  public withdrawal(double amount) {
    this.balance -= amount;
  }

  public setTransactionFee(double fee) {
    this.transactionFee = fee;
  }

  public deductMonthlyCharge() {
    balance -= transactionFee;
    transactionFee = 0;
  }

}
