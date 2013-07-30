package weapons;

import java.util.ArrayList;
import java.util.List;

import item.Item;
import res.Dice;
import res.Money.Currency;

public class Weapon extends Item {
	/**
	 * 
	 */
	private static final long serialVersionUID = 88235821284540240L;
	private String name;
	private int CRITICAL;
	private int CRITICAL_MULTIPLIER;
	private int RANGE_INCREMENT;
	private String type;
	private int HARDNESS;
	private Currency cost;
	private Dice DAMAGE;
	private int WEIGHT;
	private int HP;
	private String size;
	
	private List<String> basics;
	
	public Weapon(String name0) { 
		super(name0);
		basics = new ArrayList<String>();
		this.name = name0;
	}
	
	public void setBasics() { 
		basics.add(this.getName());
		if(this.getCost().getAmount() == 0) { 
			basics.add("-");
		} else if (this.getCost().getAmount() == -1) { 
			basics.add("Special");
		} else {
			basics.add(this.getCost().getAmountAndType());
		}
		basics.add(this.getDamage(-1));
		basics.add(this.getCrits());
		basics.add(this.getRangeIncrement());
		basics.add(Integer.toString(this.getWeight()) + " lbs.");
		basics.add(this.getType());
	}
	
	public List<String> getBasics() { 
		return basics;
	}
	
	public String getSize() { 
		return size;
	}
	
	public void setSize(String size0) { 
		size = size0;
	}
	
	public void setCriticalMultiplier(int crit) { 
		CRITICAL_MULTIPLIER = crit;
	}
	
	public String getCriticalMultiplier() { 
		return "x" + Integer.toString(CRITICAL_MULTIPLIER);
	}
	
	public String getCrits() { 
		if(CRITICAL_MULTIPLIER != 0 && CRITICAL != 0) {
			return Integer.toString(CRITICAL) + 
					"-20/x" + Integer.toString(CRITICAL_MULTIPLIER);
		} else if (CRITICAL_MULTIPLIER == 0) { 
			return "-";
		} else if (CRITICAL_MULTIPLIER != 0 && CRITICAL == 0) { 
			return "x" + Integer.toString(CRITICAL_MULTIPLIER);
		} else { 
			return "ERR";
		}
	}
	
	public String getDamageVersus(String size) { 
		return "blank";
	}
	
	public void setHP(int hp) { 
		HP = hp;
	}
	
	public void setWeight(int weight) { 
		WEIGHT = weight;
		super.setWeight(WEIGHT);
	}
	
	public void setDamage(Dice die) { 
		DAMAGE = die;
	}
	
	public void setCost(Currency currency) { 
		cost = currency;
		super.setCost(cost);
	}
	
	public void setHardness(int hardness) { 
		HARDNESS = hardness;
	}
	
	public void setType(String type0) { 
		type = type0;
	}
	
	public void setRangeIncrement(int range) { 
		RANGE_INCREMENT = range;
	}
	
	public void setCritical(int crit) { 
		CRITICAL = crit;
	}
	
	public String getName() { 
		return name;
	}
	
	public int getCritical() { 
		return CRITICAL;
	}
	
	public String getRangeIncrement() { 
		if(RANGE_INCREMENT != 0) { 
			return Integer.toString(RANGE_INCREMENT);
		} else {
			return "-";
		}
	}
	
	public String getType() { 
		return type;
	}
	
	public int getHardness() { 
		return HARDNESS;
	}
	
	/*
	 * returns only the integer amount of the cost's currency.
	 */
	public int getAbsCost() { 
		return cost.getAmount();
	}
	
	/*
	 * Only used for GUI purposes
	 */
	public String getThisCost() { 
		if(getAbsCost() == 0) {
			return "-";
		} else if (getAbsCost() == -1) { 
			return "Special";
		} else { 
			return cost.getAmountAndType();
		}
	}
	
	/*
	 * Returns a string in the (xdy) format according to player size
	 * the smaller a player is, the less damage their weapon does, and vice versa.
	 */
	public String getDamage(int playerSize) { 
		
		int sizeMod = playerSize - 4;
		
		int faces = DAMAGE.getFaces();
		int qty = DAMAGE.getQuantity();
		Dice die = null;
		
		switch(sizeMod) { 
		case -4: //Fair
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 0);
					break;
				case 3:
					die = new Dice(1, 0);
					break;
				case 4:
					die = new Dice(1, 0);
					break;
				case 6:
					die = new Dice(1, 1);
					break;
				case 8:
					die = new Dice(1, 2);
					break;
				case 10:
					die = new Dice(1, 3);
					break;
				case 12:
					die = new Dice(1, 4);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(1, 2);
					break;
				case 6:
					die = new Dice(1, 4);
					break;
				case 8:
					die = new Dice(1, 6);
					break;
				case 10:
					die = new Dice(1, 8);
				}
				break;
			}
			break;
		case -3: //Diminuitive
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 0);
					break;
				case 3:
					die = new Dice(1, 0);
					break;
				case 4:
					die = new Dice(1, 1);
					break;
				case 6:
					die = new Dice(1, 2);
					break;
				case 8:
					die = new Dice(1, 3);
					break;
				case 10:
					die = new Dice(1, 4);
					break;
				case 12:
					die = new Dice(1, 6);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(1, 3);
					break;
				case 6:
					die = new Dice(1, 6);
					break;
				case 8:
					die = new Dice(1, 8);
					break;
				case 10:
					die = new Dice(1, 10);
				}
				break;
			}
			break;
		case -2: //Tiny
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 0);
					break;
				case 3:
					die = new Dice(1, 1);
					break;
				case 4:
					die = new Dice(1, 2);
					break;
				case 6:
					die = new Dice(1, 3);
					break;
				case 8:
					die = new Dice(1,4);
					break;
				case 10:
					die = new Dice(1, 6);
					break;
				case 12:
					die = new Dice(1, 8);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(1, 4);
					break;
				case 6:
					die = new Dice(1, 8);
					break;
				case 8:
					die = new Dice(1, 10);
					break;
				case 10:
					die = new Dice(2, 6);
				}
				break;
			}
			break;
		case -1: //Small
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 1);
					break;
				case 3:
					die = new Dice(1, 2);
					break;
				case 4:
					die = new Dice(1, 3);
					break;
				case 6:
					die = new Dice(1, 4);
					break;
				case 8:
					die = new Dice(1,6);
					break;
				case 10:
					die = new Dice(1, 8);
					break;
				case 12:
					die = new Dice(1, 10);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(1, 6);
					break;
				case 6:
					die = new Dice(1, 10);
					break;
				case 8:
					die = new Dice(2, 6);
					break;
				case 10:
					die = new Dice(2, 8);
				}
				break;
			}
			break;
		case 0: //Medium
			die = DAMAGE;
			break;
		case 1: //Large
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 3);
					break;
				case 3:
					die = new Dice(1, 4);
					break;
				case 4:
					die = new Dice(1, 6);
					break;
				case 6:
					die = new Dice(1, 8);
					break;
				case 8:
					die = new Dice(2, 6);
					break;
				case 10:
					die = new Dice(2, 8);
					break;
				case 12:
					die = new Dice(3, 6);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(2, 6);
					break;
				case 6:
					die = new Dice(3, 6);
					break;
				case 8:
					die = new Dice(3, 8);
					break;
				case 10:
					die = new Dice(4, 8);
				}
				break;
			}
			break;
			
		case 2: //Huge
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 4);
					break;
				case 3:
					die = new Dice(1, 6);
					break;
				case 4:
					die = new Dice(1, 8);
					break;
				case 6:
					die = new Dice(2, 6);
					break;
				case 8:
					die = new Dice(3, 6);
					break;
				case 10:
					die = new Dice(3, 8);
					break;
				case 12:
					die = new Dice(4, 6);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(3, 6);
					break;
				case 6:
					die = new Dice(4, 6);
					break;
				case 8:
					die = new Dice(4, 8);
					break;
				case 10:
					die = new Dice(6, 8);
				}
				break;
			}
			break;
		case 3: //Giant
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 6);
					break;
				case 3:
					die = new Dice(1, 8);
					break;
				case 4:
					die = new Dice(2, 6);
					break;
				case 6:
					die = new Dice(3, 6);
					break;
				case 8:
					die = new Dice(4, 6);
					break;
				case 10:
					die = new Dice(4, 8);
					break;
				case 12:
					die = new Dice(6, 6);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(4, 6);
					break;
				case 6:
					die = new Dice(6, 6);
					break;
				case 8:
					die = new Dice(6, 8);
					break;
				case 10:
					die = new Dice(8, 8);
				}
				break;
			}
			break;
		case 4: //Colossal
			switch(qty) { 
			case 1:
				switch(faces) { 
				case 2:
					die = new Dice(1, 8);
					break;
				case 3:
					die = new Dice(2, 6);
					break;
				case 4:
					die = new Dice(3, 6);
					break;
				case 6:
					die = new Dice(4, 6);
					break;
				case 8:
					die = new Dice(6, 6);
					break;
				case 10:
					die = new Dice(6, 8);
					break;
				case 12:
					die = new Dice(8, 6);
					break;
				}
				break;
			case 2:
				switch(faces) { 
				case 4:
					die = new Dice(6, 6);
					break;
				case 6:
					die = new Dice(8, 6);
					break;
				case 8:
					die = new Dice(8, 8);
					break;
				case 10:
					die = new Dice(12, 8);
				}
				break;
			}
			break;
		}
		
		if(playerSize == -1) {
			return DAMAGE.getDie();
		}
		
		if(die != null) {
			return die.getDie();
		} else { 
			return "err";
		}
	}
	
	public int getWeight() { 
		return WEIGHT;
	}
	
	public int getHP() { 
		return HP;
	}
}
