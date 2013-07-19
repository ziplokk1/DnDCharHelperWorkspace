package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class LightHammer extends Weapon {
	public LightHammer() { 
		super("Hammer, Light");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(20);
		super.setWeight(2);
		super.setType("Bludgeoning");
	}
}
