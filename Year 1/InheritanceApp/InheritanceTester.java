public class InheritanceTester
{

  public static void print(Car c)
   {
      System.out.println(c.getDescription());
   }

   public static void print(Van v)
    {
       System.out.println(v.getDescription());
    }

    public static void print(Bus b)
     {
        System.out.println(b.getDescription());
     }

   public static void main(String[] args)
   {

      Car aLimo = new Car();
      aLimo.setLicensePlateNumber("Kirby");
      aLimo.setHoodLocation("Back");
      aLimo.setCupHolders("4");
      print(aLimo);

      Van aSuv = new Van(); // aSuv.setDoorNumber(4); You can change this here or in child class
      aSuv.setDoorNumber("4");
      aSuv.setCupHolders("6");
      aSuv.setTrailerHinge("1");
      print(aSuv);

      Bus aTrax = new Bus();
      aTrax.setSeatNumber("36");
      aTrax.setStorageContainer("4");
      aTrax.setHandleBars("8");
      print(aTrax);
   }
}
