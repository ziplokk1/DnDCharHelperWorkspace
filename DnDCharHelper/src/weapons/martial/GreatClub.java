package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class GreatClub extends Weapon {
	public GreatClub() { 
		super("Greatclub");
		super.setCost(new Gold(5));
		super.setDamage(new Dice(1, 10));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(8);
		super.setType("Bludgeoning");
	}
}
