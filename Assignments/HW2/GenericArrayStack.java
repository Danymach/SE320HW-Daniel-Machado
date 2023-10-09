package Assignments.HW2;

public class GenericArrayStack<E> {

  // ----------- Attributes -----------//

  // Array is of Type Object, but we check the type of the input before we add it
  // here
  // Can this be static?
  public Object array[];

  // Top: Keeps up with the top of the stack - Value we will pop, and the latest
  // value pushed. Starts at -1 because when we push the first value, it will be
  // saved at index 0.
  private int top = -1;
  public int sizeOfArray;
  int DEFAULT_SIZE = 1;

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
    // Top + 1 because top starts at 0.
    // This means I am checking after pushing the array will be full. If this is the
    // case then I make the array bigger in advance.
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

  public static void main(String args[]) {
    GenericArrayStack<Integer> hey = new GenericArrayStack<Integer>();
    System.out.println("Size: " + hey.sizeOfArray);
    System.out.println(hey.top);
    System.out.println(hey.getSize());
    System.out.println(hey.isEmpty());
    Integer item0 = 0;
    Integer item1 = 1;
    Integer item2 = 2;
    Integer item3 = 3;
    Integer item4 = 4;
    Integer item5 = 5;
    hey.push(item0);
    System.out.println(hey.isEmpty());
    System.out.println(hey.getSize());
    hey.push(item1);
    hey.push(item2);
    hey.push(item3);
    hey.push(item4);
    hey.push(item5);
    System.out.println(hey.peek());
    System.out.println(hey.pop());
    System.out.println(hey.pop());
    System.out.println(hey.pop());
    System.out.println(hey.pop());
    System.out.println(hey.pop());
    System.out.println(hey.pop());
    System.out.println(hey.getSize());
    System.out.println(hey.isEmpty());
    System.out.println("Size of Stack: " + hey.getSize());
  }
}
