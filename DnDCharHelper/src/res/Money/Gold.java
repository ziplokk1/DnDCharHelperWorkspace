package res.Money;

import java.io.Serializable;


public class Gold extends Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -911484072727737084L;

	public Gold(int amount) {
		super(amount * 100);
		// TODO Auto-generated constructor stub
	}
	
	public Gold() { 
		super(0);
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 100;
	}
}
