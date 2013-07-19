package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class DwarvenUrgrosh extends Weapon {
	public DwarvenUrgrosh() { 
		super("Urgrosh, Dwarven");
		super.setCost(new Gold(50));
		super.setDamage(new Dice(1, 8));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(12);
		super.setType("Slashing or Piercing");
	}
}
