package weapons.simple;

import res.Dice;
import weapons.Weapon;

public class BrassKnuckles extends Weapon {

	public BrassKnuckles() {
		super("Brass Knuckles");
		super.setDamage(new Dice(1, 1));
		super.setCritical(20);
		super.setType("Bludgeoning");
		super.setRangeIncrement(0);
		super.setSize("Tiny");
		super.setWeight(1);
		// TODO Auto-generated constructor stub
	}

}
