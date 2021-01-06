public class Vehicle
{
   private int numberOfTires;
   private String colorOfVehicle;
   private int numberOfWindows;

   public int getNumberOfTires()
   {
      return numberOfTires;
   }

   public void setNumberOfTires(int newValue)
   {
      numberOfTires = newValue;
   }

   public String getColorOfCar()
   {
      return numberOfTires;
   }

   public void setColorOfVehicle(String newColor)
   {
      colorOfCar = newColor;
   }

   public int getNumberOfWindows()
   {
      return numberOfTires;
   }

   public void setNumberOfWindows(int newValue)
   {
      numberOfTires = newValue;
   }

   public String getDescription()
   {
      return "A vehicle " + colorOfCar + " with " + numberOfTires + " tires & " + numberOfWindows + " windows";
   }
}
