package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Sap extends Weapon {
	public Sap() { 
		super("Sap");
		super.setCost(new Gold(1));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(2);
		super.setType("Bludgeoning");
	}
}
