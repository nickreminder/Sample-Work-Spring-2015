// Nicholas Reminder 2-23-15
// cs62 ps4
// nicholas.reminder@pomona.edu

import java.util.*;

public class TestMyDLinkedList {
  public static void main(String[] args) {
    testList();
    System.out.println();
    testHasNextNext();
    System.out.println();
    testConstructors();
    System.out.println();
    testNextIndex();
    System.out.println();
    testHasPreviousPrevious();
    System.out.println();
    testPreviousIndex();
    System.out.println();
    testAdd();
    System.out.println();
    testSet();
    System.out.println();
    testRemove();
    System.out.println();
    testBigOh();
  }

  public static void testList() {  
    System.out.println("<< Testing normal list functionality >> ");

    List<String> slist = new MyDLinkedList<>();
    List<Integer> ilist = new MyDLinkedList<>();
    System.out.println("The list: " + slist);
    System.out.println("list size: " + slist.size());
    System.out.println("is it empty? " + slist.isEmpty());
    
    System.out.println("adding one element");
    slist.add("hello");

    System.out.println("The list: " + slist);
    System.out.println("list size: " + slist.size());
    System.out.println("is it empty? " + slist.isEmpty());
    
    System.out.println("removing one element");
    slist.remove(0);

    System.out.println("The list: " + slist);
    System.out.println("list size: " + slist.size());
    System.out.println("is it empty? " + slist.isEmpty());
    
    System.out.println("adding many elements");
    for (int i = 0; i < 10; i++) {
      ilist.add(new Integer(i*i));
      System.out.println("The list: " + ilist);
    }
    
    System.out.println("The list: " + ilist);
    System.out.println("list size: " + ilist.size());
    System.out.println("is it empty? " + ilist.isEmpty());

    System.out.println("element 5: " + ilist.get(5));

    System.out.println("setting element 7");
    ilist.set(7, new Integer(999));
    System.out.println("The list: " + ilist);

    System.out.println("inserting some elements");
    ilist.add(2, new Integer(222));
    ilist.add(7, new Integer(777));
    ilist.add(4, new Integer(444));
    System.out.println("The list: " + ilist);

    System.out.println("Index of 81? " + ilist.indexOf(new Integer(81)));
    System.out.println("Index of 10? " + ilist.indexOf(new Integer(10)));

    System.out.println("Is 64 in the list? " + ilist.contains(new Integer(64)));
    System.out.println("Is 10 in the list? " + ilist.contains(new Integer(10)));
    
    System.out.println("Removing alternating first and last elements:");
    while (ilist.size() > 6) {
      if (ilist.size() % 2 == 0)
        ilist.remove(0);
      else
        ilist.remove(ilist.size() - 1);

      System.out.println("The list: " + ilist);
    }
    
    System.out.print("toArray: ");
    System.out.println(Arrays.asList(ilist.toArray()));
  }

  public static void testHasNextNext() {
    System.out.println("<< Testing hasNext/next >>");
    List<Integer> list = getList();
    System.out.println("should get:  " + list);
    System.out.print("actually got: ");

    for (Iterator<Integer> i = list.iterator(); i.hasNext(); )
      System.out.print(i.next() + ", ");
    System.out.println();

    // check for advancing hasNext()
    System.out.print("actually got: ");
    for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
      i.hasNext();
      i.hasNext();
      System.out.print(i.next() + ", ");
    }
    System.out.println();
  }

  protected static List<Integer> getList() {
    List<Integer> list = new MyDLinkedList<>();
    // toArray 1: [4, 444, 9, 16, 25, 777]
    list.add(new Integer(4));
    list.add(new Integer(444));
    list.add(new Integer(9));
    list.add(new Integer(16));
    list.add(new Integer(25));
    list.add(new Integer(777));
    return list;
  }

  public static void testConstructors() {
    System.out.println("<< Testing listIterator constructors >>");
    List<Integer> list = getList();
    System.out.print("Entire list:  ");
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); )
      System.out.print(i.next() + " ");
    System.out.println();
    System.out.print("list at index 3: ");
    for (ListIterator<Integer> i = list.listIterator(3); i.hasNext(); )
      System.out.print(i.next() + " ");
    System.out.println();
    System.out.print("list at index 1: ");
    for (ListIterator<Integer> i = list.listIterator(1); i.hasNext(); )
      System.out.print(i.next() + " ");
    System.out.println();
  }

  public static void testNextIndex() {
    System.out.println("<< Testing nextIndex >>");
    List<Integer> list = getList();
    System.out.print("Entire list:     ");
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); )
      System.out.print(i.nextIndex() + ":" + i.next() + " ");
    System.out.println();
    System.out.print("list at index 0: ");
    for (ListIterator<Integer> i = list.listIterator(0); i.hasNext(); )
      System.out.print(i.nextIndex() + ":" + i.next() + " ");
    System.out.println();
    System.out.print("list at index 3: ");
    for (ListIterator<Integer> i = list.listIterator(3); i.hasNext(); )
      System.out.print(i.nextIndex() + ":" + i.next() + " ");
    System.out.println();
    System.out.print("list at index size-1: ");
    for (ListIterator<Integer> i = list.listIterator(list.size()-1); i.hasNext(); )
      System.out.print(i.nextIndex() + ":" + i.next() + " ");
    System.out.println();
  }

  public static void testHasPreviousPrevious() {
    System.out.println("<< Testing hasPrevious/previous >>");
    List<Integer> list = getList();

    System.out.println("Entire list: " + list);
    System.out.print("Reverse list:  ");
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); )
      System.out.print(i.previous() + " ");
    System.out.println();
    System.out.print("Reverse list at index 3: ");
    for (ListIterator<Integer> i = list.listIterator(3); i.hasPrevious(); )
      System.out.print(i.previous() + " ");
    System.out.println();
    System.out.print("Reverse list at index 0: ");
    for (ListIterator<Integer> i = list.listIterator(0); i.hasPrevious(); )
      System.out.print(i.previous() + " ");
    System.out.println();

    // test for advancing hasPrevious
    System.out.println("Entire list: " + list);
    System.out.print("Reverse list:  ");
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); ) {
      i.hasPrevious();
      i.hasPrevious();
      System.out.print(i.previous() + " ");
    }
    System.out.println();
  }

  public static void testPreviousIndex() {
    System.out.println("<< Testing previousIndex >>");
    List<Integer> list = getList();

    System.out.println("Entire list: " + list);
    System.out.print("Reverse list:  ");
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); )
      System.out.print(i.previousIndex() + ":" + i.previous() + " ");
    System.out.println();
    System.out.print("Reverse list at index 3: ");
    for (ListIterator<Integer> i = list.listIterator(3); i.hasPrevious(); )
      System.out.print(i.previousIndex() + ":" + i.previous() + " ");
    System.out.println();
    System.out.print("Reverse list at index 0: ");
    for (ListIterator<Integer> i = list.listIterator(0); i.hasPrevious(); )
      System.out.print(i.previousIndex() + ":" + i.previous() + " ");
    System.out.println();
  }

  public static void testAdd() {
    System.out.println("<< Testing add forwards >>");
    List<Integer> list = getList();
    
    System.out.println("before adding:                 " + list);
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      i.next();
      i.add(new Integer(99));
    }
    System.out.println("added 99, every other element: " + list);

    list = getList();
    System.out.println("before adding:                  " + list);
    for (ListIterator<Integer> i = list.listIterator(3); i.hasNext(); ) {
      i.add(new Integer(11));
      i.next();
    }
    System.out.println("added 11, index 3, every other: " + list);

    // using iterator (backwards) to add an 888 before every element
    System.out.println("<< Testing add backwards >>");
    list = getList();
    System.out.println("before adding:    " + list);
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); ) {
      Object onext = i.previous();
      if (onext != null) {
        i.add(new Integer(888));
        i.previous();
      }
    }
    System.out.println("After adding 888: " + list);
  }

  public static void testSet() {
    System.out.println("<< Testing set forwards >>");
    List<Integer> list = getList();
    System.out.println("before set forwards:             " + list);
    System.out.print("set forwards, even numbers to 0: ");
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      Integer next = (Integer)i.next();
      if (next.intValue() % 2 == 0)
        i.set(new Integer(0));
    }
    System.out.println(list);

    list.add(0, new Integer(1));
    System.out.println("before set backwards:            " + list);
    System.out.print("set backwards, odd numbers+1000: ");
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); ) {
      Integer next = (Integer)i.previous();
      if (next.intValue() % 2 != 0)
        i.set(new Integer(next.intValue() + 1000));
    }
    System.out.println(list);
  }

  public static void testRemove() {
    System.out.println("<< Testing remove forwards >>");

    List<Integer> list = getList();
    System.out.println("before:                   " + list);

    System.out.print("after remove odd numbers: ");
    // remove every odd-valued element
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      Integer onext = i.next();
      if (onext != null) {
        if (onext.intValue() % 2 == 1)
          i.remove();
      }
    }
    System.out.println(list);

    System.out.println("<< Testing remove backwards >>");

    list = getList();
    System.out.println("before:                    " + list);

    System.out.print("after remove even numbers: ");
    // using iterator (backwards) to remove every even-valued element
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); ) {
      Integer onext = i.previous();
      if (onext != null) {
        if (onext.intValue() % 2 == 0)
          i.remove();
      }
    }
    System.out.println(list);
  }

  private static List<Integer> createList(int size) {
    List<Integer> list = new MyDLinkedList<Integer>();
    
    // fill it with random data in [0, size]
    for (int i = 0; i < size; i++)
      list.add(new Integer((int)(Math.random() * size)));
    
    return list;
  }

  private static long timedHasNextLoop(List<Integer> list) {
    long startTime = System.currentTimeMillis();
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      i.hasNext();
      i.nextIndex();
      i.nextIndex();
      i.next();
      i.next();
    }
    return System.currentTimeMillis() - startTime;
  }

  private static long timedHasPreviousLoop(List<Integer> list) {
    long startTime = System.currentTimeMillis();
    for (ListIterator<Integer> i = list.listIterator(list.size()); i.hasPrevious(); ) {
      i.hasPrevious();
      i.previousIndex();
      i.previousIndex();
      i.previous();
      i.previous();
    }
    return System.currentTimeMillis() - startTime;
  }

  private static long timedAddRemoveSetLoop(List<Integer> list) {
    long startTime = System.currentTimeMillis();
    for (ListIterator<Integer> i = list.listIterator(); i.hasNext(); ) {
      i.next();
      i.set(new Integer(0));
      if (i.hasNext()) {
        i.next();
        i.remove();
      }
      i.add(new Integer(1));
    }
    return System.currentTimeMillis() - startTime;
  }

  private static void bigOhCheck(long time1, long time2) {
    // System.out.println(time1 + " " + time2);
    double timeRatio = 1.0 * time2 / time1;
    if (timeRatio < 4.0)
      System.out.println("probable pass");
    else
      System.out.println("probable fail");
  }

  public static void testBigOh() {
    System.out.println("<< Testing Big-O of hasNext, next, nextIndex >>");
    System.out.print("Big-O hasNext, next, nextIndex: ");
    int size = 10000;
    List<Integer> list1 = createList(size);
    List<Integer> list2 = createList(2*size);
    bigOhCheck(timedHasNextLoop(list1), timedHasNextLoop(list2));

    System.out.print("Big-O hasPrevious, previous, previousIndex: ");
    bigOhCheck(timedHasPreviousLoop(list1), timedHasPreviousLoop(list2));

    System.out.print("Big-O add, remove, set: ");
    bigOhCheck(timedAddRemoveSetLoop(list1), timedAddRemoveSetLoop(list2));
  }
}