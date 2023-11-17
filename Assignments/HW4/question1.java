import java.util.LinkedHashSet;

public class question1 {
  public static void main(String args[]) {
    LinkedHashSet<String> set1 = new LinkedHashSet<String>();
    LinkedHashSet<String> set2 = new LinkedHashSet<String>();
    

    set1.add("George");
    set1.add("Jim");
    set1.add("John");
    set1.add("Blake");
    set1.add("Kevin");
    set1.add("Michael");

    set2.add("George");
    set2.add("Katie");
    set2.add("Kevin");
    set2.add("Michelle");
    set2.add("Ryan");

    union(set1,set2);
    difference(set1,set2);
    intersection(set1,set2);
  
  }

  public static void union(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    LinkedHashSet<String> setClone = new LinkedHashSet<String>(set1);
    setClone.addAll(set2);
    System.out.println("The union of the 2 sets is: ");
    System.out.println(setClone);
    System.out.println();
  }

  public static void difference(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    LinkedHashSet<String> setClone = new LinkedHashSet<String>(set1);
    setClone.removeAll(set2);
    System.out.println("The difference of the 2 sets is: ");
    System.out.println(setClone);
    System.out.println();
    
  }

  public static void intersection(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
    LinkedHashSet<String> setClone = new LinkedHashSet<String>(set1);
    setClone.addAll(set1);
    setClone.retainAll(set2);
    System.out.println("The intersection between the 2 sets is: ");
    System.out.println(setClone);
    System.out.println();
  }

}
