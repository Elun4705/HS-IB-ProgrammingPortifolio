import java.util.Scanner;

class Main {
  public static void main(String[] args){
    double oz_per_day, lifetime, tankers_filled, annual_ounces, fluids_lifetime, ounces_t_gallons;
    Scanner s1 = new Scanner(System.in);
    boolean loop = true;

    //Input
    System.out.println("Welcome to Tanker App! Where you can find out how many Tanker Trucks you will fill in a lifetime!");
    while(loop){

      //Average ounces
      System.out.println("Now...  How many fluid ounces on average do you drink per day?");
      oz_per_day =  s1.nextDouble();

      //Life expectancy
      System.out.println("Good! Now how long do you expect to live?");
      lifetime = s1.nextDouble();

      //Calculation
      System.out.println("Loading...");
      annual_ounces = oz_per_day * 365;
      fluids_lifetime = annual_ounces * lifetime;
      ounces_t_gallons = fluids_lifetime / 128;
      tankers_filled = ounces_t_gallons / 11000;

      //Display output
      System.out.println("Nice, you will fill this many 11,000 gallon Tankers:" + tankers_filled);

      //Result
      System.out.println("Would you like to play again? (y/n)");
      loop = (s1.next().charAt(0) == 'y');
    }
  }
}
