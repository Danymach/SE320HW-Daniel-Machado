import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class HW1
{
  //ArrayList used to store the 2 inputs from the user
  static ArrayList<Integer> values = new ArrayList<Integer>();
  public static void main(String args[])
  {
    //request the 2 integers
    requestInt();
    requestInt();
    //Do the sum of the two values and print it at the same time
    System.out.println("The sum is: " + (values.get(0)+values.get(1)));
  }

  //Method that gets the input and checks if it is an integer
  public static void requestInt()
  {
    boolean leave = false; 
    while (!leave)
    {
      try
      {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input an Integer: ");
        int val = input.nextInt();

        values.add(val);
        leave = true;
      }
      catch(InputMismatchException e)
      {
        System.out.println("Wrong Type. Make sure the input is an integer");
      }
    }
  }
}
