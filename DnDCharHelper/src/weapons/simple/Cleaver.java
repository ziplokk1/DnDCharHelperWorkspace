package weapons.simple;

import res.Dice;
import weapons.Weapon;

public class Cleaver extends Weapon {

	public Cleaver() {
		super("Cleaver");
		super.setDamage(new Dice(1, 6));
		super.setCritical(19);
		super.setType("Slashing");
		super.setRangeIncrement(0);
		super.setSize("Small");
		super.setWeight(2);
		// TODO Auto-generated constructor stub
	}

}
