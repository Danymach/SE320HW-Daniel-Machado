import java.util.Scanner;

public class assertionQuestion {
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input a value between 0 and 10 inclusive: ");

    int input = scanner.nextInt();

    assert (0 <= input && input <= 10) : " the entered value is out of range";

  }
}
