import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class HW1_2
 {   
  static ArrayList<Integer> array = new ArrayList<Integer>();

  public static void main(String args[])
  {
    // Get the random values and put them in an arrayList
    getNumbers();
    //Gets user input and prints the value
    getUserInput();
   
  }
  
  //This method fills the ArrayList with 100 random values
  public static void getNumbers()
  {
    int i = 0;
    while(i<100)
    {
      int var = (int)(100*Math.random());
      array.add(var);
      i++;
    }
  }

  //This method gets user input and either displays the value in the index they chose or display out of bounds
  public static void getUserInput()
  {
    try
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Choose an Index (Between 0 and 99):");
      int userVal = input.nextInt();
      System.out.println("The value in index " + userVal + " is: " + array.get(userVal));
      
    }
    catch(IndexOutOfBoundsException e)
    {
      System.out.println("Out of Bounds.");
    }
  }

}
