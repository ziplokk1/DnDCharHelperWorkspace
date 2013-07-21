package res;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Tools {

	public static Point CenterScreen(Display d, Shell s) { 
		int DISPLAY_WIDTH;
		int DISPLAY_HEIGHT;
		int SHELL_WIDTH;
		int SHELL_HEIGHT;
		
		DISPLAY_WIDTH = d.getClientArea().width;
		DISPLAY_HEIGHT = d.getClientArea().height;
		
		SHELL_WIDTH = s.getBounds().width;
		SHELL_HEIGHT = s.getBounds().height;
		
		int PtX = (DISPLAY_WIDTH / 2) - (SHELL_WIDTH / 2);
		int PtY = (DISPLAY_HEIGHT / 2) - (SHELL_HEIGHT / 2);
		return new Point(PtX, PtY);
	}
	
	public static String getSize(int i) { 
		switch(i) { 
		case 0:
			return "Fine";
		case 1:
			return "Diminuitive";
		case 2:
			return "Tiny";
		case 3:
			return "Small";
		case 4:
			return "Medium";
		case 5:
			return "Large";
		case 6:
			return "Huge";
		case 7:
			return "Gigantic";
		case 8:
			return "Colossal";
		}
		return null;
	}
	
	public static String convertDeciToPercent(Double d) { 
		if(d == 0.05D) { 
			return "5%";
		} else if (d == 0.1D) { 
			return "10%";
		} else if (d == 0.15D) { 
			return "15%";
		} else if (d == 0.2D) { 
			return "20%";
		} else if (d == 0.25D) { 
			return "25%";
		} else if (d == 0.3D) { 
			return "30%";
		} else if (d == 0.35D) { 
			return "35%";
		} else if (d == 0.4D) { 
			return "40%";
		} else if (d == 0.45D) { 
			return "45%";
		} else if (d == 0.5D) { 
			return "50%";
		} else if (d == 0.55D) { 
			return "55%";
		} else if (d == 0.6D) { 
			return "60%";
		} else if (d == 0.65D) { 
			return "65%";
		} else if (d == 0.7D) { 
			return "70%";
		} else if (d == 0.75D) { 
			return "75%";
		} else if (d == 0.8D) {
			return "80%";
		} else if (d == 0.85D) { 
			return "85%";
		} else if (d == 0.9D) { 
			return "90%";
		} else if (d == 0.95D) { 
			return "95%";
		} else if (d == 1.0D) { 
			return "100%";
		} else { 
			return "Error";
		}
	}
}
