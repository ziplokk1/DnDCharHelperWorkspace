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
import weapons.Weapon;

public class WeaponsSWT {
	Shell shell;
	Display display;
	ScrolledComposite sc;
	Composite c;
	Menu add;
	String[] headers = {"Weapon", "Cost", "Damage", "Critical", 
			"Range Increment", "Weight", "Type"};
	
	public WeaponsSWT() { 
		display = Main.display;
		shell = new Shell(display);
		shell.setText("Weapons");
		shell.setLayout(new FillLayout());
		
		sc = new ScrolledComposite(shell, SWT.V_SCROLL);
		sc.setExpandHorizontal(true);
		sc.setExpandVertical(true);
		sc.setAlwaysShowScrollBars(true);
		sc.getVerticalBar().setIncrement(15);
		sc.setLayout(new FillLayout());
		
		c = new Composite(sc, SWT.NONE);
		c.setLayout(new GridLayout(7, true));
		
		for(int i = 0; i < headers.length; i++) { 
			Label lbl = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			lbl.setText(headers[i]);
		}
		
		CreateLabels(Main.simpleWeapons, "Simple");
		CreateLabels(Main.martialWeapons, "Martial");
		CreateLabels(Main.exoticWeapons, "Exotic");
		
		sc.setContent(c);
		sc.addControlListener(new ControlAdapter() { 
			@Override
			public void controlResized(ControlEvent e) { 
				Tools.CheckResize(sc, c);
			}
		});
		
		shell.pack();
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		shell.setActive();
	}
	
	private void CreateLabels(List<Weapon> list, String title) { 
		Label header = new Label(c, SWT.BORDER | SWT.CENTER);
		header.setText(title);
		GridData headerData = new GridData(GridData.FILL_HORIZONTAL);
		headerData.horizontalSpan = 7;
		header.setLayoutData(headerData);
		Font f = header.getFont();
		FontData[] fd = f.getFontData();
		for(int i = 0; i < fd.length; i++) { 
			fd[i].setHeight(16);
		}
		Font nf = new Font(display, fd);
		header.setFont(nf);
		header.setBackground(new Color(display, 255, 255, 255));
		
		for(Weapon w : list) { 
			w.setBasics();
			for(String s : w.getBasics()) { 
				final Label lbl = new Label(c, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				lbl.setText(s);
				lbl.setData(w);
				lbl.addMouseListener(new MouseAdapter() { 
					@Override
					public void mouseDown(MouseEvent e) { 
						if(e.button == 3) { 
							final Label label = (Label) e.widget;
							add = new Menu(label);
							MenuItem addInventory = new MenuItem(add, SWT.CASCADE);
							addInventory.setText("Add to inventory");
							addInventory.addSelectionListener(new SelectionAdapter() { 
								@Override
								public void widgetSelected(SelectionEvent e) { 
									Item wpn = (Item) label.getData();
									System.out.println(wpn.getName());
								}
							});
							
							MenuItem equip = new MenuItem(add, SWT.CASCADE);
							equip.setText("Equip weapon");
							equip.addSelectionListener(new SelectionAdapter() { 
								@Override
								public void widgetSelected(SelectionEvent e) { 
									Weapon wpn = (Weapon) lbl.getData();
									System.out.println(wpn.getName());
								}
							});
							
							lbl.setMenu(add);
						}
					}
				});
			}
		}
	}
}
