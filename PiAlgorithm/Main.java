import java.text.DecimalFormat;

class Main {
  public static void main(String[] args) {
    String piCom = "3.14159";
    double pi = 1.0;
    int  cycleCount = 1;
    double oddDivision = 3.0;
    String lcl = "";
    String SigFigMax = "";
    DecimalFormat df = new DecimalFormat("#.#####");
    boolean loop = true;
    while (loop){
      if (cycleCount % 2 == 0){
        pi = pi + (1/oddDivision);
      }
      else{
        pi =  pi - (1/oddDivision);
      }
      cycleCount =  cycleCount+ 1;
      oddDivision = oddDivision + 2;

      System.out.println(df.format(4 * pi));

      if (df.format(4 * pi) == piCom) {
        loop = false;
      }
    }
    System.out.println(df.format(pi));
  }
}
