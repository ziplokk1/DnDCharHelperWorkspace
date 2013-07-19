package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Greatsword extends Weapon {
	public Greatsword() { 
		super("Greatsword");
		super.setCost(new Gold(50));
		super.setDamage(new Dice(2, 6));
		super.setCritical(19);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(8);
		super.setType("Slashing");
	}
}
