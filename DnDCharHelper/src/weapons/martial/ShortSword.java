package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class ShortSword extends Weapon {
	public ShortSword() {
		super("Sword, Short");
		super.setCost(new Gold(10));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setCritical(19);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
