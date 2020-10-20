/**
* This class just displays the actual result of the Bank Account
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-10-20
*/

public class BankIncrement {
    private double balance;
    private double annnualIntrest;
    private double monthlyIntrest;
    private double balanceR;

    /**
    * This method is used to leave the value alone
    * @param this.balance  This is the first parameter
    * being used to be $1000
    * @param this.annualIntrest  This is the second parameter
    * being used to be 6%
    * @param this.monthlyIntrest  This is the third parameter
    * being used to be 0.005 bucks
    */
    public BankIncrement() {
        this.balance = 1000.00;
        this.annnualIntrest = 6.00;
        this.monthlyIntrest = 0.005;
    }

    /**
    * This method is used to leave the value alone
    * @param this.balance This is the first parameter
    * being used return the 1000 text
    */
    public double getBalance() {
        return this.balance;
    }

    /**
    * This method is used to leave the value alone
    * @param this.annualIntrest This is the second parameter
    * being used return the 6%
    */
    public double getIntrest() {
        return this.annnualIntrest;
    }

    /**
    * This method is used to leave the value alone
    * @param this.balanceR This is the third parameter
    * being used return new 1000 each month
    */
    public double getBalanceIntrest() {
            this.balance += this.balance * this.monthlyIntrest;
            this.balanceR = Math.round(this.balance * 100.0) / 100.0;
            return this.balanceR;
    }
}
