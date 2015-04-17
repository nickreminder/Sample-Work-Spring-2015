// Nicholas Reminder 2-23-15
// cs62 ps4
// nicholas.reminder@pomona.edu

import java.util.*;

public class TestDLinkedList {
  public static void main(String[] args) {
    testList();
    System.out.println();
    testHasNextNext();
  }

  public static void testList() {  
    System.out.println("<< Testing normal list functionality >> ");

    List<String> slist = new DLinkedList<>();
    List<Integer> ilist = new DLinkedList<>();
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
    List<Integer> list = new DLinkedList<>();
    // toArray 1: [4, 444, 9, 16, 25, 777]
    list.add(new Integer(4));
    list.add(new Integer(444));
    list.add(new Integer(9));
    list.add(new Integer(16));
    list.add(new Integer(25));
    list.add(new Integer(777));
    return list;
  }

}