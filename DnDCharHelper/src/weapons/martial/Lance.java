package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Lance extends Weapon {
	public Lance() { 
		super("Lance");
		super.setCost(new Gold(10));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Piercing");
	}
}
