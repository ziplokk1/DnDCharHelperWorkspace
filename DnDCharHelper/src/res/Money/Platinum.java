package res.Money;


public class Platinum extends Currency {

	public Platinum(int amount) {
		super(amount * 1000);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 1000;
	}

}
