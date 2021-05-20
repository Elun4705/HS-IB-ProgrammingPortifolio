/**
* This class just displays the actual result
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-09-30
*/

public class CounterDemo {
  public static void main(String[] args) {

    Counter tally = new Counter();

      tally.click();
      tally.click();
      tally.click();
      tally.undo();

      int result = tally.getValue();

      System.out.print("result: ");
      System.out.println(result);

      tally.reset();

      int cleared = tally.getValue();

      System.out.print("Reset complete - ");
      System.out.println(cleared);
  }
}
