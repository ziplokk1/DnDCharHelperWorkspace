package weapons.simple;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Dagger extends Weapon {
	public Dagger() {
		super("Dagger");
		super.setCost(new Gold(2));
		super.setDamage(new Dice(1, 4));
		super.setCritical(19);
		super.setRangeIncrement(10);
		super.setWeight(1);
		super.setType("Piercing or Slashing");
	}
}
