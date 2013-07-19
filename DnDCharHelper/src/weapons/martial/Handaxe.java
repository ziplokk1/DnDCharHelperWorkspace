package weapons.martial;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class Handaxe extends Weapon {
	public Handaxe() { 
		super("Handaxe");
		super.setCost(new Gold(6));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(3);
		super.setType("Slashing");
	}
}
