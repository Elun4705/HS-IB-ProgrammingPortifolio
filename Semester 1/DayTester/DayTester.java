import java.util.Scanner;

public class DayTester {
   public static void main(String[] args) {
      Day today = new Day();
      Day bDay;
      int mDay, dDay, yDay;
      Scanner s1 = new Scanner(System.in);


      System.out.println("What is your Birthday? ---- Enter as MM/DD/YY");
      mDay = s1.nextInt();
      dDay = s1.nextInt();
      yDay = s1.nextInt();
      bDay = new Day(mDay, dDay, yDay);

      System.out.println("Here is how many days you've been alive - " + today.daysFrom(bDay));
   }
}
