import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class question3 {
  public static void main(String args[]) {
    double number = 12345.678;
    String numString = "12,345.678";
    toUK(number);
    toUS(number);
    toNumber(numString);

  }

  public static void toUK(double number) {
    NumberFormat nf = NumberFormat.getInstance(Locale.UK);
    nf.setMaximumFractionDigits(2);

    String formattedNumber = nf.format(number);

    System.out.println("The number formatted to UK is: ");
    System.out.println(formattedNumber);
    System.out.println();

  }

  public static void toUS(double number) {
    NumberFormat nf = NumberFormat.getInstance(Locale.US);

    String formattedNumber = nf.format(number);

    System.out.println("The number formatted to US is: ");
    System.out.println(formattedNumber);
    System.out.println();

  }

  public static void toNumber(String numString) {
    NumberFormat nf = NumberFormat.getInstance(Locale.US);
    Number formattedNumber = 0;

    try {
      formattedNumber = nf.parse(numString);
    } catch (ParseException ex) {
      System.out.println(ex);
    }

    System.out.println("The String formatted to number is: ");
    System.out.println(formattedNumber);
    System.out.println();

  }
}
