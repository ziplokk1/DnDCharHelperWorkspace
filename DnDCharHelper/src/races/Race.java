package races;

public class Race {
	
	private String raceName;
	
	int strBonus = 0;
	int dexBonus = 0;
	int chaBonus = 0;
	int conBonus = 0;
	int wisBonus = 0;
	int intBonus = 0;
	
	int size;
	int speed;
	
	public Race(String name) { 
		raceName = name;
	}
	
	public void setSize(int i) { 
		size = i;
	}
	
	public int getSize() { 
		return size;
	}
	
	public void setSpeed(int i) { 
		speed = i;
	}
	
	public int getSpeed() { 
		return speed;
	}
	
	public void setStrBonus(int i) { 
		strBonus = i;
	}
	
	public int getStrBonus() { 
		return strBonus;
	}
	
	public void setDexBonus(int i) { 
		dexBonus = i;
	}
	
	public int getDexBonus() { 
		return dexBonus;
	}
	
	public void setConBonus(int i) { 
		conBonus = i;
	}
	
	public int getConBonus() { 
		return conBonus;
	}
	
	public void setChaBonus(int i) { 
		chaBonus = i;
	}
	
	public int getChaBonus() { 
		return chaBonus;
	}
	
	public void setIntBonus(int i) { 
		intBonus = i;
	}
	
	public int getIntBonus() { 
		return intBonus;
	}
	
	public void setWisBonus(int i) { 
		wisBonus = i;
	}
	
	public int getWisBonus() { 
		return wisBonus;
	}
	
	public void setRaceName(String s) { 
		raceName = s;
	}
	
	public String getRaceName() { 
		return raceName;
	}
}
