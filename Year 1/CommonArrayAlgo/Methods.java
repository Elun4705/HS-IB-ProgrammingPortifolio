import java.util.concurrent.ThreadLocalRandom;

public class Methods {


  public Methods()
  {
     public int total = 0;
  }

  public SumArray() {
    int[] array = new int[] array;

    for(int i=0; i<array.length; i++ ) {
      total = int total + array[i];
    }
    return total;
  }

  public AveArray() {
    int[] arrayF= = new int[] array;

    for(int i=0; i<array.length; i++ ) {
      total = int total + array[i];
    }
    total = total / array.length;
    return total;
  }

  public int max(int [] array) {
      int max = 0;

      for(int i=0; i<array.length; i++ ) {
         if(array[i]>max) {
            max = array[i];
         }
      }
      return max;
   }

   public int min(int [] array) {
      int min = array[0];

      for(int i = 0; i<array.length; i++ ) {
         if(array[i]<min) {
            min = array[i];
         }
      }
      return min;
   }

   public randomArray() {
     int[] array = new int[] array;

     for (int i = 0; i < array.length; i++) {
       int randomNum = ThreadLocalRandom.current().nextInt(-99, 99 + 1);
       array[i] = randomNum;
     }

     return array;
   }

   public cloneArray() {
     int[] array = new int[] array;
     int[] dest = array.clone();

     return array;
   }

}
