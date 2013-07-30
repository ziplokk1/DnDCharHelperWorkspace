package entities;

import item.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import armor.Armor;
import races.Race;
import res.Skill;
import weapons.Weapon;
import main.Main;

public class Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int str;
	private int dex;
	private int con;
	private int cha;
	private int wis;
	private int intel;
	private int strBonus;
	private int dexBonus;
	private int conBonus;
	private int chaBonus;
	private int wisBonus;
	private int intBonus;
	
	private int willpower;
	private int willTemp;
	private int willMagic;
	private int willMisc;
	
	private int reflex;
	private int refTemp;
	private int refMagic;
	private int refMisc;
	
	private int fortitude;
	private int fortTemp;
	private int fortMagic;
	private int fortMisc;
	
	private int gender;
	private int level;
	private String diety;
	private String height;

	private int HP;
	private int currentHP;
	
	private int AC;
	private int size;
	private int class0;
	
	private int alignmentInt; //Used to change the combo in the player GUI
	
	private int raceInt; //Used to change the Combo in the player GUI
	private Race race;
	private String name;
	
	private List<Item> playerInventory;
	private List<Weapon> playerWeapons;
	private List<Skill> playerSkills;
	
	private String[] skills = {"Appraise", "Autohypnosis", "Balance", "Bluff", 
			"Climb", "Concentration", "Craft", "Decipher Script", "Diplomacy",
			"Disable Device", "Disguise", "Escape Artist", "Forgery", 
			"Gather Information", "Handle Animal", "Heal", "Hide", 
			"Intimidate", "Jump", "Knowledge (Arcana)", 
			"Knowledge (Arch/Eng)", "Knowledge (Dungeoneering)", 
			"Knowledge (Geography)", "Knowledge (History)",
			"Knowledge (Local)", "Knowledge (Nature)", 
			"Knowledge (Nobility/Royalty)", "Knowledge (The Planes)", 
			"Knowledge (Psionics)", "Knowledge (Religion)",
			"Knowledge (Custom)", "Listen", "Move Silently", "Open Lock", 
			"Perform (Act)", "Perform (Comedy)", "Perform (Dance)", 
			"Perform (Keyboard)", "Perform (Oratory)", "Perform (Percussion)", 
			"Perform (String Instrument)", "Perform (Wind Instrument)", 
			"Perform (Sing)", "Perform (Custom)", "Profession", "Psicraft", 
			"Ride", "Search", "Sense Motive", "Sleight of Hand", "Spellcraft", 
			"Spot", "Survival", "Swim", "Tumble", "Use Magic Device", "Use Psionic Device", 
			"Use Rope"
	};
	
	private static boolean isActive;
	
	public Player(String name0) { 
		name = name0;
		playerInventory = new ArrayList<Item>();
		playerWeapons = new ArrayList<Weapon>();
		playerSkills = new ArrayList<Skill>();
		for(int i = 0; i < skills.length; i++) { 
			playerSkills.add(new res.Skill(skills[i]));
		}
	}
	
	public int getDexBonus() { return dexBonus; }
	public int getStrBonus() { return strBonus; } 
	public int getChaBonus() { return chaBonus; } 
	public int getConBonus() { return conBonus; } 
	public int getWisBonus() { return wisBonus; } 
	public int getIntBonus() { return intBonus; }
	
	public void setDexBonus(int i) { dexBonus = i; }
	public void setStrBonus(int i) { strBonus = i; } 
	public void setChaBonus(int i) { chaBonus = i; } 
	public void setConBonus(int i) { conBonus = i; }
	public void setWisBonus(int i) { wisBonus = i; } 
	public void setIntBonus(int i) { intBonus = i; }
	
	public int getWillpower() { return willpower; }
	public int getWillTemp() { return willTemp; }
	public int getWillMagic() { return willMagic; }
	public int getWillMisc() { return willMisc; }
	
	public void setWillpower(int i) { willpower = i; }
	public void setWillTemp(int i) { willTemp = i; }
	public void setWillMagic(int i) { willMagic = i; }
	public void setWillMisc(int i) { willMisc = i; }
	
	public int getReflex() { return reflex; }
	public int getRefTemp() { return refTemp; }
	public int getRefMagic() { return refMagic; }
	public int getRefMisc() { return refMisc; }
	
	public void setReflex(int i) { reflex = i; }
	public void setRefTemp(int i) { refTemp = i; }
	public void setRefMagic(int i) { refMagic = i; }
	public void setRefMisc(int i) { refMisc = i; }
	
	public int getFortitude() { return fortitude; }
	public int getFortTemp() { return fortTemp; } 
	public int getFortMagic() { return fortMagic; } 
	public int getFortMisc() { return fortMisc; } 
	
	public void setFortitude(int i) { fortitude = i; }
	public void setFortTemp(int i) { fortTemp = i; } 
	public void setFortMagic(int i) { fortMagic = i; } 
	public void setFortMisc(int i) { fortMisc = i; }
	
	public List<Skill> getPlayerSkills() { 
		return playerSkills;
	}
	
	public List<Weapon> getPlayerWeapons() { 
		return playerWeapons;
	}
	
	public List<Item> getPlayerInventory() { 
		return playerInventory;
	}
	
	public void setPlayerName(String s) { 
		name = s;
	}
	
	public int getRaceInt() { 
		return raceInt;
	}
	
	public void setRaceInt(int i) { 
		raceInt = i;
	}
	
	public int getAlignment() { 
		return alignmentInt;
	}
	
	public void setAlignment(int i) { 
		alignmentInt = i;
	}
	
	public void setClass0(int i) { 
		class0 = i;
	}
	
	public int getClass0() { 
		return class0;
	}
	
	public void setCurrentHP(int i) { 
		currentHP = i;
	}
	
	public int getCurrentHP() { 
		return currentHP;
	}
	
	public void setHeight(String s) { 
		height = s;
	}
	
	public String getHeight() { 
		return height;
	}
	
	public void setDiety(String s) { 
		diety = s;
	}
	
	public String getDiety() { 
		return diety;
	}
	
	public void setLevel(int i) { 
		level = i;
	}
	
	public int getLevel() { 
		return level;
	}
	
	public int getGender() { 
		return gender;
	}
	
	public void setGender(int i) { 
		gender = i;
	}
	
	public void setStr(int i) { 
		str = i;
	}
	
	public int getStr() { 
		return str;
	}
	
	public void setDex(int i) { 
		dex = i;
	}
	
	public int getDex() { 
		return dex;
	}
	
	public void setCon(int i) { 
		con = i;
	}
	
	public int getCon() { 
		return con;
	}
	
	public void setCha(int i) { 
		cha = i;
	}
	
	public int getCha() { 
		return cha;
	}
	
	public void setWis(int i) { 
		wis = i;
	}
	
	public int getWis() { 
		return wis;
	}
	
	public void setInt(int i) { 
		intel = i;
	}
	
	public int getInt() { 
		return intel;
	}
	
	public static boolean getActive() { 
		return isActive;
	}
	
	public static void setActive(boolean b) { 
		isActive = b;
	}
	
	public void setRace(Race race0) { 
		race = race0;
	}
	public void setSize(int size0) { 
		size = size0;
	}
	
	public void setAC(int ac) { 
		AC = ac;
	}
	
	public void setHP(int hp) { 
		HP = hp;
	}
	
	public String getName() { 
		return name;
	}
	
	public Race getRace() { 
		return race;
	}
	
	public int getSize() { 
		return size;
	}
	
	public int getAC() {
		return AC;
	}
	
	public int getHP() { 
		return HP;
	}
	
	public void calculateStats() { 
		
	}
}
