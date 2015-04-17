// Nick Reminder
// CS 62 Prof. Sun, PS1 1/27/15
// nicholas.reminder@pomona.edu

import java.text.*;

public class Item {

	private String name;
	private double price;
	private int bulkQuantity;
	private double bulkPrice;
	
// Here are my two item constructors. For items without bulk deals,
// I arbitrarily assign negative values to bulkQuantity and bulkPrice
// so that later I can easily determine whether I'm dealing with an 
// item that offers a bulk discount by >/< 0 comparison.
	
	public Item(String name, double price) {
		if (price < 0) throw new IllegalArgumentException("Price must be greater than 0."); 
		this.name = name;
		this.price = price;
		this.bulkQuantity = -5;
	}
	
	public Item(String name, double price, int bulkQuantity, double bulkPrice) {
		if ((price < 0) || (bulkQuantity < 0) || (bulkPrice < 0)) {
			throw new IllegalArgumentException("Prices and quantity must be greater than 0.");
		}
		this.name = name;
		this.price = price;
		this.bulkQuantity = bulkQuantity;
		this.bulkPrice = bulkPrice;
	}

// Recursion here in priceFor, only for price checks on items that have bulk
// deals and one is checking for a quantity greater than bulk quantity.
	
	public double priceFor(int quantity) {
		if (quantity < 0) throw new IllegalArgumentException("Quantity must be positive.");
		else if ((bulkQuantity > 0) && (quantity >= bulkQuantity)) return bulkPrice + priceFor(quantity - bulkQuantity);
		else return (quantity*price);
	}
	
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String priceString = nf.format(price);
		String bpriceString = nf.format(bulkPrice);
		if (bulkQuantity > 0) return (name + ", " + priceString + " (" + bulkQuantity + " for " + bpriceString + ")");
		else return (name + ", " + priceString);
	}
		
}
