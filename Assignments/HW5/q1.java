package HW5;

import java.time.LocalDateTime;

public class q1 {
  public static void main(String args[]) {

    // This gets the value of this exact moment
    LocalDateTime now = LocalDateTime.now();
    Day today = new Day(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    Day bday = new Day(2002, 12, 23);

    System.out.println("The number of days since I was born is: ");
    System.out.println(today.daysFrom(bday));

  }

}
