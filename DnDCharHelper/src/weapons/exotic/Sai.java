package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Sai extends Weapon {
	public Sai() { 
		super("Sai");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(1);
		super.setType("Bludgeoning");
	}
}
