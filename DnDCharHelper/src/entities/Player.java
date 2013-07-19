package entities;

public class Player {
	private int HP;
	private int AC;
	private int size;
	private String CLASS;
	private String alignment;
	private String race;
	private String name;
	private static boolean isActive;
	
	public static boolean getActive() { 
		return isActive;
	}
	
	public static void setActive(boolean b) { 
		isActive = b;
	}
	
	public void setRace(String race0) { 
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
	
	public String getRace() { 
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
	
	public Player(String name0) { 
		name = name0;
	}
}
