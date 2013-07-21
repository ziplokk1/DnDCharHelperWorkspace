package gui;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import res.Tools;

public class CreateCharScreen {
	Display display;
	Shell shell;
	
	Composite basics;
	Text name;
	Text level;
	Combo race;
	Combo class0;
	Label size;
	
	
	public CreateCharScreen() { 
		display = Main.display;
		shell = new Shell(display);
		shell.setText("Character Creation");
		shell.setLayout(new GridLayout(1, false));
		
		CreateBasicsComposite();
		
		shell.setSize(600, 200);
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		while(!shell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
	
	private void CreateBasicsComposite() { 
		basics = new Composite(shell, SWT.BORDER);
		basics.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		basics.setLayout(new GridLayout(6, true));
		
		Label nameLabel = new Label(basics, SWT.CENTER);
		nameLabel.setText("Name:");
		nameLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		name = new Text(basics, SWT.BORDER);
		name.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label levelLabel = new Label(basics, SWT.CENTER);
		levelLabel.setText("Level:");
		levelLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		level = new Text(basics, SWT.BORDER);
		level.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label raceLabel = new Label(basics, SWT.CENTER);
		raceLabel.setText("Race:");
		raceLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		String[] races = {"Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human"};
		race = new Combo(basics, SWT.READ_ONLY);
		race.setLayoutData(new GridData(GridData.FILL_BOTH));
		race.setItems(races);
		
		
		Label classLabel = new Label(basics, SWT.CENTER);
		classLabel.setText("Class:");
		classLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		class0 = new Combo(basics, SWT.READ_ONLY);
		class0.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label sizeLabel = new Label(basics, SWT.CENTER);
		sizeLabel.setText("Size:");
		sizeLabel.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		size = new Label(basics, SWT.CENTER);
		size.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		race.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				int i = race.getSelectionIndex();
				if(i == 0 || i == 1 || i == 3 || i == 5 || i == 6) { 
					size.setText("Medium");
				} else { 
					size.setText("Small");
				}
			}
		});
	}
}
