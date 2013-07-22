package gui;

import item.Item;

import java.util.List;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

import res.Tools;

public class ItemsSWT {
	Display display;
	Shell shell;
	
	ScrolledComposite sc;
	Composite c;
	
	Menu addItemToInventory;
	MenuItem addItem;
	
	Font f;
	
	public ItemsSWT() { 
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
		
		CreateLabels(Main.adventuringGear, "Adventuring Gear");
		CreateLabels(Main.specialSubstancesAndItems, "Special Substances and Items");
		CreateLabels(Main.toolsAndSmallKits, "Tools and Skill Kits");
		CreateLabels(Main.clothing, "Clothing");
		CreateLabels(Main.foodDrinkAndLodging, "Food, Drink, and Lodging");
		CreateLabels(Main.mountsAndRelatedGear, "Mounts and Related Gear");
		CreateLabels(Main.transport, "Transport");
		CreateLabels(Main.spellcastingAndServices, "Spellcasting and Services");
		
		sc.setContent(c);
		sc.addControlListener(new ControlAdapter() { 
			@Override
			public void controlResized(ControlEvent e) { 
				Tools.CheckResize(sc, c);
			}
		});
		sc.getVerticalBar().setIncrement(15);
		
		shell.pack();
		shell.setSize(shell.getBounds().width, 500);
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		shell.setActive();
	}

	private void CreateLabels(List<Item> list, String title) { 
		Label lbl0 = new Label(c, SWT.BORDER | SWT.CENTER);
		lbl0.setText(title);
		GridData lblData0 = new GridData(GridData.FILL_HORIZONTAL);
		lblData0.horizontalSpan = 3;
		lbl0.setLayoutData(lblData0);
		Color white = new Color(display, 255, 255, 255);
		lbl0.setBackground(white);
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
			nameLabel.setData(i);
			nameLabel.addMouseListener(new PopUpListener());
			
			Label costLabel = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			costLabel.setText(i.getCost().getAmountAndType());
			costLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			costLabel.setData(i);
			costLabel.addMouseListener(new PopUpListener());
			
			Label weightLabel = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			weightLabel.setText(Integer.toString(i.getWeight()) + " lbs.");
			weightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			weightLabel.setData(i);
			weightLabel.addMouseListener(new PopUpListener());
		}
	}
	
	private class PopUpListener implements MouseListener {

		@Override
		public void mouseDoubleClick(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDown(MouseEvent arg0) {
			if(arg0.button == 3) { 
				final Label lbl = (Label) arg0.widget;
				addItemToInventory = new Menu(lbl);
				addItem = new MenuItem(addItemToInventory, SWT.CASCADE);
				addItem.setText("Add to Inventory");
				addItem.addSelectionListener(new SelectionAdapter() { 
					@Override
					public void widgetSelected(SelectionEvent e) { 
						Item i = (Item) lbl.getData();
						System.out.println(i.getName());
					}
				});
				lbl.setMenu(addItemToInventory);
			}
		}

		@Override
		public void mouseUp(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		} 
	}
}
