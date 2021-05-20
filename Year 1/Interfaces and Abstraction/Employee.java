
public class Employee implements Measurable
{
   private double annualWage;
   private double wageWithBenefits;

   public Item(double pay, double gross)
   {
      annualWage = pay;
      wageWithBenefits = gross;
   }

  public double getMeasure()
   {
      return annualWage - wageWithBenefits;

   }

}
