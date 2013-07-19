package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Longsword extends Weapon {
	public Longsword() { 
		super("Longsword");
		super.setCost(new Gold(15));
		super.setDamage(new Dice(1, 8));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(4);
		super.setType("Slashing");
	}
}
