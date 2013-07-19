package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Bolas extends Weapon {
	public Bolas() { 
		super("Bolas");
		super.setCost(new Gold(5));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(2);
		super.setType("Bludgeoning");
	}
}
