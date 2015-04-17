// Nick Reminder
// CS 62 Prof. Sun, PS1 1/27/15
// nicholas.reminder@pomona.edu

import java.util.*;

// This class is pretty simple and self-explanatory. Just creating an
// ArrayList framework to hold the item collection of the catalog.

public class Catalog {
	
	private String name;
	private ArrayList<Item> catalog;
	
	public Catalog(String name) {
		this.name = name;
		this.catalog = new ArrayList<Item>();
	}
	
	public void add(Item item) {
		catalog.add(item);
	}
	
	public int size() {
		return catalog.size();
	}
	
	public Item get(int index) {
		return catalog.get(index);
	}
	
	public String getName() {
		return name;
	}
	
}
