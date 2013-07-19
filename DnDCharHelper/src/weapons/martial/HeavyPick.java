package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class HeavyPick extends Weapon {
	public HeavyPick() { 
		super("Pick, Heavy");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(4);
		super.setRangeIncrement(0);
		super.setWeight(6);
		super.setType("Piercing");
	}
}
