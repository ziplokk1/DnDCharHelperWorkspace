package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class GreatAxe extends Weapon {
	public GreatAxe() { 
		super("Greataxe");
		super.setCost(new Gold(20));
		super.setDamage(new Dice(1, 12));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(12);
		super.setType("Slashing");
	}
}
