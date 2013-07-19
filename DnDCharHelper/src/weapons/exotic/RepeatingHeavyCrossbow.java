package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class RepeatingHeavyCrossbow extends Weapon {
	public RepeatingHeavyCrossbow() { 
		super("Crossbow, Repeating Heavy");
		super.setCost(new Gold(400));
		super.setDamage(new Dice(1, 10));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(120);
		super.setWeight(12);
		super.setType("Piercing");
	}
}
