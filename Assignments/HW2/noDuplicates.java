// Credit to: https://www.geeksforgeeks.org/set-in-java/
package Assignments.HW2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class noDuplicates {
  public static void main(String args[]) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(14);
    list.add(42);
    list.add(25);

    ArrayList<Integer> newList = removeDuplicates(list);
    System.out.print(newList);
  }

  public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
    Set<E> noDuplicatesSet = new HashSet<>();
    ArrayList<E> listCopy = new ArrayList<>();
    ArrayList<E> listFinal = new ArrayList<>();

    // Copy original list into another list to do operations on it
    listCopy.addAll(list);

    // Add every value into a Set to remove the duplicates
    int index = 0;
    for (E item : list) {
      noDuplicatesSet.add(listCopy.remove(index));
    }

    // Add every item into an empty list
    for (E item : noDuplicatesSet) {
      listFinal.add(item);
    }

    return listFinal;
  }
}
