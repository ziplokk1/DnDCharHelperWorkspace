package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class DwarvenWaraxe extends Weapon {
	public DwarvenWaraxe() {
		super("Waraxe, Dwarven");
		super.setCost(new Gold(30));
		super.setDamage(new Dice(1, 10));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(8);
		super.setType("Slashing");
	}
}
