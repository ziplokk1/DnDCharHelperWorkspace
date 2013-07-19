package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Morningstar extends Weapon {
	public Morningstar() { 
		super("Morningstar");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(8);
		super.setRangeIncrement(0);
		super.setWeight(6);
		super.setType("Bludgeoning and Slashing");
	}
}
