package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class SWTCharScreen {
	Shell charShell;
	Display display;
	Composite characterBasics;
	org.eclipse.swt.widgets.List activePlayers;
	Label player;
	Label level;
	Label race;
	Label class0;
	
	public void setPlayerName(String s) { 
		player.setText(s);
		characterBasics.layout();
		charShell.layout();
		charShell.pack();
	}
	
	public void setPlayerLevel(int i) { 
		level.setText("Lv. " + Integer.toString(i));
	}
	
	public SWTCharScreen() { 
		display = new Display();
		charShell = new Shell(display);
		charShell.setText("Character");
		charShell.setLayout(new GridLayout(2, false));
		
		Composite activeCharactersComposite = new Composite(charShell, SWT.BORDER);
		activeCharactersComposite.setLayout(new FillLayout());
		activeCharactersComposite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_VERTICAL));
		
		activePlayers = new org.eclipse.swt.widgets.List(activeCharactersComposite, SWT.V_SCROLL);
		String[] characters = {"Mark", "Courtney", "Raney", "Maria", "Rosie"};
		activePlayers.setItems(characters);
		activePlayers.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				String[] selection = activePlayers.getSelection();
				setPlayerName(selection[0]);
			}
		});
		activePlayers.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseDown(MouseEvent e) { 
				if(e.button == 3) { 
					System.out.println("Right Click");
					Menu addPlayerMenu = new Menu(activePlayers);
					MenuItem addPlayer = new MenuItem(addPlayerMenu, SWT.CASCADE);
					addPlayer.setText("Add Player");
				}
			}
		});
		
		characterBasics = new Composite(charShell, SWT.BORDER);
		characterBasics.setLayout(new GridLayout(6, true));
		characterBasics.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL));
		
		player = new Label(characterBasics, SWT.BORDER | SWT.CENTER);
		player.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		level = new Label(characterBasics, SWT.BORDER | SWT.CENTER);
		level.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		setPlayerLevel(2);
		setPlayerName("Mark");
		
		charShell.setSize(new Point(200, 200));
		charShell.pack();
		charShell.open();
		while(!charShell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
}
