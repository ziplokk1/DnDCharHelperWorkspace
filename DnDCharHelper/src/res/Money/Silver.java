package res.Money;

import java.io.Serializable;


public class Silver extends Currency implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8596551541749003654L;

	public Silver(int amount) {
		super(amount * 10);
	}
	
	public Silver() { 
		super(0);
	}
	
	@Override
	public int getAmount() { 
		return super.getAmount() / 10;
	}
}
