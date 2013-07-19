package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class PunchingDagger extends Weapon {
	public PunchingDagger() { 
		super("Dagger, Punching");
		super.setCost(new Gold(2));
		super.setDamage(new Dice(1, 4));
		super.setCritical(3);
		super.setRangeIncrement(0);
		super.setWeight(1);
		super.setType("Piercing");
	}
}
