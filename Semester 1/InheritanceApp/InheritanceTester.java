public class InheritanceTester
{

   // public static void print(Car c)
   // {
      // System.out.println(c.getDescription());
      // System.out.println("Tires: " + c.getNumberOfTires());
   // }


   public static void main(String[] args)
   {

      Car aLimo = new Car();
      aLimo.setLicensePlateNumber("Kirby");
      aLimo.setHoodLocation("Back");
      aLimo.setCupHolders(4);
      aLimo.getDescription();

      Van aSuv = new Van();
      // aSuv.setDoorNumber(4); You can change this here or in child class
      aSuv.setHoodLocation("Back");
      aSuv.setCupHolders(4);
      aSuv.getDescription();

      Bus aTrax = new Bus();
      aTrax.setSeatNumber(36);
      aTrax.setStorageContainer(4);
      aTrax.setHandleBars(8);
      aTarx.getDescription();
   }
}
