This readme will serve as a project planning reference. Any final design notes and documentation should be in the source directory's README

## Class Structure

  * Stock
    * stores stock information such as price. Will be used as a storage class, logic should be elsewhere
    * Member Variables
      * String symbol
      * BigDecimal price
      * BigDecimal open
      * BigDecimal high
      * BigDecimal low
      * BigDecimal vol
      * BigDecimal AvgVol
      * BigDecimal change
      * BigDecimal perChange   // percentage version of change
    * Member Methods
      * Accessors and Modifiers for all the variables

  * Lookup
    * Should gather stock information from whatever API we use for info
    * Member Variables
      * API keys and crap (static and final??)
    * Member Methods
      * getPrice(Stock stock)
      * get*insertInfoHere*(Stock stock)

  * EmailReporter
    * As it sounds, sends email reports according to a schedule.
    * Member Variables
      * Date schedule  // when to send email
      * String email //the user's email should be noted
    * Member Methods
      * reportBought(...) //this

  * LottDestroyer *(MAIN METHOD)*
    * This should be the logic for deciding which stocks to buy, the most difficult part
    * Member variables
      * ArrayList<Stock> trackedStocks
      * ArrayList<Stock> boughtStocks // an ArrayList of all bought stock

  * Trader
    * This will access the API to give the option to buy or sell, then LottDestoryer() will carry it out
    * Member Variables
      * API codes?

    * Member Methods
      * listBought()
