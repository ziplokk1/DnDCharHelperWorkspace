package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class RepeatingLightCrossbow extends Weapon {
	public RepeatingLightCrossbow() { 
		super("Crossbow, Repeating Light");
		super.setCost(new Gold(250));
		super.setDamage(new Dice(1, 8));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(80);
		super.setWeight(6);
		super.setType("Piercing");
	}
}
