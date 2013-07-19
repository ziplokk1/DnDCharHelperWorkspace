package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Glaive extends Weapon {
	public Glaive() { 
		super("Glaive");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 10));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Slashing");
	}
}
