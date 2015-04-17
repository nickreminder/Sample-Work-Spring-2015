// Nicholas Reminder
// cs62 ps5, 3-10-15
// nicholas.reminder@pomona.edu

/**
 * test the circular queue
 */
import java.util.Arrays;

public class TestCircularQueue {
   public static void main(String[] args) {
      CircularQueue<String> theQueue = new CircularQueue<>(8); 
      String[] strHouses = {"Gryffindor", "Slytherin","Hufflepuff","Ravenclaw"};
      String[] strPrincessBride = {"Buttercup", "Westley", "Humperdinck", "Inigo Montoyo", "Fezzik", "Vizzini","Count Rugen" }; 
 
      // put some strings into the queue
      for (String str : strPrincessBride) {
    	  theQueue.offer(str);
      }
      System.out.println("Queue size should be 7, size = " + theQueue.size());
      System.out.println("theQueue should be: " + Arrays.toString(strPrincessBride));
	  System.out.println("theQueue: " + theQueue);
 
	  // now take some out
	  int sz = theQueue.size();
      for (int i = 0; i < sz; i++) {
    	  String s = theQueue.poll();
      }
      System.out.println("Queue size should be 0, size = " + theQueue.size());
      System.out.println("theQueue should be empty" );
	  System.out.println("theQueue: " + theQueue);
	  System.out.println("poll should return null, got: " + theQueue.poll());

	  // put some more in
      for (String str : strHouses) {
    	  theQueue.offer(str);
      }
      System.out.println("Queue size should be 4, size = " + theQueue.size());
      System.out.println("theQueue should be: " + Arrays.toString(strHouses));
	  System.out.println("theQueue: " + theQueue);
	  System.out.println("peek should return Gryffindor, got: " + theQueue.peek());
   }
}
