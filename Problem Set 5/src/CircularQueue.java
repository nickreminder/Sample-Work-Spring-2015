// Nicholas Reminder
// cs62 ps5, 3-10-15
// nicholas.reminder@pomona.edu

public class CircularQueue<E> {
	E[] data;
	int capacity;
	int size;
	int front;
	int back;
	
	public CircularQueue(int n) {
		data = (E[])new Object[n];
		capacity = n;
		size = 0;
		front = 0;
		back = 0;
	}
	
	public boolean offer(E e) {
		if (size == data.length) return false;
		else {
			data[back] = e;
			size++;
			back = (back + 1) % capacity;
		}
		return true;
	}
	
	public E peek() {
		if (size == 0) return null;
		else return data[front];
	}
	
	public E poll() {
		if (size == 0) return null;
		E temp = data[front];
		data[front] = null;
		front = (front + 1) % capacity;
		size--;
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	
	boolean isFull() {
		return size==capacity;
	}
	
	public String toString() {
		String s = "[";
		for (int i = front; i != back; i = (i+1)%capacity) {
			s = s+(data[i]);
			if (i != back-1) s = s+(", ");
		}
		s = s+("]");
		return s;
	}
	
}
