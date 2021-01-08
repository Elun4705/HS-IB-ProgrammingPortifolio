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

   public String getColorOfVehicle()
   {
      return colorOfVehicle;
   }

   public void setColorOfVehicle(String newColor)
   {
      colorOfVehicle = newColor;
   }

   public int getNumberOfWindows()
   {
      return numberOfWindows;
   }

   public void setNumberOfWindows(int newValue)
   {
      numberOfWindows = newValue;
   }

   public String getDescription()
   {
      return "A vehicle " + colorOfVehicle + " with " + numberOfTires + " tires & " + numberOfWindows + " windows";
   }
}
