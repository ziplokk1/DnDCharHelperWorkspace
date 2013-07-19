package weapons.simple;

import res.Dice;
import weapons.Weapon;

public class SpikedClub extends Weapon {

	public SpikedClub() {
		super("Club, Spiked");
		super.setDamage(new Dice(1, 8));
		super.setCritical(20);
		super.setType("Bludgeoning, Piercing");
		super.setRangeIncrement(0);
		super.setSize("Medium");
		super.setWeight(8);
		// TODO Auto-generated constructor stub
	}

}
