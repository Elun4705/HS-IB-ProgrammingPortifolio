public class MeasurableTester
{
  public static void main(String[] args)
  {

    Measurable movieSnack = new Item(8.95, 1.15);
    System.out.printf("Theater popcorn: %.2f%n" movieSnack.getMeasure());
    System.out.println("Expected: 7.80");

    Measurable cereal = new Item(5.95, 1.15);
    System.out.printf("Processed breakfast cereal: %.2f%n" cereal.getMeasure());
    System.out.println("Expected: 4.80");

    Measurable cosmetics = new Item(89.15, 7.35);
    System.out.printf("Designer cosmetics: %.2f%n" cosmetics.getMeasure());
    System.out.println("Expected: 81.80");

    Measurable prescription = new Item(9375.23, 12.35);
    System.out.printf("Brand-name prescription drug: %.2f%n" prescription.getMeasure());
    System.out.println("Expected: 7.80");

    Measurable wage = new Employee(90000,40000);
    System.out.printf("Employees wage: %.2f%n" wage.getMeasure());
    System.out.println("Expected: 50000");

  }
}
