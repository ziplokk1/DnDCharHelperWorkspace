package res;

import java.util.Random;

public class Dice {
	private int qty;
	private int sides;
	
	public Dice(int quantity, int faces) { 
		qty = quantity;
		sides = faces;
	}
	
	public String getDie() { 
		if(sides == 1) { 
			return "1";
		} else if (sides == 0) { 
			return "-";
		} else {
			return Integer.toString(qty) + "d" + Integer.toString(sides);
		}
	}
	
	public int getFaces() { 
		return sides;
	}
	
	public int getQuantity() { 
		return qty;
	}
	
	public int rollDie() { 
		int rollTotal = 0;
		for(int i = 0; i < qty; i++) { 
			Random r = new Random();
			int roll = r.nextInt(sides) + 1;
			rollTotal += roll;
		}
		return rollTotal;
	}
}
