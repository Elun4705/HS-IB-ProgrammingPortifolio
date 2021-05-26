// I did this - Tim Austin

public class EvaluateWhetherToBuyOrNah{
  
  String index;
  double currentPricePerShare;
  int currentPercentD;
  String sector;
  double currentAccountBalance;
  int totalValueOfSharesOfStockCurrentlyOwnedInTheSameSector;
  boolean isOnNYSEOrNASDAQ;
  int score = 0;
  int currentPercentK;
  boolean isDiverse = false;
  
  //constructor
  public EvaluateWhetherToBuyOrNah(String index, double currentPricePerShare, int currentPercentD, int currentPercentK, String sector, double currentAccountBalance, int totalValueOfSharesOfStockCurrentlyOwnedInTheSameSector, boolean isOnNYSEOrNASDAQ) {
    this.index = index;
    this.currentPricePerShare = currentPricePerShare;
    this.currentPercentD = currentPercentD;
    this.currentPercentK = currentPercentK;
    this.sector = sector;
    this.currentAccountBalance = currentAccountBalance;
    this.totalValueOfSharesOfStockCurrentlyOwnedInTheSameSector = totalValueOfSharesOfStockCurrentlyOwnedInTheSameSector;
    this.isOnNYSEOrNASDAQ = isOnNYSEOrNASDAQ;
  }
  
  //evaluation method
  public int evaluateIfToBuy() {
    
    //put call to diversity check method here ya goof
    isDiverse = checkForDiversity();
    
    if((currentPricePerShare <= 3) || (currentAccountBalance < 15000) || ((currentPricePerShare * 10) > (currentAccountBalance * 0.85)) || (isDiverse == false)) {
      //message for if stock has been filtered out
      System.out.println("stock has been filtered out");
      
      return 0;
    } else{
      score = score + 1;
      System.out.println("Hit top bit");
      if(currentPercentK > currentPercentD) {
        score = score + 1;
      }
      if((currentPercentK > currentPercentD) && (currentPercentK < 20 && currentPercentD < 20)) {
        score = score + 2; 
        System.out.println("Hit final check");
      }
    }
    return score;
  }
  
  //diversity check method
  public boolean checkForDiversity() {
    //for now, we assume all are diverse
    System.out.println("diversity method called");
    return true;
  }
}
