package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class TwoBladedSword extends Weapon {
	public TwoBladedSword() { 
		super("Sword, Two-Bladed");
		super.setCost(new Gold(100));
		super.setDamage(new Dice(1, 8));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Slashing");
	}
}
