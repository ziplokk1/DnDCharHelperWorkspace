package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class HandCrossbow extends Weapon {
	public HandCrossbow() { 
		super("Crossbow, Hand");
		super.setCost(new Gold(100));
		super.setDamage(new Dice(1, 4));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(30);
		super.setWeight(2);
		super.setType("Piercing");
	}
}
