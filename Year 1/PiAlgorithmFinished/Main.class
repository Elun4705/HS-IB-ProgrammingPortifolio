class Main {
  public static void main(String[] args) {
    String piCom = "3.14159";
    Double strt = 1.0;
    int s = 1;
    double n = 3.0; 
    String pi = "";
    String SigFigMax = "";
    while (true){
      if (s % 2 == 0){
        strt = strt + (1/n);
      }  
      else{
        strt = strt - (1/n);
      }
        s = s + 1;
        n = n + 2;
    
        pi = "" + 4 * strt;
        SigFigMax = pi.substring(0, Math.min(pi.length(), 7));
      if (SigFigMax.equals(piCom)) {
        break;
        }
      }
    System.out.println(SigFigMax);
  }
}