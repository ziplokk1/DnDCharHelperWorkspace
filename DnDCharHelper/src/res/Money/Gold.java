package res.Money;


public class Gold extends Currency {

	public Gold(int amount) {
		super(amount * 100);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 100;
	}
}
