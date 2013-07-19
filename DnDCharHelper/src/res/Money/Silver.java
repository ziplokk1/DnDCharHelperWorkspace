package res.Money;


public class Silver extends Currency {

	public Silver(int amount) {
		super(amount * 10);
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 10;
	}
}
