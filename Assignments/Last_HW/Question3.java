package Last_HW;

public class Question3 {
  public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
    int i = 0;
    for (E item : list) {
      if (item == key) {
        return i;
      }
      i++;
    }
    return -1;
  }

  public static void main(String[] args) {
    Integer[] list = { 3, 4, 5, 1, -3, -5, -1 };
    System.out.println(linearSearch(list, 2));
    System.out.println(linearSearch(list, 5));
  }
}
