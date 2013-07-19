package weapons.martial;

import res.Dice;
import res.Money.Copper;
import weapons.Weapon;

public class SpikedArmor extends Weapon {
	public SpikedArmor() { 
		super("Spiked Armor");
		super.setCost(new Copper(-1));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(0);
		super.setType("Piercing");
	}
}
