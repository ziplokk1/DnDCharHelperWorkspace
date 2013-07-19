package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Scimitar extends Weapon {
	public Scimitar() { 
		super("Scimitar");
		super.setCost(new Gold(15));
		super.setDamage(new Dice(1, 6));
		super.setCritical(18);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(4);
		super.setType("Slashing");
	}
}
