package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import armor.*;

import races.*;
import res.Dice;
import res.Tools;
import weapons.Weapon;
import weapons.exotic.*;
import weapons.simple.*;
import weapons.martial.*;
import entities.Player;
import gui.CreateCharScreen;
import gui.SWTCharScreen;


public class Main {
	
	public static Display display;
	private static Shell armorShell;
	private static int baseModifier = 8;
	private static boolean SWTEnabled = true;
	

	public static List<Player> players;
	public static List<Weapon> simpleWeapons;
	public static List<Weapon> martialWeapons;
	public static List<Weapon> exoticWeapons;
	public static List<Armor> lightArmor;
	public static List<Armor> mediumArmor;
	public static List<Armor> heavyArmor;
	public static List<Armor> shields;
	public static List<Race> races;
	
	
	/*
	 * Size Chart--
	 * F = 0;
	 * D = 1;
	 * T = 2;
	 * S = 3;
	 * M = 4;
	 * L = 5;
	 * H = 6;
	 * G = 7;
	 * C = 8;
	 */
	
	public static void main(String[] args) {
		players = new ArrayList<Player>();
		simpleWeapons = new ArrayList<Weapon>();
		martialWeapons = new ArrayList<Weapon>();
		exoticWeapons = new ArrayList<Weapon>();
		lightArmor = new ArrayList<Armor>();
		mediumArmor = new ArrayList<Armor>();
		heavyArmor = new ArrayList<Armor>();
		shields = new ArrayList<Armor>();
		races = new ArrayList<Race>();
		
		display = new Display();
		
		CreateSimpleWeapons();
		CreateMartialWeapons();
		CreateExoticWeapons();
		
		CreateLightArmor();
		CreateMediumArmor();
		CreateHeavyArmor();
		CreateShields();
		
		CreateRaces();
		
		players.add(CreateRandomPlayer("Stephanie"));
		players.add(CreateRandomPlayer("Gary"));
		players.add(CreateRandomPlayer("Joules"));
		
		setBaseModifier(8);
		
		for(Player p : players) {
			System.out.println(p.getName());
			System.out.println(p.getRace().getRaceName());
			
			System.out.println("Str Total: " + Integer.toString(p.getStr() + p.getRace().getStrBonus()));
			System.out.println("Str Base: " + Integer.toString(p.getStr()));
			System.out.println("Str Racial Bonus: " + Integer.toString(p.getRace().getStrBonus()));
			System.out.println("Str Modifier: " + Integer.toString(p.getModifier(p.getStr() + p.getRace().getStrBonus())));
			System.out.println("Size: " + p.getRace().getSize());
			System.out.println("Weapon: " + p.getEquippedWeapon().getName());
			System.out.println("Damage: " + p.getEquippedWeapon().getDamage(p.getRace().getSize()));
			System.out.println("Armor: " + p.getEquippedArmor().getName());
			System.out.println("AC: " + Integer.toString(p.getEquippedArmor().getArmorBonus() + 10));
			
			System.out.println("Speed: " + p.getRace().getSpeed());
			System.out.println("-------------------------");
			
		}
		
		System.out.println(RollHP(new Dice(2, 10)));
		
		if(SWTEnabled == true) {
			new SWTCharScreen();
		}
	}
	
	public static Display getDisplay() { 
		return display;
	}
	
	public static void CreateRaces() { 
		races.add(new Dwarf());
		races.add(new Elf());
		races.add(new Gnome());
		races.add(new HalfElf());
		races.add(new Halfling());
		races.add(new HalfOrc());
		races.add(new Human());
	}
	
	public static void setBaseModifier(int i) { 
		baseModifier = i;
	}
	
	public static int getBaseModifier() { 
		return baseModifier;
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
		int i = r.nextInt(races.size());
		return races.get(i);
	}
	
	private static Weapon RandomWeapon(String s) { 
		Random r = new Random();
		int i = -1;
		switch(s) { 
		case "simple":
			i = r.nextInt(simpleWeapons.size());
			return simpleWeapons.get(i);
		case "martial":
			i = r.nextInt(martialWeapons.size());
			return martialWeapons.get(i);
		case "exotic":
			i = r.nextInt(exoticWeapons.size());
			return exoticWeapons.get(i);
		}
		return null;
	}
	
	private static Armor RandomArmor(String s) { 
		Random r = new Random();
		int i = -1;
		switch(s) { 
		case "light":
			i = r.nextInt(lightArmor.size());
			return lightArmor.get(i);
		case "medium":
			i = r.nextInt(mediumArmor.size());
			return mediumArmor.get(i);
		case "heavy":
			i = r.nextInt(heavyArmor.size());
			return heavyArmor.get(i);
		}
		return null;
	}
	
	private static int RollHP(Dice d) { 
		return d.rollDie();
	}
	
	private static void CreateLightArmor() { 
		lightArmor.add(new Padded());
		lightArmor.add(new Leather());
		lightArmor.add(new StuddedLeather());
		lightArmor.add(new ChainShirt());
	}
	
	private static void CreateMediumArmor() { 
		mediumArmor.add(new Hide());
		mediumArmor.add(new ScaleMail());
		mediumArmor.add(new ChainMail());
		mediumArmor.add(new Breastplate());
	}
	
	private static void CreateHeavyArmor() { 
		heavyArmor.add(new SplintMail());
		heavyArmor.add(new BandedMail());
		heavyArmor.add(new HalfPlate());
		heavyArmor.add(new FullPlate());
	}
	
	public static void CreateShields() { 
		shields.add(new Buckler());
		shields.add(new LightWoodenShield());
		shields.add(new HeavyWoodenShield());
		shields.add(new LightSteelShield());
		shields.add(new HeavySteelShield());
		shields.add(new TowerShield());
	}
	
	@SuppressWarnings("unused")
	private static void CreateGUI() { 
		//CharacterScreen gui = new CharacterScreen();
		//gui.setVisible(true);
		new SWTCharScreen();
	}
	
	private static void CreateExoticWeapons() { 
		exoticWeapons.add(new BastardSword());
		exoticWeapons.add(new Bolas());
		exoticWeapons.add(new DireFlail());
		exoticWeapons.add(new DwarvenUrgrosh());
		exoticWeapons.add(new DwarvenWaraxe());
		exoticWeapons.add(new GnomeHookedHammer());
		exoticWeapons.add(new HandCrossbow());
		exoticWeapons.add(new Kama());
		exoticWeapons.add(new Net());
		exoticWeapons.add(new Nunchaku());
		exoticWeapons.add(new OrcDoubleAxe());
		exoticWeapons.add(new RepeatingHeavyCrossbow());
		exoticWeapons.add(new RepeatingLightCrossbow());
		exoticWeapons.add(new Sai());
		exoticWeapons.add(new Shuriken());
		exoticWeapons.add(new Siangham());
		exoticWeapons.add(new SpikedChain());
		exoticWeapons.add(new TwoBladedSword());
		exoticWeapons.add(new Whip());
	}
	
	private static void CreateMartialWeapons() { 
		martialWeapons.add(new Battleaxe());
		martialWeapons.add(new CompositeLongbow());
		martialWeapons.add(new CompositeShortbow());
		martialWeapons.add(new Falchion());
		martialWeapons.add(new Flail());
		martialWeapons.add(new Glaive());
		martialWeapons.add(new GreatAxe());
		martialWeapons.add(new GreatClub());
		martialWeapons.add(new Greatsword());
		martialWeapons.add(new Guisarme());
		martialWeapons.add(new Halberd());
		martialWeapons.add(new Handaxe());
		martialWeapons.add(new HeavyFlail());
		martialWeapons.add(new HeavyPick());
		martialWeapons.add(new HeavyShield());
		martialWeapons.add(new HeavySpikedShield());
		martialWeapons.add(new Kukri());
		martialWeapons.add(new Lance());
		martialWeapons.add(new LightHammer());
		martialWeapons.add(new LightPick());
		martialWeapons.add(new LightShield());
		martialWeapons.add(new LightSpikedShield());
		martialWeapons.add(new Longbow());
		martialWeapons.add(new Longsword());
		martialWeapons.add(new Ranseur());
		martialWeapons.add(new Rapier());
		martialWeapons.add(new Sap());
		martialWeapons.add(new Scimitar());
		martialWeapons.add(new Scythe());
		martialWeapons.add(new Shortbow());
		martialWeapons.add(new ShortSword());
		martialWeapons.add(new SpikedArmor());
		martialWeapons.add(new ThrowingAxe());
		martialWeapons.add(new Trident());
		martialWeapons.add(new Warhammer());
	}
	
	private static void CreateSimpleWeapons() { 
		simpleWeapons.add(new Club());
		simpleWeapons.add(new Dagger());
		simpleWeapons.add(new Dart());
		simpleWeapons.add(new Gauntlet());
		simpleWeapons.add(new HeavyCrossbow());
		simpleWeapons.add(new HeavyMace());
		simpleWeapons.add(new Javelin());
		simpleWeapons.add(new LightCrossbow());
		simpleWeapons.add(new LightMace());
		simpleWeapons.add(new Longspear());
		simpleWeapons.add(new Morningstar());
		simpleWeapons.add(new PunchingDagger());
		simpleWeapons.add(new Quarterstaff());
		simpleWeapons.add(new Shortspear());
		simpleWeapons.add(new Sickle());
		simpleWeapons.add(new Sling());
		simpleWeapons.add(new Spear());
		simpleWeapons.add(new SpikedGauntlet());
		simpleWeapons.add(new UnarmedStrike());
	}

}
