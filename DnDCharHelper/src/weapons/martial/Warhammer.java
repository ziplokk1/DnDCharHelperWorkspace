package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Warhammer extends Weapon {
	public Warhammer() { 
		super("Warhammer");
		super.setCost(new Gold(12));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(5);
		super.setType("Bludgeoning");
	}
}
