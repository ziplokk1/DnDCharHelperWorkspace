package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class HeavyCrossbow extends Weapon {
	public HeavyCrossbow() { 
		super("Crossbow, Heavy");
		super.setCost(new Gold(50));
		super.setDamage(new Dice(1, 10));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(120);
		super.setWeight(8);
		super.setType("Piercing");
	}
}
