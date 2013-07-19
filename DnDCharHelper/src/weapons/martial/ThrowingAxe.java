package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class ThrowingAxe extends Weapon {
	public ThrowingAxe() { 
		super("Axe, Throwing");
		super.setCost(new Gold(8));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(10);
		super.setWeight(2);
		super.setType("Slashing");
	}
}
