package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Sickle extends Weapon {
	public Sickle() {  
		super("Sickle");
		super.setCost(new Gold(6));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Slashing");
	}
}
