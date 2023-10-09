package Assignments.HW2;

public class GenericArrayStack<E> {

  // ----------- Attributes -----------//

  // Array is of Type Object, but we check the type of the input before we add it
  // here
  // Can this be static?
  private Object array[];

  // Top: Keeps up with the top of the stack - Value we will pop, and the latest
  // value pushed. Starts at -1 because when we push the first value, it will be
  // saved at index 0.
  private int top = -1;
  private int sizeOfArray;
  private int DEFAULT_SIZE = 1;

  // ----------- Constructors -----------//

  // Constructor1
  public GenericArrayStack(int sizeOfArray) {
    if (sizeOfArray <= 0) {
      sizeOfArray = 5;
    }
    this.sizeOfArray = sizeOfArray;
    this.array = new Object[sizeOfArray];
  }

  // Constructor2
  public GenericArrayStack() {
    this.sizeOfArray = DEFAULT_SIZE;
    this.array = new Object[sizeOfArray];
  }

  // ----------- Methods -----------//

  public void push(E value) {
    // Top + 1 to check before the array gets full.
    // If array is full I can increase it in advance
    System.out.println("Top before:" + top);
    top++;
    if ((top + 1) == sizeOfArray) {
      increaseArray();
    }

    array[top] = value;
    System.out.println("Top after:" + top);
  }

  private void increaseArray() {
    sizeOfArray *= 2;
    Object biggerArray[] = new Object[sizeOfArray];
    copyArray(biggerArray);
  }

  private void copyArray(Object[] biggerArray) {
    for (int i = 0; i < array.length; i++) {
      biggerArray[i] = array[0];
    }
    array = biggerArray;
  }

  public E peek() {
    return (E) array[top];
  }

  public E pop() throws ArrayIndexOutOfBoundsException {
    E itemPopped = (E) array[top];
    array[top] = null;
    top--;
    System.out.println("Top after popping: " + top);
    return itemPopped;
  }

  public int getSize() {
    return top + 1;
  }

  public boolean isEmpty() {
    boolean empty = false;

    if (top > -1) {
      empty = false;
    } else {
      empty = true;
    }
    return empty;
  }

}
