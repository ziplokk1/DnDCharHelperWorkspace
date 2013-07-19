package main;
import java.util.ArrayList;
import java.util.List;

import res.Money.Copper;
import res.Money.Gold;
import res.Money.Silver;
import weapons.Weapon;
import weapons.exotic.*;
import weapons.simple.*;
import weapons.martial.*;
import entities.Player;
import gui.CharacterScreen;
import gui.SWTCharScreen;


public class Main {

	public static List<Player> players;
	public static List<Weapon> simpleWeapons;
	public static List<Weapon> martialWeapons;
	public static List<Weapon> exoticWeapons;
	
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
		
		CreateSimpleWeapons();
		CreateMartialWeapons();
		CreateExoticWeapons();
		
		CreateGUI();
	}
	
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
