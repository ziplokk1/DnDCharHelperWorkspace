package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Scythe extends Weapon {
	public Scythe() { 
		super("Scythe");
		super.setCost(new Gold(18));
		super.setDamage(new Dice(2, 4));
		super.setCriticalMultiplier(4);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Piercing or Slashing");
	}
}
