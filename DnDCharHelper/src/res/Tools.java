package res;

import java.io.File;
import races.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import races.Race;
import weapons.Weapon;
import armor.Armor;
import entities.Player;
import gui.CharScrSWT;

public class Tools {
	
	/*
	 * the following 6 methods total the pertaining ability and 
	 * sets the param label to the total and returns the total number.
	 * 
	 * returns an integer to set the modifier labels with.
	 */
	public static int TotalDex(Player character, Label label) { 
		int total = character.getDex() + character.getRace().getDexBonus() + character.getDexBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	public static int TotalStr(Player character, Label label) { 
		int total = character.getStr() + character.getRace().getStrBonus() + character.getStrBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	public static int TotalCon(Player character, Label label) { 
		int total = character.getCon() + character.getRace().getConBonus() + character.getConBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	public static int TotalCha(Player character, Label label) { 
		int total = character.getCha() + character.getRace().getChaBonus() + character.getChaBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	public static int TotalWis(Player character, Label label) { 
		int total = character.getWis() + character.getRace().getWisBonus() + character.getWisBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	public static int TotalInt(Player character, Label label) { 
		int total = character.getInt() + character.getRace().getIntBonus() + character.getIntBonus();
		if(label != null) { 
			label.setText(Integer.toString(total));
		}
		return total;
	}
	
	/*
	 * Returns the modifier according to the base modifier number
	 */
	public static int getModifier(int i) { 
		if(i < Main.getBaseModifier()) { 
			i -= 1;
		}
		return (i - Main.getBaseModifier()) / 2;
	}
	
	/*
	 * Creates a main folder in the User Home directory
	 */
	public static void CreateDnDFolder() { 
		File f = new File(System.getProperty("user.home") + "/D&D Characters");
		if(!f.isDirectory()) { 
			f.mkdir();
		} else { 
			System.out.println(f.getAbsolutePath() + " is already a directory");
		}
	}
	
	public static void SaveCharacter(Player character) throws IOException, FileNotFoundException { 
		File f = new File(System.getProperty("user.home") + "/D&D Characters/" + character.getName().toLowerCase() + ".dchar");
		f.createNewFile();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		out.writeObject(character);
		out.close();
		System.out.println("Saved");
	}
	
	public static void LoadCharacter(String characterName) throws IOException, ClassNotFoundException { 
		File f = null;
		if(characterName != null) { 
			f = new File(System.getProperty("user.home") + "/D&D Characters/" + characterName + ".dchar");
		} else { 
			
		}
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Player player = (Player) in.readObject();
		in.close();
		new CharScrSWT(player);
	}
	
	public static void CheckResize(ScrolledComposite sc, Composite c) { 
		org.eclipse.swt.graphics.Rectangle r = sc.getClientArea();
		sc.setMinSize(c.computeSize(r.width, SWT.DEFAULT));
	}
	
	public static int raceToInt(Race race) { 
		if(race.equals(Human.class)) { 
			return 0;
		} else if (race.getClass().equals(Dwarf.class)) { 
			return 1;
		} else if (race.getClass().equals(Elf.class)) { 
			return 2;
		} else if (race.getClass().equals(Gnome.class)) { 
			return 3;
		} else if (race.getClass().equals(HalfElf.class)) { 
			return 4;
		} else if (race.getClass().equals(HalfOrc.class)) { 
			return 5;
		} else if (race.getClass().equals(Halfling.class)) { 
			return 6;
		} else { 
			return -1;
		}
	}
	
	public static int getSizeAccordingToRace(Race race) { 
		if(race.getClass().equals(Gnome.class) || race.getClass().equals(Halfling.class)) { 
			return 3;
		} else { 
			return 4;
		}
	}
	
	private static int randomGender() { 
		Random r = new Random();
		return r.nextInt(2);
	}
	
	private static int randomClass() { 
		Random r = new Random();
		return r.nextInt(10);
	}
	
	public static Player CreateRandomPlayer(String name) { 
		Player rand = new Player(name);
		Race randomRace = RandomRace();
		rand.setRace(randomRace);
		rand.setRaceInt(raceToInt(randomRace));
		rand.setSize(getSizeAccordingToRace(randomRace));
		rand.setGender(randomGender());
		rand.setClass0(randomClass());
		rand.setAlignment(-1);
		if(rand.getRace().getRaceName().equals("halfling")) {
			//add code to generate random armor
			rand.getPlayerInventory().add(RandomArmor("light"));
		} else { 
			Random r = new Random();
			int i = r.nextInt(3);
			switch(i) { 
			case 0:
				rand.getPlayerInventory().add(RandomArmor("light"));
				break;
			case 1:
				rand.getPlayerInventory().add(RandomArmor("medium"));
				break;
			case 2:
				rand.getPlayerInventory().add(RandomArmor("Heavy"));
				break;
			}
		}
		Random r = new Random();
		int i = r.nextInt(3);
		switch(i) { 
		case 0:
			Weapon w = RandomWeapon("simple");
			rand.getPlayerWeapons().add(w);
			rand.getPlayerInventory().add(w);
			break;
		case 1:
			Weapon a = RandomWeapon("martial");
			rand.getPlayerWeapons().add(a);
			rand.getPlayerInventory().add(a);
			
			break;
		case 2:
			Weapon s = RandomWeapon("exotic");
			rand.getPlayerWeapons().add(s);
			rand.getPlayerInventory().add(s);
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
