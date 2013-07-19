package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class HeavyFlail extends Weapon {
	public HeavyFlail() { 
		super("Flail, Heavy");
		super.setCost(new Gold(15));
		super.setDamage(new Dice(1, 10));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Bludgeoning");
	}
}
