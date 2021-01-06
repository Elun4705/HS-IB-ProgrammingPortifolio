public class Bus extends Vehicle
{
  // This instance variable is added to the subclass
  private String seatNumber;
  private String handleBars;
  private int storageContainer;

  public Bus()
  {
     // Use the public interface to access the instance variable of the
     // superclass
     setNumberOfTires(6); // same as this.setNumberOfTires(4)
     setColorOfVehicle(Blue); // same as this.setColorOfCar(Hazel)
     setNumberOfWindows(18); // same as this.setNumberOfWindows(4)
     seatNumber = "??????";
     handleBars = "?????";
     storageContainer = "?";
  }

  // This methods is added to the subclass
  public void setSeatNumber(int newValue)
  {
     seatNumber = newValue;
  }

  public void setHandleBars(int newValue)
  {
     handleBars = newLocation;
  }

  public void setStorageContainer(int newValue)
  {
     storageContainer = newValue;
  }

  // This method overrides a method from the superclass
  public String getDescription()
  {
     return "A Bus with seat number of  " + seatNumber + " with " + storageContainer + " storage containers & " + handleBars + " handle bars to hold on to.";
  }

  // This class inherits the getNumberOfTires and setNumberOfTires methods
}
