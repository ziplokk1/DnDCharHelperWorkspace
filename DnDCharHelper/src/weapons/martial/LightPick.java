package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class LightPick extends Weapon {
	public LightPick() { 
		super("Pick, Light");
		super.setCost(new Gold(4));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(4);
		super.setRangeIncrement(0);
		super.setWeight(3);
		super.setType("Piercing");
	}
}
