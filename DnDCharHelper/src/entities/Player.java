package entities;

import armor.Armor;
import races.Race;
import weapons.Weapon;
import main.Main;

public class Player {
	
	private int str;
	private int dex;
	private int con;
	private int cha;
	private int wis;
	private int intel;
	
	private Weapon equippedWeapon;
	private Armor equippedArmor;
	
	private int HP;
	private int AC;
	private int size;
	private String CLASS;
	private String alignment;
	private Race race;
	private String name;
	
	private static boolean isActive;
	
	public Player(String name0) { 
		name = name0;
	}
	
	public void setEquippedArmor(Armor a) { 
		equippedArmor = a;
	}
	
	public Armor getEquippedArmor() { 
		return equippedArmor;
	}
	
	public void setEquippedWeapon(Weapon w) { 
		equippedWeapon = w;
	}
	
	public Weapon getEquippedWeapon() { 
		return equippedWeapon;
	}
	
	public int getModifier(int i) { 
		if(i < Main.getBaseModifier()) { 
			i -= 1;
		}
		return (i - Main.getBaseModifier()) / 2;
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
	
	public int getDex(int i) { 
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
	
	public void setAlignment(String alignment0) { 
		alignment = alignment0;
	}
	
	public void setClass(String class0) { 
		CLASS = class0;
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
	
	public String getAlignment() { 
		return alignment;
	}
	
	public String getCharClass() { 
		return CLASS;
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
