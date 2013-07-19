package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Net extends Weapon {
	public Net() { 
		super("Net");
		super.setCost(new Gold(20));
		super.setDamage(new Dice(1, 0));
		super.setCriticalMultiplier(0);
		super.setRangeIncrement(10);
		super.setWeight(6);
		super.setType("-");
	}
}
