package gui;

import java.io.File;
import java.io.IOException;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;

import entities.Player;

import res.Tools;

public class MainScrSWT {
	Display display;
	Shell shell;
	Text characterName;
	Composite buttons;
	String charName;
	Button random;
	Button create;
	Button DM;
	Button open;
	
	public MainScrSWT() {
		
		Tools.CreateDnDFolder();
		
		display = Main.display;
		shell = new Shell(display, SWT.CLOSE);
		shell.setText("D&D 3.5 Character Helper");
		shell.setLayout(new GridLayout(1, true));
		
		Label label = new Label(shell, SWT.CENTER | SWT.WRAP);
		label.setText("Enter a character name");
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		characterName = new Text(shell, SWT.BORDER);
		characterName.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		/*
		 * Checks to see if the typed character name is already a player when enter is pressed
		 * if the name is already a player, it will load the character
		 * if not it will create a new one with the name.
		 */
		characterName.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyPressed(KeyEvent e) { 
				if(e.keyCode == 13) { 
					if(characterName.getText().isEmpty()) { 
						new EnterCharNameModal();
					} else { 
						File f = new File(System.getProperty("user.home") + 
								"/D&D Characters/" + 
								characterName.getText().toLowerCase() + ".dchar");
						if(f.isFile()) { 
							Open();
						} else { 
							Create();
						}
					}
				}
			}
		});
		
		CreateComposite();
		
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
	
	private void CreateComposite() { 
		buttons = new Composite(shell, SWT.NONE);
		buttons.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		buttons.setLayout(new GridLayout(4, true));
		
		DM = new Button(buttons, SWT.PUSH);
		DM.setText("DM Tools");
		DM.addSelectionListener(new ButtonListener());
		DM.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		random = new Button(buttons, SWT.PUSH);
		random.setText("Random");
		random.addSelectionListener(new ButtonListener());
		random.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		open = new Button(buttons, SWT.PUSH);
		open.setText("Open");
		open.addSelectionListener(new ButtonListener());
		open.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		create = new Button(buttons, SWT.PUSH);
		create.setText("Create");
		create.addSelectionListener(new ButtonListener());
		create.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	}
	
	private class ButtonListener implements SelectionListener {

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			Select(arg0.widget);
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			Select(arg0.widget);
		} 
		
		private void Select(Widget widget) { 
			Button b = (Button) widget;
			switch(b.getText()) { 
			case "DM Tools":
				
				break;
			case "Random":
				Random();
				break;
			case "Open":
				Open();
				break;
			case "Create":
				Create();
				break;
			}
		}
	}
	
	private void Random() { 
		CharScrSWT.isLoadingCharacter = true;
		if(!characterName.getText().isEmpty()) { 
			charName = characterName.getText().toLowerCase();
			shell.close();
			new CharScrSWT(Tools.CreateRandomPlayer(charName));
		} else { 
			new EnterCharNameModal();
		}
		
	}
	
	private void Open() { 
		CharScrSWT.isLoadingCharacter = true;
		if(!characterName.getText().isEmpty()) { 
			charName = characterName.getText().toLowerCase();
		}
		shell.close();
		try {
			Tools.LoadCharacter(charName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void Create() { 
		if(characterName.getText().isEmpty()) { 
			new EnterCharNameModal();
		} else { 
			charName = characterName.getText();
			shell.close();
			new CharScrSWT(new Player(charName));
		}
	}
	
	private class EnterCharNameModal { 
		Shell errShell = new Shell(display, SWT.APPLICATION_MODAL);
		public EnterCharNameModal() { 
			errShell.setText("Error");
			errShell.setLayout(new GridLayout(3, true));
			
			Label errorLabel = new Label(errShell, SWT.CENTER | SWT.WRAP);
			errorLabel.setText("Please enter a character name");
			GridData eld = new GridData(GridData.FILL_HORIZONTAL);
			eld.horizontalSpan = 3;
			errorLabel.setLayoutData(eld);
			
			Label space = new Label(errShell, SWT.NONE);
			Label space1 = new Label(errShell, SWT.NONE);
			
			Button ok = new Button(errShell, SWT.PUSH);
			ok.setText("Ok");
			ok.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			ok.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					errShell.close();
					shell.setActive();
				}
			});
			
			errShell.pack();
			errShell.setLocation(Tools.CenterScreen(display, errShell));
			errShell.open();
		}
		
	}
}
