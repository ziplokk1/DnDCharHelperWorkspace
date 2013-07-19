package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Whip extends Weapon {
	public Whip() { 
		super("Whip");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 3));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Slashing");
	}
}
