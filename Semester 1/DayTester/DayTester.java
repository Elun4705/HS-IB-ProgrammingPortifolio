import java.util.Scanner;

public class DayTester {
   public static void main(String[] args) {
      Day today = new Day();
      Day bDay;
      int mDay, dDay, yDay;
      Scanner s1 = new Scanner(System.in);


      System.out.println("What is your Birthday? ---- Enter as YYYY/MM/DD");
      yDay = s1.nextInt();
      mDay = s1.nextInt();
      dDay = s1.nextInt();
      bDay = new Day(yDay, mDay, dDay);

      System.out.println("Here is how many days you've been alive - " + today.daysFrom(bDay));
   }
}
