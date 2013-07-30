package item;

import java.io.Serializable;

import res.Money.Currency;

public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4258516407925509566L;
	private int weight;
	private Currency cost;
	private String name;
	private int quantity;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, Currency cost, int weight) { 
		this.name = name;
		this.weight = weight;
		this.cost = cost;
	}
	
	public void setQuantity(int i) { quantity = i; } 
	public int getQuantity() { return quantity; }
	
	public String getName() { 
		return name;
	}
	
	public Currency getCost() { 
		return cost;
	}
	
	public int getWeight() { 
		return weight;
	}
	
	public void setCost(Currency currency) { 
		this.cost = currency;
	}
	
	public void setWeight(int weight) { 
		this.weight = weight;
	}
}
