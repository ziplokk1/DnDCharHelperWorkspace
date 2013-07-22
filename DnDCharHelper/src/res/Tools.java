package res;

import java.util.Random;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import races.Race;
import weapons.Weapon;
import armor.Armor;
import entities.Player;

public class Tools {
	
	public static void CheckResize(ScrolledComposite sc, Composite c) { 
		org.eclipse.swt.graphics.Rectangle r = sc.getClientArea();
		sc.setMinSize(c.computeSize(r.width, SWT.DEFAULT));
	}
	
	public static Player CreateRandomPlayer(String name) { 
		Player rand = new Player(name);
		rand.setRace(RandomRace());
		if(rand.getRace().getRaceName().equals("halfling")) {
			rand.setEquippedArmor(RandomArmor("light"));
		} else { 
			Random r = new Random();
			int i = r.nextInt(3);
			switch(i) { 
			case 0:
				rand.setEquippedArmor(RandomArmor("light"));
				break;
			case 1:
				rand.setEquippedArmor(RandomArmor("medium"));
				break;
			case 2:
				rand.setEquippedArmor(RandomArmor("heavy"));
				break;
			}
		}
		Random r = new Random();
		int i = r.nextInt(3);
		switch(i) { 
		case 0:
			rand.setEquippedWeapon(RandomWeapon("simple"));
			break;
		case 1:
			rand.setEquippedWeapon(RandomWeapon("martial"));
			break;
		case 2:
			rand.setEquippedWeapon(RandomWeapon("exotic"));
			break;
		}
		return rand;
	}
	
	private static Race RandomRace() { 
		Random r = new Random();
		int i = r.nextInt(Main.races.size());
		return Main.races.get(i);
	}
	
	/*
	 * @param 
	 * only use "simple", "martial", "exotic"
	 */
	private static Weapon RandomWeapon(String s) { 
		Random r = new Random();
		int i = -1;
		switch(s) { 
		case "simple":
			i = r.nextInt(Main.simpleWeapons.size());
			return Main.simpleWeapons.get(i);
		case "martial":
			i = r.nextInt(Main.martialWeapons.size());
			return Main.martialWeapons.get(i);
		case "exotic":
			i = r.nextInt(Main.exoticWeapons.size());
			return Main.exoticWeapons.get(i);
		}
		return null;
	}
	
	/*
	 * @param
	 * only use "light", "medium", "heavy"
	 */
	private static Armor RandomArmor(String s) { 
		Random r = new Random();
		int i = -1;
		switch(s) { 
		case "light":
			i = r.nextInt(Main.lightArmor.size());
			return Main.lightArmor.get(i);
		case "medium":
			i = r.nextInt(Main.mediumArmor.size());
			return Main.mediumArmor.get(i);
		case "heavy":
			i = r.nextInt(Main.heavyArmor.size());
			return Main.heavyArmor.get(i);
		}
		return null;
	}
	
	public static int RollHP(Dice d) { 
		return d.rollDie();
	}
	
	/*
	 * Used to center the current shell on the screen during layout.
	 * Similar to Swings JFrame.setLocationRelativeTo(null);
	 */
	public static Point CenterScreen(Display d, Shell s) { 
		int DISPLAY_WIDTH;
		int DISPLAY_HEIGHT;
		int SHELL_WIDTH;
		int SHELL_HEIGHT;
		
		DISPLAY_WIDTH = d.getClientArea().width;
		DISPLAY_HEIGHT = d.getClientArea().height;
		
		SHELL_WIDTH = s.getBounds().width;
		SHELL_HEIGHT = s.getBounds().height;
		
		int PtX = (DISPLAY_WIDTH / 2) - (SHELL_WIDTH / 2);
		int PtY = (DISPLAY_HEIGHT / 2) - (SHELL_HEIGHT / 2);
		return new Point(PtX, PtY);
	}
	
	/*
	 * All character sizes are kept in integer format,
	 * this returns a string corresponding to the size integer.
	 */
	public static String getSize(int i) { 
		switch(i) { 
		case 0:
			return "Fine";
		case 1:
			return "Diminuitive";
		case 2:
			return "Tiny";
		case 3:
			return "Small";
		case 4:
			return "Medium";
		case 5:
			return "Large";
		case 6:
			return "Huge";
		case 7:
			return "Gigantic";
		case 8:
			return "Colossal";
		}
		return null;
	}
	
	/*
	 * Returns a string of the Double param in percent format.
	 */
	public static String convertDeciToPercent(Double d) { 
		if(d == 0.05D) { 
			return "5%";
		} else if (d == 0.1D) { 
			return "10%";
		} else if (d == 0.15D) { 
			return "15%";
		} else if (d == 0.2D) { 
			return "20%";
		} else if (d == 0.25D) { 
			return "25%";
		} else if (d == 0.3D) { 
			return "30%";
		} else if (d == 0.35D) { 
			return "35%";
		} else if (d == 0.4D) { 
			return "40%";
		} else if (d == 0.45D) { 
			return "45%";
		} else if (d == 0.5D) { 
			return "50%";
		} else if (d == 0.55D) { 
			return "55%";
		} else if (d == 0.6D) { 
			return "60%";
		} else if (d == 0.65D) { 
			return "65%";
		} else if (d == 0.7D) { 
			return "70%";
		} else if (d == 0.75D) { 
			return "75%";
		} else if (d == 0.8D) {
			return "80%";
		} else if (d == 0.85D) { 
			return "85%";
		} else if (d == 0.9D) { 
			return "90%";
		} else if (d == 0.95D) { 
			return "95%";
		} else if (d == 1.0D) { 
			return "100%";
		} else { 
			return "Error";
		}
	}
}
