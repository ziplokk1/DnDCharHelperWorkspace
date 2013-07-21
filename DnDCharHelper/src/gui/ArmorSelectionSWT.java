package gui;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import res.Tools;
import armor.Armor;

public class ArmorSelectionSWT {
	private Display display;
	private Shell armorShell;
	
	public ArmorSelectionSWT() { 
		CreateArmorGui();
	}
	
	public void CreateArmorGui() { 
		display = Main.display;
		armorShell = new Shell(display);
		armorShell.setText("Armor");
		armorShell.setLayout(new GridLayout(1, true));
		
		final ScrolledComposite armorSC = new ScrolledComposite(armorShell, SWT.V_SCROLL);
		armorSC.setLayoutData(new GridData(GridData.FILL_BOTH));
		armorSC.setLayout(new FillLayout());
		armorSC.setExpandHorizontal(true);
		armorSC.setExpandVertical(true);
		armorSC.setAlwaysShowScrollBars(true);
		
		final Composite armorC = new Composite(armorSC, SWT.NONE);
		armorC.setLayout(new GridLayout(8, true));
		
		String[] titles = {"Name", "Cost", "Armor Bonus", "Max Dex Bonus", "Armor Check Penalty", "Arcane Spell Failure", 
				"Speed", "Weight"};
		
		for(int i = 0; i < titles.length; i++) { 
			Label lblName = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
			lblName.setText(titles[i]);
			lblName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		
		Label light = new Label(armorC, SWT.BORDER | SWT.CENTER);
		light.setText("Light Armor");
		GridData lightData = new GridData(GridData.FILL_HORIZONTAL);
		lightData.horizontalSpan = 8;
		light.setLayoutData(lightData);
		
		for(Armor a : Main.lightArmor) { 
			for(int i = 0; i < a.getBasics().length; i++) { 
				Label lbl = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setText(a.getBasics()[i]);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}
		
		Label medium = new Label(armorC, SWT.BORDER | SWT.CENTER);
		medium.setText("Medium Armor");
		GridData mediumData = new GridData(GridData.FILL_HORIZONTAL);
		mediumData.horizontalSpan = 8;
		medium.setLayoutData(mediumData);
		
		for(Armor a : Main.mediumArmor) { 
			for(int i = 0; i < a.getBasics().length; i++) { 
				Label lbl = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setText(a.getBasics()[i]);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}
	
		Label heavy = new Label(armorC, SWT.BORDER | SWT.CENTER);
		heavy.setText("Heavy Armor");
		GridData heavyData = new GridData(GridData.FILL_HORIZONTAL);
		heavyData.horizontalSpan = 8;
		heavy.setLayoutData(heavyData);
		
		for(Armor a : Main.heavyArmor) { 
			for(int i = 0; i < a.getBasics().length; i++) { 
				Label lbl = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setText(a.getBasics()[i]);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}
		
		Label shield = new Label(armorC, SWT.BORDER | SWT.CENTER);
		shield.setText("Shields");
		GridData shieldData = new GridData(GridData.FILL_HORIZONTAL);
		shieldData.horizontalSpan = 8;
		shield.setLayoutData(shieldData);
		
		for(Armor a : Main.shields) { 
			for(int i = 0; i < a.getBasics().length; i++) { 
				Label lbl = new Label(armorC, SWT.BORDER | SWT.CENTER | SWT.WRAP);
				lbl.setText(a.getBasics()[i]);
				lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
		}
		
		armorSC.setContent(armorC);
		armorSC.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				org.eclipse.swt.graphics.Rectangle r = armorSC.getClientArea();
				armorSC.setMinSize(armorC.computeSize(r.width, SWT.DEFAULT));
			}
		});
		
		armorShell.pack();
		armorShell.setLocation(Tools.CenterScreen(display, armorShell));
		armorShell.open();
		
		armorShell.setActive();
		armorShell.setFocus();
		
		while(!armorShell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
}
