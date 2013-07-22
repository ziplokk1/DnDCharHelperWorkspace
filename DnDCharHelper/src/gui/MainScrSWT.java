package gui;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import res.Tools;

public class MainScrSWT {
	Display display;
	Shell shell;
	Button armor;
	Button weapon;
	Button items;
	Button character;
	
	public MainScrSWT() { 
		display = Main.display;
		shell = new Shell(display, SWT.CLOSE);
		shell.setText("Select Screen");
		shell.setLayout(new GridLayout(1, true));
		
		armor = new Button(shell, SWT.PUSH);
		armor.setText("Armor");
		armor.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		armor.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				new ArmorsSWT();
			}
		});
		
		weapon = new Button(shell, SWT.PUSH);
		weapon.setText("Weapon");
		weapon.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		weapon.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				new WeaponsSWT();
			}
		});
		
		items = new Button(shell, SWT.PUSH);
		items.setText("Items");
		items.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		items.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				new ItemsSWT();
			}
		});
		
		character = new Button(shell, SWT.PUSH);
		character.setText("Character");
		character.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		character.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				new CharScrSWT();
			}
		});
		
		shell.pack();
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		shell.setActive();
		while(!shell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
}
