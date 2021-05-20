/**
   An Item represents a product for sale.
*/
public class Item implements Measurable
{
   private double retailPrice;
   private double wholesalePrice;

   /**
      Constructs an Item.
      @param retail the retail price of this item.
      @param wholesale the wholesale price of this item.
   */
   public Item(double retail, double wholesale)
   {
      retailPrice = retail;
      wholesalePrice = wholesale;
   }

  public double getMeasure()
   {
      return retailPrice - wholesalePrice;

   }

}
