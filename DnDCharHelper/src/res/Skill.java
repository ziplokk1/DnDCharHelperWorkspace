package res;

public class Skill {
	private int ranks = 0;
	private String ability = null;
	private int abilMod = 0;
	private int miscMod = 0;
	private int total = 0;
	private String name;
	
	public Skill(String name) { 
		this.name = name;
	}
	
	public boolean isAbility(String abil) { 
		if(abil.equals(ability)) { 
			return true;
		} else { 
			return false;
		}
	}
	
	public void TotalSkill() { 
		total = ranks + abilMod + miscMod;
	}
	
	public String getName() { 
		return name;
	}
	
	public void setTotal(int i) { 
		total = i;
	}
	
	public int getTotal() { 
		return total;
	}
	
	public void setMiscMod(int i) { 
		miscMod = i;
	}
	
	public int getMiscMod() { 
		return miscMod;
	}
	
	public void setAbilityModifier(int i) { 
		abilMod = i;
	}
	
	public int getAbilityModifier() { 
		return abilMod;
	}
	
	public void setAbility(String s) { 
		ability = s;
	}
	
	public String getAbility() { 
		return ability;
	}
	
	public int getRanks() { 
		return ranks;
	}
	
	public void setRanks(int i) { 
		ranks = i;
	}
}
