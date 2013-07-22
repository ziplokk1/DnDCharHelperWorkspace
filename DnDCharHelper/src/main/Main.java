package main;
import item.Item;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import armor.*;

import races.*;
import res.Tools;
import res.Money.Copper;
import res.Money.Gold;
import res.Money.Silver;
import weapons.Weapon;
import weapons.exotic.*;
import weapons.simple.*;
import weapons.martial.*;
import entities.Player;
import gui.MainScrSWT;

/*
 * Created by Mark Sanders
 * Email: ziplokk.mark.sanders@gmail.com
 * 
 * This program is used and 
 * created with Dungeons and Dragons v 3.5
 * property of Wizards of the Coast
 */


public class Main {
	
	public static Display display;
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
	public static List<Item> adventuringGear;
	public static List<Item> specialSubstancesAndItems;
	public static List<Item> toolsAndSmallKits;
	public static List<Item> clothing;
	public static List<Item> foodDrinkAndLodging;
	public static List<Item> mountsAndRelatedGear;
	public static List<Item> transport;
	public static List<Item> spellcastingAndServices;
	
	
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
		
		/*
		 * Items
		 */
		adventuringGear = new ArrayList<Item>();
		specialSubstancesAndItems = new ArrayList<Item>();
		toolsAndSmallKits = new ArrayList<Item>();
		clothing = new ArrayList<Item>();
		foodDrinkAndLodging = new ArrayList<Item>();
		mountsAndRelatedGear = new ArrayList<Item>();
		transport = new ArrayList<Item>();
		spellcastingAndServices = new ArrayList<Item>();
		
		display = new Display();
		
		CreateSimpleWeapons();
		CreateMartialWeapons();
		CreateExoticWeapons();
		
		CreateLightArmor();
		CreateMediumArmor();
		CreateHeavyArmor();
		CreateShields();
		
		CreateItems();
		CreateClothing();
		CreateFoodDrinkAndLodging();
		CreateMountsAndRelatedGear();
		CreateTransport();
		CreateSpellcastingAndServices();
		
		CreateRaces();
		
		/*
		 * Sets the zero-in point for modifiers. Used for house rules
		 * @Params (zeroed modifier)
		 */
		setBaseModifier(8);
		
		//CreateRandomPlayers(); //this is for testing
		
		if(SWTEnabled == true) {
			new MainScrSWT();
		}
	}
	
	@SuppressWarnings("unused")
	private static void CreateRandomPlayers() { 
		players.add(Tools.CreateRandomPlayer("Stephanie"));
		players.add(Tools.CreateRandomPlayer("Gary"));
		players.add(Tools.CreateRandomPlayer("Joules"));
		
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
	}
	
	private static void CreateSpellcastingAndServices() { 
		List<Item> a = spellcastingAndServices;
		a.add(new Item("Coach Cab (Per Mile)", new Copper(3), 0));
		a.add(new Item("Hireling, Trained (per Day)", new Silver(3), 0));
		a.add(new Item("Hireling, Untrained (per Day)", new Silver(1), 0));
		a.add(new Item("Messenger (Per Mile)", new Copper(2), 0));
		a.add(new Item("Road or Gate Toll", new Copper(1), 0));
		a.add(new Item("Ships Passage (Per Mile)", new Silver(1), 0));
	}
	
	private static void CreateTransport() { 
		List<Item> a = transport;
		a.add(new Item("Carriage", new Gold(100), 600));
		a.add(new Item("Cart", new Gold(15), 200));
		a.add(new Item("Galley", new Gold(30000), 0));
		a.add(new Item("Keelboat", new Gold(3000), 0));
		a.add(new Item("Longship", new Gold(10000), 0));
		a.add(new Item("Rowboat", new Gold(50), 100));
		a.add(new Item("Oar", new Gold(2), 10));
		a.add(new Item("Sailing Ship", new Gold(10000), 0));
		a.add(new Item("Sled", new Gold(20), 300));
		a.add(new Item("Wagon", new Gold(35), 400));
		a.add(new Item("Warship", new Gold(25000), 0));
	}
	
	private static void CreateMountsAndRelatedGear() { 
		List<Item> a = mountsAndRelatedGear;
		a.add(new Item("Bit and Bridle", new Gold(2), 1));
		a.add(new Item("Dog, Guard", new Gold(25), 0));
		a.add(new Item("Dog, Riding", new Gold(150), 0));
		a.add(new Item("Donkey or Mule", new Gold(8), 0));
		a.add(new Item("Feed (per Day)", new Copper(5), 10));
		a.add(new Item("Horse, Heavy", new Gold(200), 0));
		a.add(new Item("Horse, Light", new Gold(75), 0));
		a.add(new Item("Pony", new Gold(30), 0));
		a.add(new Item("Warhorse, Heavy", new Gold(400), 0));
		a.add(new Item("Warhorse, Light", new Gold(150), 0));
		a.add(new Item("Warpony", new Gold(100), 0));
		a.add(new Item("Saddle, Military", new Gold(20), 30));
		a.add(new Item("Pack", new Gold(5), 15));
		a.add(new Item("Riding", new Gold(10), 25));
		a.add(new Item("Saddle, Military (Exotic)", new Gold(60), 40));
		a.add(new Item("Saddle, Pack (Exotic)", new Gold(15), 20));
		a.add(new Item("Saddle, Riding (Exotic)", new Gold(30), 30));
		a.add(new Item("Saddlebags", new Gold(4), 8));
		a.add(new Item("Stabling (per Day)", new Silver(5), 0));
	}
	
	private static void CreateFoodDrinkAndLodging() { 
		List<Item> a = foodDrinkAndLodging;
		a.add(new Item("Ale, Gallon", new Silver(2), 8));
		a.add(new Item("Ale, Mug", new Copper(4), 1));
		a.add(new Item("Banquet (per person)", new Gold(10), 0));
		a.add(new Item("Bread, per Loaf", new Copper(2), 1));
		a.add(new Item("Cheese, hunk of", new Silver(1), 1));
		a.add(new Item("Inn Stay (per Day), Good", new Gold(2), 0));
		a.add(new Item("Inn Stay (per Day), Common", new Silver(5), 0));
		a.add(new Item("Inn Stay (per Day), Poor", new Silver(2), 0));
		a.add(new Item("Meat, chunk of", new Silver(3), 1));
		a.add(new Item("Wine, Common (Pitcher)", new Silver(2), 6));
		a.add(new Item("Wine, Fine (Bottle)", new Gold(10), 1));
	}
	
	private static void CreateClothing() { 
		List<Item> a = clothing;
		a.add(new Item("Artisan's Outfit", new Gold(1), 4));
		a.add(new Item("Cleric's Vestiments", new Gold(5), 6));
		a.add(new Item("Cold Weather Outfit", new Gold(8), 7));
		a.add(new Item("Courtier's Outfit", new Gold(30), 6));
		a.add(new Item("Entertainer's Outfit", new Gold(3), 4));
		a.add(new Item("Explorer's Outfit", new Gold(10), 8));
		a.add(new Item("Monk's Outfit", new Gold(5), 2));
		a.add(new Item("Noble's Outfit", new Gold(75), 10));
		a.add(new Item("Peasants Outfit", new Silver(1), 2));
		a.add(new Item("Royal Outfit", new Gold(200), 15));
		a.add(new Item("Scholar's Outfit", new Gold(5), 6));
		a.add(new Item("Traveler's Outfit", new Gold(1), 5));
	}
	
	private static void CreateItems() { 
		List<Item> a = adventuringGear;
		a.add(new Item("Backpack", new Gold(2), 2));
		a.add(new Item("Barrel", new Gold(2), 30));
		a.add(new Item("Basket", new Silver(4), 1));
		a.add(new Item("Bedroll", new Silver(1), 5));
		a.add(new Item("Bell", new Gold(1), 0));
		a.add(new Item("Blanket, Winter", new Silver(5), 3));
		a.add(new Item("Block and Tackle", new Gold(5), 5));
		a.add(new Item("Bottle, Wine Glass", new Gold(2), 0));
		a.add(new Item("Bucket", new Silver(5), 2));
		a.add(new Item("Caltrops", new Gold(1), 2));
		a.add(new Item("Candle", new Copper(1), 0));
		a.add(new Item("Canvas", new Silver(1), 1));
		a.add(new Item("Case, Map or Scroll", new Gold(1), 1));
		a.add(new Item("Chain (10ft.)", new Gold(30), 2));
		a.add(new Item("Chalk, 1pc", new Copper(1), 0));
		a.add(new Item("Crowbar", new Gold(5), 5));
		a.add(new Item("Firewood (per day)", new Copper(1), 20));
		a.add(new Item("Fishhook", new Silver(1), 0));
		a.add(new Item("Fishing net, 25 sq. ft.", new Gold(4), 5));
		a.add(new Item("Flask", new Copper(3), 1));
		a.add(new Item("Flint and Steel", new Gold(1), 0));
		a.add(new Item("Grappling Hook", new Gold(1), 4));
		a.add(new Item("Hammer", new Silver(5), 2));
		a.add(new Item("Ink (1 oz. vial)", new Gold(8), 0));
		a.add(new Item("Inkpen", new Silver(1), 0));
		a.add(new Item("Jug, Clay", new Copper(3), 9));
		a.add(new Item("Ladder, 10-foot", new Copper(5), 20));
		a.add(new Item("Lamp, Common", new Silver(1), 1));
		a.add(new Item("Lantern, Bullseye", new Gold(12), 3));
		a.add(new Item("Lantern, Hooded", new Gold(7), 2));
		a.add(new Item("Lock, Very Simple", new Gold(20), 1));
		a.add(new Item("Lock, Average", new Gold(40), 1));
		a.add(new Item("Lock, Good", new Gold(80), 1));
		a.add(new Item("Lock, Amazing", new Gold(150), 1));
		a.add(new Item("Manacles", new Gold(15), 2));
		a.add(new Item("Manacles, Masterwork", new Gold(50), 2));
		a.add(new Item("Mirror, Small Steel", new Gold(10), 1));
		a.add(new Item("Mug/Tankard, Clay", new Copper(2), 1));
		a.add(new Item("Oil (1-pint Flask", new Silver(1), 1));
		a.add(new Item("Paper (Sheet)", new Silver(4), 0));
		a.add(new Item("Parchment (Sheet)", new Silver(2), 0));
		a.add(new Item("Pick, Miners", new Gold(3), 10));
		a.add(new Item("Pitcher, Clay", new Copper(2), 5));
		a.add(new Item("Piton", new Silver(1), 1));
		a.add(new Item("Pole, 10-foot", new Silver(2), 8));
		a.add(new Item("Pot, Iron", new Silver(5), 10));
		a.add(new Item("Pouch, Belt", new Gold(1), 1));
		a.add(new Item("Ram, Portable", new Gold(10), 20));
		a.add(new Item("Rations, Trail (per Day)", new Silver(5), 1));
		a.add(new Item("Rope, Hempen (50ft.)", new Gold(1), 10));
		a.add(new Item("Rope, Silk (50ft.)", new Gold(10), 5));
		a.add(new Item("Sack", new Silver(1), 1));
		a.add(new Item("Sealing Wax", new Gold(1), 1));
		a.add(new Item("Sewing Needle", new Silver(5), 0));
		a.add(new Item("Signal Whistle", new Silver(8), 0));
		a.add(new Item("Signet Ring", new Gold(5), 0));
		a.add(new Item("Sledge", new Gold(1), 10));
		a.add(new Item("Soap (per lb.)", new Silver(5), 1));
		a.add(new Item("Spade or Shovel", new Gold(2), 8));
		a.add(new Item("Spyglass", new Gold(1000), 1));
		a.add(new Item("Tent", new Gold(10), 20));
		a.add(new Item("Torch", new Copper(1), 1));
		a.add(new Item("Vial, Ink or Potion", new Gold(1), 1));
		a.add(new Item("Waterskin", new Gold(1), 4));
		a.add(new Item("Whetstone", new Copper(2), 1));
		
		List<Item> s = specialSubstancesAndItems;
		s.add(new Item("Acid (flask)", new Gold(10), 1));
		s.add(new Item("Alchemists Fire (flask)", new Gold(20), 1));
		s.add(new Item("Antitoxin", new Gold(50), 0));
		s.add(new Item("Everburning Torch", new Gold(110), 1));
		s.add(new Item("Holy Water (flask)", new Gold(25), 1));
		s.add(new Item("Smokestick", new Gold(20), 1));
		s.add(new Item("Sunrod", new Gold(2), 1));
		s.add(new Item("Tanglefoot Bag", new Gold(50), 4));
		s.add(new Item("Thunderstone", new Gold(30), 1));
		s.add(new Item("Tindertwig", new Gold(1), 0));
		
		List<Item> d = toolsAndSmallKits;
		d.add(new Item("Alchemist's Lab", new Gold(500), 40));
		d.add(new Item("Artisan's Tools", new Gold(5), 5));
		d.add(new Item("Artisan's Tools, Masterwork", new Gold(55), 5));
		d.add(new Item("Climbers Kit", new Gold(80), 5));
		d.add(new Item("Disguise Kit", new Gold(50), 8));
		d.add(new Item("Healer's Kit", new Gold(50), 1));
		d.add(new Item("Holly and Mistletoe", new Copper(0), 0));
		d.add(new Item("Holy Symbol, Wooden", new Gold(1), 1));
		d.add(new Item("Holy Symbol, Silver", new Gold(25), 1));
		d.add(new Item("Hourglass", new Gold(25), 1));
		d.add(new Item("Magnifying Glass", new Gold(100), 0));
		d.add(new Item("Musical Instrument, Common", new Gold(5), 3));
		d.add(new Item("Musical Instrument, Masterwork", new Gold(100), 3));
		d.add(new Item("Scale, Merchants", new Gold(2), 1));
		d.add(new Item("Spell Component Pouch", new Gold(5), 2));
		d.add(new Item("Spellbook, Wizard's (blank)", new Gold(15), 3));
		d.add(new Item("Thieves' Tools", new Gold(30), 1));
		d.add(new Item("Thieves' Tools, Masterwork", new Gold(100), 2));
		d.add(new Item("Tools, Masterwork", new Gold(50), 1));
		d.add(new Item("Waterclock", new Gold(1000), 200));
	}
	
	public static Display getDisplay() { 
		return display;
	}
	
	private static void CreateRaces() { 
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
