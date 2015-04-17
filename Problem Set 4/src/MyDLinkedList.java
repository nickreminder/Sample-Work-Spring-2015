// Nicholas Reminder 2-23-15
// cs62 ps4
// nicholas.reminder@pomona.edu

/**
 * implement a ListIterator for the DLinkedList<E> class
 */

import java.util.*;

public class MyDLinkedList<E> extends DLinkedList<E> {

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    // the list iterator
    private class MyListIterator implements ListIterator<E> {

        // TODO: add any fields needed for the list iterator
    	int cursor;
    	ListNode<E> rholder;
    	ListNode<E> nopCallPointer;
    
    	/**
    	 * The constructor for the MyListIterator class that starts
    	 *  the iterator at "index"
    	 * @param an integer, index
    	 */
    	public MyListIterator(int index) {
    	    if (index < 0 || index > size()) {
                throw new IndexOutOfBoundsException("index: " + index);
    	    }
            // TODO: complete constructor
    	    nopCallPointer = null;
    	    cursor = 0;
    	    rholder = front.next;
    	    while (cursor != index) {
    	    	rholder = rholder.next;
    	    	cursor++;
    	    }
    	}
    
        // TODO: implement the methods of the ListIterator interface
        //       all the methods must run in Theta(1)
    	public void add(E data) {
    		ListNode<E> insert = new ListNode<E>(data, rholder, rholder.prev);
    		rholder.prev.next = insert;
    		rholder.prev = insert;
    		size++;
    		cursor++;
    		nopCallPointer = null;
    	}
    	
    	public boolean hasNext() { return (size > cursor); 	}
    	public boolean hasPrevious() { return (cursor > 0); 	}
    	
    	public E next() {
    		if (!hasNext()) throw new IndexOutOfBoundsException("You're at the end of the list."); 
    		cursor++;
    		nopCallPointer = rholder;
    		E data = rholder.data;
    		rholder = rholder.next;
    		return data;
    	}
    	public int nextIndex() { return cursor; 	}
    	
    	public E previous() {
    		if (!hasPrevious()) throw new IndexOutOfBoundsException("You're at the beginning of the list.");
    		cursor--;
    		rholder = rholder.prev;
    		nopCallPointer = rholder;
    		return rholder.data;
    	}
    	public int previousIndex() { return cursor-1; 	}
    	
    	public void remove() {
    		if (nopCallPointer == null) throw new IllegalStateException("You need to call next or prev first.");
    		nopCallPointer.prev.next = nopCallPointer.next;
    		nopCallPointer.next.prev = nopCallPointer.prev;
    		if (rholder == nopCallPointer) { rholder = rholder.next; } else cursor--;
    		nopCallPointer = null;
    		size--;
    	}
    	
    	public void set(E data) {
    		if (nopCallPointer == null) throw new IllegalStateException("You need to call next or prev first.");
    		ListNode<E> insert = new ListNode<E>(data, nopCallPointer.next, nopCallPointer.prev);
    		nopCallPointer.next.prev = insert;
    		nopCallPointer.prev.next = insert;
    		nopCallPointer = null;
    	}
    	
    }
    
}