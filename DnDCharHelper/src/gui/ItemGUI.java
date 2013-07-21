package gui;

import item.Item;

import java.util.List;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import res.Tools;

public class ItemGUI {
	Display display;
	Shell shell;
	
	ScrolledComposite sc;
	Composite c;
	
	Font f;
	
	public ItemGUI() { 
		display = Main.display;
		shell = new Shell(display);
		shell.setText("Items");
		shell.setLayout(new FillLayout());
		
		sc = new ScrolledComposite(shell, SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setAlwaysShowScrollBars(true);
		sc.setLayout(new FillLayout());
		
		c = new Composite(sc, SWT.NONE);
		c.setLayout(new GridLayout(3, false));
		
		for(int i = 0; i < 8; i++) { 
			switch(i) { 
			case 0:
				CreateLabels(Main.adventuringGear, "Adventuring Gear");
				break;
			case 1:
				CreateLabels(Main.specialSubstancesAndItems, "Special Substances and Items");
				break;
			case 2:
				CreateLabels(Main.toolsAndSmallKits, "Tools and Skill Kits");
				break;
			case 3:
				CreateLabels(Main.clothing, "Clothing");
				break;
			case 4:
				CreateLabels(Main.foodDrinkAndLodging, "Food, Drink, and Lodging");
				break;
			case 5: 
				CreateLabels(Main.mountsAndRelatedGear, "Mounts and Related Gear");
				break;
			case 6:
				CreateLabels(Main.transport, "Transport");
				break;
			case 7:
				CreateLabels(Main.spellcastingAndServices, "Spellcasting and Services");
				break;
			}
		}
		
		sc.setContent(c);
		sc.addControlListener(new ControlAdapter() { 
			@Override
			public void controlResized(ControlEvent e) { 
				org.eclipse.swt.graphics.Rectangle r = sc.getClientArea();
				sc.setMinSize(c.computeSize(r.width, SWT.DEFAULT));
			}
		});
		
		shell.pack();
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		while(!shell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}

	private void CreateLabels(List<Item> list, String title) { 
		Label lbl0 = new Label(c, SWT.BORDER | SWT.CENTER);
		lbl0.setText(title);
		GridData lblData0 = new GridData(GridData.FILL_HORIZONTAL);
		lblData0.horizontalSpan = 3;
		lbl0.setLayoutData(lblData0);
		Font initial = lbl0.getFont();
		FontData[] fontData = initial.getFontData();
		for(int x = 0; x < fontData.length; x++) { 
			fontData[x].setHeight(18);
		}
		
		f = new Font(display, fontData);
		lbl0.setFont(f);
		
		for(Item i : list) { 
			
			Label nameLabel = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			nameLabel.setText(i.getName());
			GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
			nameData.widthHint = 200;
			nameLabel.setLayoutData(nameData);
			
			Label costLabel = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			costLabel.setText(i.getCost().getAmountAndType());
			costLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			Label weightLabel = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			weightLabel.setText(Integer.toString(i.getWeight()) + " lbs.");
			weightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
	}
}
