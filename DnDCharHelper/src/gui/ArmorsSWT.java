package gui;

import item.Item;

import java.util.List;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import armor.Armor;

public class ArmorsSWT {
	private Display display;
	private Shell armorShell;
	private ScrolledComposite armorSC;
	private Composite armorC;
	Menu add;
	MenuItem addItem;
	
	public ArmorsSWT() { 
		CreateArmorGui();
	}
	
	public void CreateArmorGui() { 
		display = Main.display;
		armorShell = new Shell(display);
		armorShell.setText("Armor");
		armorShell.setLayout(new GridLayout(1, true));
		
		armorSC = new ScrolledComposite(armorShell, SWT.V_SCROLL);
		armorSC.setLayoutData(new GridData(GridData.FILL_BOTH));
		armorSC.setLayout(new FillLayout());
		armorSC.setExpandHorizontal(true);
		armorSC.setExpandVertical(true);
		armorSC.setAlwaysShowScrollBars(true);
		
		armorC = new Composite(armorSC, SWT.NONE);
		armorC.setLayout(new GridLayout(8, true));
		
		String[] titles = {"Name", "Cost", "Armor Bonus", "Max Dex Bonus", "Armor Check Penalty", "Arcane Spell Failure", 
				"Speed", "Weight"};
		
		for(int i = 0; i < titles.length; i++) { 
			Label lblName = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			lblName.setText(titles[i]);
			lblName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		
		CreateLabels(Main.lightArmor, "Light Armor");
		CreateLabels(Main.mediumArmor, "Medium Armor");
		CreateLabels(Main.heavyArmor, "Heavy Armor");
		CreateLabels(Main.shields, "Shields");
		
		armorSC.setContent(armorC);
		armorSC.getVerticalBar().setIncrement(15);
		armorSC.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Tools.CheckResize(armorSC, armorC);
			}
		});
		
		armorShell.pack();
		armorShell.setLocation(Tools.CenterScreen(display, armorShell));
		armorShell.open();
		
		armorShell.setActive();
	}
	
	private void CreateLabels(List<Armor> list, String title) { 
		Label light = new Label(armorC, SWT.BORDER | SWT.CENTER);
		light.setText(title);
		GridData lightData = new GridData(GridData.FILL_HORIZONTAL);
		lightData.horizontalSpan = 8;
		light.setLayoutData(lightData);
		Font f = light.getFont();
		FontData[] fd = f.getFontData();
		for(int i = 0; i < fd.length; i++) { 
			fd[i].setHeight(16);
		}
		Font nf = new Font(display, fd);
		light.setFont(nf);
		light.setBackground(new Color(display, 255, 255, 255));
		
		for(Armor a : list) { 
			for(int i = 0; i < a.getBasics().length; i++) { 
				Label lbl = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setText(a.getBasics()[i]);
				
				/*
				 * set armor to label data for reference purposes.
				 */
				lbl.setData(a);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				lbl.addMouseListener(new MouseAdapter() { 
					@Override
					public void mouseDown(MouseEvent e) { 
						
						/*
						 * Create popup menu when mouse is right clicked
						 */
						if(e.button == 3) { 
							final Label label = (Label) e.widget;
							add = new Menu(label);
							
							/*
							 * add armor to inventory instead of equipping.
							 */
							addItem = new MenuItem(add, SWT.CASCADE);
							addItem.setText("Add To Inventory");
							addItem.addSelectionListener(new SelectionAdapter() { 
								@Override
								public void widgetSelected(SelectionEvent e) { 
									Item i = (Item) label.getData();
									System.out.println(i.getName());
								}
							});
							
							/*
							 * equip selected armor
							 */
							MenuItem addToActive = new MenuItem(add, SWT.CASCADE);
							addToActive.setText("Equip armor");
							addToActive.addSelectionListener(new SelectionAdapter() { 
								@Override
								public void widgetSelected(SelectionEvent e) { 
									Armor b = (Armor) label.getData();
									System.out.println(b.getName());
								}
							});
							label.setMenu(add);
						}
					}
				});
			}
		}
	}
}
