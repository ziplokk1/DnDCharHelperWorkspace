package armor;

import res.Tools;
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
	private String[] basics = new String[8];
	
	public Armor(String armorName) { 
		name = armorName;
		basics[0] = name;
	}
	
	public String[] getBasics() { 
		return basics;
	}
	
	public String getName() { 
		return name;
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
		basics[1] = c.getAmountAndType();
	}
	
	public Currency getCost() { 
		return cost;
	}
	
	public void setArmorBonus(int i) { 
		armorBonus = i;
		basics[2] = "+" + Integer.toString(armorBonus);
	}
	
	public int getArmorBonus() { 
		return armorBonus;
	}
	
	public void setMaxDexBonus(int i) { 
		maxDexBonus = i;
		basics[3] = "+" + Integer.toString(getMaxDexBonus());
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
		if(this.getArmorCheckPenalty() > 0) { 
			basics[4] = "-" + Integer.toString(this.getArmorCheckPenalty());
		} else { 
			basics[4] = Integer.toString(this.getArmorCheckPenalty());
		}
	}
	
	public int getArmorCheckPenalty() { 
		return armorCheckPenalty;
	}
	
	public void setArcaneSpellFailure(double i) { 
		arcaneSpellFailure = i;
		basics[5] = Tools.convertDeciToPercent(this.getArcaneSpellFailure());
	}
	
	public double getArcaneSpellFailure() { 
		return arcaneSpellFailure;
	}
	
	public void setSpeed(int i) { 
		speed = i;
		basics[6] = Integer.toString(this.getSpeed()) + " ft.";
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
		basics[7] = Integer.toString(this.getWeight()) + " lbs.";
	}
	
	public int getWeight() { 
		return weight;
	}
	
	
}

