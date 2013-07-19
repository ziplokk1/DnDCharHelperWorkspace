package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Halberd extends Weapon {
	public Halberd() { 
		super("Halberd");
		super.setCost(new Gold(10));
		super.setDamage(new Dice(1, 10));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(12);
		super.setType("Piercing or Slashing");
	}
}	
