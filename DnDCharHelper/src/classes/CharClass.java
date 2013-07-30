package classes;

import res.Dice;

public class CharClass {
	public Dice HIT_DIE;
	public int FORT_SAVE;
	public int REF_SAVE;
	public int WILL_SAVE;
	public String className;
	
	public CharClass(String className) { 
		this.className = className;
	}
	
	public void setFortSave(int i) { FORT_SAVE = i; }
	public void setRefSave(int i) { REF_SAVE = i; }
	public void setWillSave(int i) { WILL_SAVE = i; }
	
	public void setHitDie(Dice d) { HIT_DIE = d; }
}
