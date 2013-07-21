package armor;

import item.Item;
import res.Tools;
import res.Money.Currency;

public class Armor extends Item {
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
	
	/*
	 * Used to generate labels faster in the ArmorGUI class
	 */
	private String[] basics = new String[8];
	
	public Armor(String armorName) { 
		super(armorName);
		name = armorName;
		basics[0] = name;
	}
	
	public String[] getBasics() { 
		return basics;
	}
	
	public String getName() { 
		return name;
	}
	
	/*
	 * Used only for shields.
	 * Indicates whether the players hand 
	 * cannot use spells with equipped shield.
	 */
	public void setHandNotFreeToCastSpells(boolean b) { 
		handNotFreeToCastSpells = b;
	}
	
	public boolean getHandNotFreeToCastSpells() { 
		return handNotFreeToCastSpells;
	}
	
	/*
	 * Used to determine how fast the player can sprint with equipped armor
	 * default is false. When param is true, player can only sprint at 3x speed.
	 */
	public void setCanRunAtQuadSpeed(boolean b) { 
		canRunAtQuadSpeed = b;
	}
	
	public boolean getCanRunAtQuadSpeed() { 
		return canRunAtQuadSpeed;
	}
	
	public void setCost(Currency c) { 
		cost = c;
		super.setCost(cost);
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
		
		/*
		 * Used only to convert armorCheckPenalty to a string
		 */
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
		super.setWeight(weight);
		basics[7] = Integer.toString(this.getWeight()) + " lbs.";
	}
	
	public int getWeight() { 
		return weight;
	}
	
	
}

