package gui;

import main.Main;

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

import entities.Player;

import races.Race;
import res.Tools;

public class SWTCharScreen {
	Shell shell;
	Display display;
	org.eclipse.swt.widgets.List players;
	
	private Label charName;
	private Label charClass;
	private Label charLevel;
	private Label charSize;
	private Label charRace;
	
	public SWTCharScreen() { 
		display = Main.display;
		shell = new Shell(display);
		shell.setLayout(new GridLayout(2, false));
		shell.setText("Characters");
		
		CreatePlayerList();
		CreatePlayerBasics();
		
		shell.setSize(200, 200);
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		while(!shell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
	
	private void CreatePlayerBasics() { 
		final Composite playerBasics = new Composite(shell, SWT.NONE);
		playerBasics.setLayout(new GridLayout(3, true));
		GridData playerBasicsData = new GridData(GridData.FILL_BOTH);
		playerBasicsData.widthHint = 300;
		playerBasics.setLayoutData(playerBasicsData);
		
		charName = new Label(playerBasics, SWT.BORDER | SWT.CENTER);
		charName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		charClass = new Label(playerBasics, SWT.BORDER | SWT.CENTER);
		charClass.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		charLevel = new Label(playerBasics, SWT.BORDER | SWT.CENTER);
		charLevel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		charSize = new Label(playerBasics, SWT.BORDER | SWT.CENTER);
		charSize.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		charRace = new Label(playerBasics, SWT.BORDER | SWT.CENTER);
		charRace.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	private void CreatePlayerList() { 
		players = new org.eclipse.swt.widgets.List(shell, SWT.BORDER | SWT.V_SCROLL);
		for(Player p : Main.players) { 
			players.add(p.getName());
		}
		GridData playersData = new GridData(GridData.FILL_VERTICAL);
		playersData.widthHint = 70;
		players.setLayoutData(playersData);
		players.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				ActiveCharacter.setToActiveChar(Main.players.get(players.getSelectionIndex()));
				charName.setText(ActiveCharacter.getCharName());
				charClass.setText(ActiveCharacter.getCharClass());
				charLevel.setText(ActiveCharacter.getCharLevelToString());
				charSize.setText(ActiveCharacter.getCharSizeToString());
				charRace.setText(ActiveCharacter.getCharRace().getRaceName());
			}
		});
	}
}

class ActiveCharacter { 
	
	private static String charName;
	private static Race charRace;
	private static String charClass = "class goes here";
	private static int charLevel = 1;
	private static int charSize;
	
	public static void setToActiveChar(Player p) { 
		setCharName(p.getName());
		setCharRace(p.getRace());
		//setCharClass(p.getCharClass());
		setCharSize(p.getRace().getSize());
	}
	
	public static int getCharSize() { 
		return charSize;
	}
	
	public static String getCharSizeToString() { 
		return Tools.getSize(charSize);
	}
	
	public static void setCharSize(int i) { 
		charSize = i;
	}
	
	public static int getCharLevel() { 
		return charLevel;
	}
	
	public static String getCharLevelToString() { 
		return "lv. " + Integer.toString(charLevel);
	}
	
	public static void setCharLevel(int i) { 
		charLevel = i;
	}
	
	public static String getCharClass() { 
		return charClass;
	}
	
	public static void setCharClass(String s) { 
		charClass = s;
	}
	
	public static Race getCharRace() { 
		return charRace;
	}
	
	public static void setCharRace(Race s) { 
		charRace = s;
	}

	public static String getCharName() { 
		return charName;
	}
	
	public static void setCharName(String s) { 
		charName = s;
	}
	
}
