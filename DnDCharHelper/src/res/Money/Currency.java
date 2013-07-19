package res.Money;

public class Currency {
	private int AMOUNT;
	
	public Currency(int amount) { 
		this.AMOUNT = amount;
	}
	
	public double ConvertTo(String type0) { 
		switch(type0) { 
		case "cp":
			return AMOUNT;
		case "sp":
			return AMOUNT / 10;
		case "gp":
			return AMOUNT / 100;
		case "pp":
			return AMOUNT / 1000;
		}
		return 0.0D;
	}
	
	public int getAmount() { 
		return AMOUNT;
	}
	
	public String getAmountAndType() { 
		String type = null;
		int amt = 0;
		
		if(this.getClass().equals(Copper.class)) { 
			type = "cp";
			amt = AMOUNT;
		} else if (this.getClass().equals(Silver.class)) { 
			type = "sp";
			amt = AMOUNT / 10;
		} else if (this.getClass().equals(Gold.class)) { 
			type = "gp";
			amt = AMOUNT / 100;
		} else if (this.getClass().equals(Platinum.class)) { 
			type = "pp";
			amt = AMOUNT / 1000;
		} else { 
			type = "err";
		}
		return Integer.toString(amt) + type;
	}
}
