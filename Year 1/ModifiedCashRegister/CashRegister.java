public class CashRegister
{
   public static final double QUARTER_VALUE = 0.25;
   public static final double DIME_VALUE = 0.1;
   public static final double NICKEL_VALUE = 0.05;
   public static final double PENNY_VALUE = 0.01;

   private double purchase;
   private double payment;

   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }

   /**
      Adds x quaters to the purchase of an item.
      @param quaters the number of quarters in the payment
   */
   public void enterQuarters(double quarters)
   {
      payment += quarters * QUARTER_VALUE;
   }

   /**
      Adds x dollars to the purchase of an item.
      @param dollars the number of dollars in the payment
   */
   public void enterDollars(int dollars)
   {
      payment += dollars;
   }

   /**
      Adds x nickels to the purchase of an item.
      @param nickels the number of nickels in the payment
   */
  public void enterNickels(double nickels)
  {
     payment += nickel * NICKEL_VALUE;
  }

  /**
      Adds x penny to the purchase of an item.
      @param penny the number of penny in the payment
   */
  public void enterPenny(double penny)
  {
     payment += penny * PENNY_VALUE;
  }

  /**
      Adds x dime to the purchase of an item.
      @param dime the number of dimes in the payment
   */
  public void enterPenny(double dime)
  {
     payment += dime * DIME_VALUE;
  }

   /**
      Processes the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(int dollars, int quarters, int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      double changeR = Math.round(change * 100.0) / 100.0;
      purchase = 0;
      payment = 0;
      return changeR;
   }
}