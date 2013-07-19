package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Falchion extends Weapon {
	public Falchion() { 
		super("Falchion");
		super.setCost(new Gold(75));
		super.setDamage(new Dice(2, 4));
		super.setCritical(18);
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(8);
		super.setType("Slashing");
	}
}
