package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Guisarme extends Weapon {
	public Guisarme() { 
		super("Guisarme");
		super.setCost(new Gold(9));
		super.setDamage(new Dice(2, 4));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(12);
		super.setType("Slashing");
	}
}
