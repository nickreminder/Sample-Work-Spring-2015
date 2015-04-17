// Nicholas Reminder 2-23-15
// cs62 ps4
// nicholas.reminder@pomona.edu

/**
 * a generic doubly linked list implementation with dummy nodes at the front and back of the list
 */

import java.util.*;

public class DLinkedList<E> extends AbstractCollection<E> implements List<E> {
    protected ListNode<E> front;  // first value in the list
    protected ListNode<E> back;   // last value in the list
    protected int size;           // current number of elements

    // the list node (static since it doesn't access enclosing object's state)
    protected static class ListNode<E> {
        public E data;         // data stored in this node
        public ListNode<E> next;  // link to next node in the list
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    // post: constructs an empty list
    public DLinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> ref = front.next;
        for(int i=0; i<index; i++) {
        	ref = ref.next;
        }
        return ref.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(Object value) {
        ListNode<E> ref = front.next;
        for (int i=0; i<size; i++) {
        	if (ref.data.equals(value)) return i;
        	ref = ref.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(Object value) {
        return (indexOf(value) >= 0);
    }

    // post: appends the given value to the end of the list
    public boolean add(E value) {
        add(size, value);
        return true;
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        if (size==0) {
        	ListNode<E> insert = new ListNode<E>(value, back, front);
        	back.prev = insert; front.next = insert;
        }
        else {
        	ListNode<E> ref = front.next;
        	for (int i=0; i<index; i++) ref = ref.next;
        	ListNode<E> insert = new ListNode<E>(value, ref, ref.prev);
        	ref.prev.next = insert;
        	ref.prev = insert;
        }
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public E remove(int index) {
        checkIndex(index);
        ListNode<E> ref = front.next;
        for (int i=0; i<index; i++) ref = ref.next;
        ref.next.prev = ref.prev;
        ref.prev.next = ref.next;
        size--;
        return ref.data; 
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public E set(int index, E value) {
        checkIndex(index);
        ListNode<E> ref = front.next;
        for (int i=0; i<index; i++) ref = ref.next;
        ListNode<E> insert = new ListNode<E>(value, ref.next, ref.prev);
        ref.next.prev = insert;
        ref.prev.next = insert;
        return ref.data;
    }

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    protected ListNode<E> nodeAt(int index) {
        if (index < 0 || index >= size()) return null;
        ListNode<E> ref;
        boolean startFr;
        if (index <= size()/2) { ref = front.next; startFr = true; }
        	else { ref = back.prev; startFr = false; }
        int lpoint = 0; int rpoint = size();
        while (startFr == true && lpoint < index) {
        	ref = ref.next; lpoint++;
        }
        while (startFr == false && rpoint >= index) {
        	ref = ref.prev; rpoint--;
        }
        return ref;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // the iterator (non-static since it access's state of the enclosing object
    private class LinkedIterator implements Iterator<E> {
        boolean removeOK;  // whether it's ok to remove
        ListNode<E> place;
        int index;

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            removeOK = true;
            place = front.next;
            index = 0;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return (size > index);
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = place.data;
            place = place.next;
            index++;
            removeOK = true;
            return data;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> holder = place.prev;
            place.prev.next = place.next;
            place.next.prev = holder;
            removeOK = false;
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public int lastIndexOf(Object arg0) {
        throw new UnsupportedOperationException(); 
    }

    @Override
    public List<E> subList(int arg0, int arg1) {
        throw new UnsupportedOperationException(); 
    }

    // static nested class for debugging (change on to true to enable debug printing)
    protected static class Debug {
        public static final boolean on = false;
    
        public static void print( String s ) {
            if (on) System.out.println(s);
        }
    }

}