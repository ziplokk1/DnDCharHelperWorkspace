package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Kama extends Weapon {
	public Kama() { 
		super("Kama");
		super.setCost(new Gold(2));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Slashing");
	}
}
