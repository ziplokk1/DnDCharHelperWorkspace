package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class BastardSword extends Weapon {
	public BastardSword() { 
		super("Sword, Bastard");
		super.setCost(new Gold(35));
		super.setDamage(new Dice(1, 10));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(6);
		super.setType("Slashing");
	}
}
