// I did this - Tim Austin

public class TestEntryPoint{
  public static void main(String args[]) {
    
    EvaluateWhetherToBuyOrNah testStock = new EvaluateWhetherToBuyOrNah("AAPL", 90.46, 87, 79, "Technology", 100000, 500, true);
    System.out.println("Stock 1 = " + testStock.evaluateIfToBuy());
    
    EvaluateWhetherToBuyOrNah testStock2 = new EvaluateWhetherToBuyOrNah("IDEAL", 25, 15, 19, "Technology", 100000, 500, true);
    System.out.println("Stock 2 = " + testStock2.evaluateIfToBuy());
  }
}
