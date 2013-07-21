package item;

import res.Money.Currency;

public class Item {
	private int weight;
	private Currency cost;
	private String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, Currency cost, int weight) { 
		this.name = name;
		this.weight = weight;
		this.cost = cost;
	}
	
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
