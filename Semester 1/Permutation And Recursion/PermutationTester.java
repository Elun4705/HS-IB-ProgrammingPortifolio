import java.util.ArrayList;

public class PermutationIterator
{
  ArrayList<String> result = new ArrayList<String>();
  private String word;
  private int current;
  private PermutationIterator tailIterator;
  private String tail;

  /**
    Permutation iterator for given word.
    @param aWord the word to permute
  */

  public ArrayList<String> PermutationIterator(String aWord)
  {
    ArrayList<String> result = new ArrayList<String>();
    if (word.length() == 0) {
       result.add(word);
       return result;
    }
    else {
         for (int i = 0; i < word.length(); i++)
         {
           String shorter = word.substring(0, i) + word.substring(i + 1);
           ArrayList<String> shorterPermutations = PermutationIterator(shorter);
           for (String s : shorterPermutations)
           {
             result.add(word.charAt(i) + s);
           }
         }
         // Return all permutations
         return result;
       }
     }
   // public PermutationIterator(String aWord)
   // {
   //
   // }
   //
   // public String nextPermutation()
   // {
   //    if (word.length() == 0)
   //    {
   //       current++;
   //       return "";
   //    }
   //
   //    char c = word.charAt(current);
   //    String nextPermut = tailIterator.nextPermutation();
   //
   //    if (!tailIterator.hasMorePermutations())
   //    {
   //       current++;
   //       if (current >= word.length())
   //       {
   //          tailIterator = null;
   //       }
   //       else
   //       {
   //          if (current + 1 >= word.length())
   //          {
   //             tail = word.substring(0, current);
   //          }
   //          else
   //          {
   //             tail = word.substring(0, current)
   //                   + word.substring(current + 1, word.length());
   //          }
   //          tailIterator = new PermutationIterator(tail);
   //       }
   //    }
   //    return c + nextPermut;
   // }
   //
   // public boolean hasMorePermutations()
   // {
   //    return current < word.length() || tailIterator != null
   //          && tailIterator.hasMorePermutations();
   // }
}
