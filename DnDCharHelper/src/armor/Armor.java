package armor;

import res.Money.Currency;

public class Armor {
	private boolean canRunAtQuadSpeed = true;
	private boolean handNotFreeToCastSpells = false;
	private Currency cost;
	private String name;
	private int armorBonus;
	private int maxDexBonus;
	private int armorCheckPenalty;
	private double arcaneSpellFailure;
	private int speed;
	private int weight;
	
	public Armor(String armorName) { 
		name = armorName;
	}
	
	public void setHandNotFreeToCastSpells(boolean b) { 
		handNotFreeToCastSpells = b;
	}
	
	public boolean getHandNotFreeToCastSpells() { 
		return handNotFreeToCastSpells;
	}
	
	public void setCanRunAtQuadSpeed(boolean b) { 
		canRunAtQuadSpeed = b;
	}
	
	public boolean getCanRunAtQuadSpeed() { 
		return canRunAtQuadSpeed;
	}
	
	public void setCost(Currency c) { 
		cost = c;
	}
	
	public Currency getCost() { 
		return cost;
	}
	
	public void setArmorBonus(int i) { 
		armorBonus = i;
	}
	
	public int getArmorBonus() { 
		return armorBonus;
	}
	
	public void setMaxDexBonus(int i) { 
		maxDexBonus = i;
	}
	
	public int getMaxDexBonus() { 
		if(maxDexBonus == -10) { 
			return 0;
		} else {
			return maxDexBonus;
		}
	}
	
	public void setArmorCheckPenalty(int i) { 
		armorCheckPenalty = i;
	}
	
	public int getArmorCheckPenalty() { 
		return armorCheckPenalty;
	}
	
	public void setArcaneSpellFailure(double i) { 
		arcaneSpellFailure = i;
	}
	
	public double getArcaneSpellFailure() { 
		return arcaneSpellFailure;
	}
	
	public void setSpeed(int i) { 
		speed = i;
	}
	
	public int getSpeed() {
		if(speed == -10) { 
			return 0;
		} else { 
			return speed;
		}
	}
	
	public void setWeight(int i) { 
		weight = i;
	}
	
	public int getWeight() { 
		return weight;
	}
	
	
}

