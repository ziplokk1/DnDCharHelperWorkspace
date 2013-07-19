package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Kukri extends Weapon {
	public Kukri() { 
		super("Kukri");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 4));
		super.setCritical(18);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Slashing");
	}
}
