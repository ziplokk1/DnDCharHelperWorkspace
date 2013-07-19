package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class SpikedChain extends Weapon {
	public SpikedChain() { 
		super("Chain, Spiked");
		super.setCost(new Gold(25));
		super.setDamage(new Dice(2, 4));
		super.setCriticalMultiplier(2);
		super.setRangeIncrement(0);
		super.setWeight(10);
		super.setType("Piercing");
	}
}
