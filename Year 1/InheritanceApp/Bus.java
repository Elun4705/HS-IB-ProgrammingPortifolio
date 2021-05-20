public class Bus extends Vehicle
{
  // This instance variable is added to the subclass
  private String seatNumber;
  private String handleBars;
  private String storageContainer;

  public Bus()
  {
     // Use the public interface to access the instance variable of the
     // superclass
     setNumberOfTires(6); // same as this.setNumberOfTires(4)
     setColorOfVehicle("Blue"); // same as this.setColorOfCar(Hazel)
     setNumberOfWindows(18); // same as this.setNumberOfWindows(4)
     seatNumber = "??????";
     handleBars = "?????";
     storageContainer = "?";
  }

  // This methods is added to the subclass
  public void setSeatNumber(String newValue)
  {
     seatNumber = newValue;
  }

  public void setHandleBars(String newValue)
  {
     handleBars = newValue;
  }

  public void setStorageContainer(String newValue)
  {
     storageContainer = newValue;
  }

  // This method overrides a method from the superclass
  public String getDescription()
  {
     return "A Bus with a seat number of " + seatNumber + " with " + storageContainer + " storage containers & " + handleBars + " handle bars to hold on to.";
  }

  // This class inherits the getNumberOfTires and setNumberOfTires methods
}
