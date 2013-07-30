package res;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6170611813496417260L;
	private int qty;
	private int sides;
	
	/*
	 * Quantity of dice and number of faces
	 */
	public Dice(int quantity, int faces) { 
		qty = quantity;
		sides = faces;
	}
	
	/*
	 * returns a string that is in the format of (xdy)
	 * example: two d10s would show as 2d10;
	 */
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
