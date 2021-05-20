public class Car extends Vehicle
{
   // This instance variable is added to the subclass
   private String licensePlateNumber;
   private String hoodLocation;
   private String cupHolders;

   public Car()
   {
      // Use the public interface to access the instance variable of the
      // superclass
      setNumberOfTires(4); // same as this.setNumberOfTires(4)
      setColorOfVehicle("Hazel"); // same as this.setColorOfCar(Hazel)
      setNumberOfWindows(6); // same as this.setNumberOfWindows(4)
      licensePlateNumber = "??????";
      hoodLocation = "?????";
      cupHolders = "?";
   }

   // This methods is added to the subclass
   public void setLicensePlateNumber(String newValue)
   {
      licensePlateNumber = newValue;
   }

   public void setHoodLocation(String newLocation)
   {
      hoodLocation = newLocation;
   }

   public void setCupHolders(String newValue)
   {
      cupHolders = newValue;
   }

   // This method overrides a method from the superclass
   public String getDescription()
   {
      return "A Car with license plate " + licensePlateNumber + " with " + cupHolders + " cup holders & hood at the " + hoodLocation + ".";
   }

   // This class inherits the getNumberOfTires and setNumberOfTires methods
}
