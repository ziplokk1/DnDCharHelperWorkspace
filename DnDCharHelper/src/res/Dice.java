package res;

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
}
