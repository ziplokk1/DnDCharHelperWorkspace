package weapons.exotic;

import res.Dice;
import res.Money.Gold;
import weapons.Weapon;

public class GnomeHookedHammer extends Weapon {
	public GnomeHookedHammer() { 
		super("Hammer, Gnome Hooked");
		super.setCost(new Gold(20));
		super.setDamage(new Dice(1, 6));
		super.setCriticalMultiplier(3);
		super.setRangeIncrement(0);
		super.setWeight(6);
		super.setType("Bludgeoning and Piercing");
	}
}
