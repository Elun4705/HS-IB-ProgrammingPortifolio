public class Van extends Vehicle
{
  // This instance variable is added to the subclass
  private String doorNumber;
  private int cupHolders;
  private String trailerHinge;

  public Van()
  {
     // Use the public interface to access the instance variable of the
     // superclass
     setNumberOfTires(4); // same as this.setNumberOfTires(4)
     setColorOfVehicle(Red); // same as this.setColorOfCar(Hazel)
     setNumberOfWindows(8); // same as this.setNumberOfWindows(4)
     doorNumber = 2;
     cupHolders = "?";
     trailerHinge = "?????";
  }

  // This methods is added to the subclass
  public void setDoorNumber(int newValue)
  {
     doorNumber = newValue;
  }

  public void setTrailerHinge(int confirmDenial)
  {
     trailerHinge = confirmDenial;
  }

  public void setCupHolders(int newValue)
  {
     cupHolders = newValue;
  }

  // This method overrides a method from the superclass
  public String getDescription()
  {
     return "A Van with " + doorNumber + " sliding doors and " + cupHolders + " cup holders & has " + trailerHinge + ".";
  }

  // This class inherits the getNumberOfTires and setNumberOfTires methods
}
