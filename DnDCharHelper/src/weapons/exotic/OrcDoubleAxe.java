package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class OrcDoubleAxe extends Weapon {
	public OrcDoubleAxe() { 
		super("Axe, Orc Double");
		super.setCost(new Gold(60));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(15);
		super.setType("Slashing");
	}
}
