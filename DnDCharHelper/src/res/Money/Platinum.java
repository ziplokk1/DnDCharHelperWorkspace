package res.Money;

import java.io.Serializable;


public class Platinum extends Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9121111315516868961L;

	public Platinum(int amount) {
		super(amount * 1000);
		// TODO Auto-generated constructor stub
	}
	
	public Platinum() { 
		super(0);
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 1000;
	}

}
