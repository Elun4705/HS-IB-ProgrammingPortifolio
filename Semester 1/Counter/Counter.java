/**
* This class just stores an integer and displays it
* after any of the following is used
* @author  Emmanuel Luna
* @version 1.0
* @since   2020-09-30
*/

public class Counter
{
   private int value;

   // default Constructor
   public Counter() {
     value = 0;
   }

   // 2nd constructor for passing in an int
   public Counter(int initialValue) {
     value = initialValue;
   }

   /**
   * This method is used to leave the value alone
   * @param value  This is the first parameter that is
   * being used, here it's untouched
   * @return int This returns the current value, in this
   * case untouched
   */
   public int getValue() {
      return value;
   }

   /**
   * This method is used to incremment the value by 1
   * @param value  This is the 2nd time that this
   * parameter is being called
   */
   public void click() {
      value = value + 1;
   }

   /**
   * This method is used to reset the current value
   * @param value  This is the 3rd time this is called here
   * to set it to 0
   */
   public void reset() {
      value = 0;
   }

   /**
   * This method is used to reset the current value
   * @param value  This is the 4th time this is called here
   * this is used to write value - 1
   */
   public void undo() {
     value = value - 1;
   }
}
