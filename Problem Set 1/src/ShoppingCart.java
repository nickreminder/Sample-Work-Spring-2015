// Nick Reminder
// CS 62 Prof. Sun, PS1 1/27/15
// nicholas.reminder@pomona.edu

import java.util.*;

public class ShoppingCart {
	
	private ArrayList<ItemOrder> shoppingcart;
	private boolean discount;
	
	public ShoppingCart() {
		this.shoppingcart = new ArrayList<ItemOrder>();
		discount = false;
	}
	
// In add, I go through the list to see if there is already
// an order for the item. If so, my index placeholder becomes
// the index of the previous order. At the end, if that index
// is greater than zero, I remove that index. 
	
	public void add(ItemOrder order) {
		Item itemOrderItem = order.getItem();
		int indexOfItem = -1;
		for (int i = 0; i < shoppingcart.size(); i++) {
			if (shoppingcart.get(i).getItem() == itemOrderItem) {
				indexOfItem = i;
			}
		}
		if (indexOfItem > 0) shoppingcart.remove(indexOfItem);
		shoppingcart.add(order);
	}
	
	public void setDiscount(boolean a) {
		discount = a;
	}

// None of these classes were quite hard in themselves,
// although together, the layering of these objects kept
// me on my toes. It helped to have organized code. I had
// fun with this assignment.
	
	public double getTotal() {
		double total = 0;
		for (int i = 0; i < shoppingcart.size(); i++) {
			total = total + shoppingcart.get(i).getPrice();
		}
		if (discount == true) return (total*.9);
		else return total;
	}
}
