package gui;

import item.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import entities.Player;
import races.*;

import res.Tools;
import weapons.Weapon;

public class CharScrSWT {
	
	Display display;
	Shell shell;
	Group HP;
	Spinner currentHP;
	int hp = 0;
	Label skillTotal;
	Text skillRanks;
	Label abilMod;
	Label miscMod;
	Label currentSkill;
	res.Skill activeSkill;
	Equipment equipment;
	public static boolean isLoadingCharacter = false;
	
	private static Label inventoryWeightTotal;
	public static org.eclipse.swt.widgets.List weaponsList;
	
	public static org.eclipse.swt.widgets.List inventoryList;
	private Label selectedItem;
	private Label selectedItemWeight;
	private Label selectedItemValue;
	private Spinner selectedItemCount;
	private Player character;
	private Abilities abil;
	
	public CharScrSWT(Player player) { 
		character = player;
		display = Main.display;
		shell = new Shell(display);
		shell.setText("Character");
		shell.setLayout(new GridLayout(4, false));

		Basics basics = new Basics(shell, SWT.BORDER);
		basics.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		basics.setName(player.getName());
		
		createHP();
		setHP(0);
		
		CreateSkillTable();
		
		CreateInventory();
		
		abil = new Abilities(shell, SWT.BORDER);
		GridData abilData = new GridData(GridData.FILL_HORIZONTAL);
		abilData.horizontalSpan = 2;
		abil.setLayoutData(abilData);
		
		Label space = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData spaceData = new GridData(GridData.FILL_HORIZONTAL);
		spaceData.horizontalSpan = 3;
		space.setLayoutData(spaceData);
		
		Saves saves = new Saves(shell, SWT.BORDER);
		saves.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		CreateWeaponList();
		
		equipment = new Equipment(shell, SWT.BORDER);
		
		CreateMenu();
		
		if(isLoadingCharacter) { 
			basics.setName(character.getName());
			basics.setAlignment(character.getAlignment());
			basics.setClass(character.getClass0());
			basics.setDiety(character.getDiety());
			basics.setGender(character.getGender());
			basics.setHeight(character.getHeight());
			basics.setLevel(character.getLevel());
			basics.setRace(character.getRaceInt());
			basics.setSize(character.getSize());
			
			setHP(character.getHP());
			currentHP.setSelection(character.getCurrentHP());
			
			
			abil.chaBase.setText(Integer.toString(character.getCha()));
			abil.chaBase.setData(character.getCha());
			
			abil.conBase.setText(Integer.toString(character.getCon()));
			abil.conBase.setData(character.getCon());
			
			abil.dexBase.setText(Integer.toString(character.getDex()));
			abil.dexBase.setData(character.getDex());
			
			abil.intBase.setText(Integer.toString(character.getInt()));
			abil.intBase.setData(character.getInt());
			
			abil.strBase.setText(Integer.toString(character.getInt()));
			abil.strBase.setData(character.getStr());
			
			abil.wisBase.setText(Integer.toString(character.getWis()));
			abil.wisBase.setData(character.getWis());
			
			abil.getRaceStats(character.getRace());
			
		}
		
		/*
		 * Uncomment to print shell size upon resizing shell
		 */
		shell.addControlListener(new ControlAdapter() { 
			@Override
			public void controlResized(ControlEvent e) { 
				System.out.println(shell.getSize());
			}
		});
		
		shell.pack();
		shell.setSize(1030, 560);
		shell.setLocation(Tools.CenterScreen(display, shell));
		shell.open();
		shell.setActive();
		while(!shell.isDisposed()) { 
			if(!display.readAndDispatch()) { 
				display.sleep();
			}
		}
	}
	
	/*
	 * Creates a list with all the players inventory.
	 * Select an item to show details about the item.
	 */
	private Item item;
	
	private void CreateInventory() { 
		final Group inventoryGroup = new Group(shell, SWT.NONE);
		inventoryGroup.setLayout(new GridLayout(3, true));
		GridData igd = new GridData(GridData.FILL_BOTH);
		igd.verticalSpan = 5;
		igd.minimumWidth = 200;
		inventoryGroup.setText("Inventory");
		inventoryGroup.setLayoutData(igd);
		
		inventoryWeightTotal = new Label(inventoryGroup, SWT.NONE);
		GridData iwtd = new GridData(GridData.FILL_HORIZONTAL);
		iwtd.horizontalSpan = 3;
		inventoryWeightTotal.setLayoutData(iwtd);
		int weightTotal = 0;
		inventoryWeightTotal.setData(weightTotal);
		inventoryWeightTotal.setForeground(new Color(display, 0, 150, 0));
		
		inventoryList = new org.eclipse.swt.widgets.List(inventoryGroup, SWT.BORDER | SWT.V_SCROLL);
		GridData ild = new GridData(GridData.FILL_BOTH);
		ild.horizontalSpan = 3;
		inventoryList.setLayoutData(ild);
		
		for(Item item : character.getPlayerInventory()) { 
			inventoryList.add(item.getName());
			setInventoryWeightTotal(item.getWeight());
		}
		
		
		inventoryList.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				int index = inventoryList.getSelectionIndex();
				item = character.getPlayerInventory().get(index);
				selectedItem.setText(item.getName());
				selectedItemWeight.setText(Integer.toString(item.getWeight()) + " lbs.");
				selectedItemValue.setText(item.getCost().getAmountAndType());
				selectedItemCount.setSelection(item.getQuantity());
				inventoryGroup.layout();
			}
		});
		
		selectedItem = new Label(inventoryGroup, SWT.CENTER | SWT.WRAP);
		GridData sid = new GridData(GridData.FILL_HORIZONTAL);
		sid.horizontalSpan = 3;
		selectedItem.setForeground(new Color(display, 255, 0, 0));
		selectedItem.setLayoutData(sid);
		
		Label weightLabel = new Label(inventoryGroup, SWT.CENTER);
		weightLabel.setText("Weight");
		weightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label valueLabel = new Label(inventoryGroup, SWT.CENTER);
		valueLabel.setText("Value");
		valueLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label countLabel = new Label(inventoryGroup, SWT.CENTER);
		countLabel.setText("Qty.");
		countLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label space = new Label(inventoryGroup, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData spaceData = new GridData(GridData.FILL_HORIZONTAL);
		spaceData.horizontalSpan = 3;
		space.setLayoutData(spaceData);
		
		selectedItemWeight = new Label(inventoryGroup, SWT.CENTER);
		selectedItemWeight.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		selectedItemValue = new Label(inventoryGroup, SWT.CENTER);
		selectedItemValue.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		selectedItemCount = new Spinner(inventoryGroup, SWT.BORDER);
		selectedItemCount.setMinimum(1);
		selectedItemCount.setMaximum(99999);
		selectedItemCount.setIncrement(1);
		selectedItemCount.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectedItemCount.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				item.setQuantity(selectedItemCount.getSelection());
			}
		});
	}
	
	/*
	 * Sets the text of the inventory group to display the total weight of the 
	 * players inventory.
	 */
	public static void setInventoryWeightTotal(int i) { 
		int previousWeight = (int) inventoryWeightTotal.getData();
		int weightTotal = previousWeight + i;
		inventoryWeightTotal.setData(weightTotal);
		inventoryWeightTotal.setText("Weight Total: " + Integer.toString(weightTotal));
	}
	
	/*
	 * Creates a list of the players weapons.
	 * Select a weapon to view weapon details.
	 */
	private void CreateWeaponList() { 
		Group weaponsGroup = new Group(shell, SWT.NONE);
		weaponsGroup.setLayout(new FillLayout());
		GridData wld = new GridData(GridData.FILL_BOTH);
		wld.horizontalSpan = 2;
		weaponsGroup.setText("Weapons");
		weaponsGroup.setLayoutData(wld);
		
		weaponsList = new org.eclipse.swt.widgets.List(weaponsGroup, SWT.V_SCROLL | SWT.BORDER);
		
		/*
		 * Replace list with players weapons
		 */
		for(Weapon w : character.getPlayerWeapons()) { 
			weaponsList.add(w.getName());
		}
		
		weaponsList.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				if(weaponsList.getSelectionIndex() != -1) {
					int index = weaponsList.getSelectionIndex();
					
					/*
					 * Replace list with players weapons
					 */
					
					Weapon weapon = character.getPlayerWeapons().get(index);
					equipment.setWeapon(weapon.getName());
					equipment.setAttackBonus("-");
					equipment.setDamage(weapon.getDamage(character.getRace().getSize()));
					equipment.setCritical(weapon.getCrits());
					equipment.setRange(weapon.getRangeIncrement());
					equipment.setType(weapon.getType());
					equipment.layout();
				}
			}
		});
	}
	
	/*
	 * Creates the bar menu at the top of the shell.
	 */
	private void CreateMenu() { 
		Menu topMenu = new Menu(shell, SWT.BAR);
		Menu fileMenu = new Menu(topMenu);
		Menu resourcesMenu = new Menu(topMenu);
		Menu editMenu = new Menu(topMenu);
		
		MenuItem fileItem = new MenuItem(topMenu, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setMenu(fileMenu);
		
		MenuItem newItem = new MenuItem(fileMenu, SWT.CASCADE);
		newItem.setText("New");
		
		MenuItem openItem = new MenuItem(fileMenu, SWT.CASCADE);
		openItem.setText("Open");
		openItem.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				try {
					Tools.LoadCharacter();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		MenuItem saveItem = new MenuItem(fileMenu, SWT.CASCADE);
		saveItem.setText("Save");
		saveItem.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				try {
					Tools.SaveCharacter(character);
				} catch (FileNotFoundException e1) {
					System.out.println("File not found");
					System.err.println(e1.getMessage());
				} catch (IOException e1) {
					System.out.println("IOException");
					System.err.println(e1.getMessage());
				}
			}
		});
		
		MenuItem editItem = new MenuItem(topMenu, SWT.CASCADE);
		editItem.setText("Edit");
		editItem.setMenu(editMenu);
		
		Menu HPMenu = new Menu(editItem);
		MenuItem editHP = new MenuItem(editMenu, SWT.CASCADE);
		editHP.setText("Edit HP");
		editHP.setMenu(HPMenu);
		
		MenuItem setHP = new MenuItem(HPMenu, SWT.CASCADE);
		setHP.setText("Set HP");
		setHP.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				final Shell editHPShell = new Shell(display);
				editHPShell.setText("Edit HP");
				editHPShell.setLayout(new GridLayout(3, true));
				
				Label label = new Label(editHPShell, SWT.CENTER);
				GridData labelData = new GridData(GridData.FILL_HORIZONTAL);
				labelData.horizontalSpan = 3;
				label.setText("Enter character HP");
				label.setLayoutData(labelData);
				
				final Text space3 = new Text(editHPShell, SWT.BORDER);
				GridData space3Data = new GridData(GridData.FILL_HORIZONTAL);
				space3Data.horizontalSpan = 2;
				space3.addListener(SWT.Verify, new VerifyListener());
				space3.setLayoutData(space3Data);
				
				Button ok = new Button(editHPShell, SWT.PUSH);
				ok.setText("Submit");
				ok.addSelectionListener(new SelectionAdapter() { 
					@Override
					public void widgetSelected(SelectionEvent e) { 
						if(!space3.getText().isEmpty()) { 
							character.setHP(Integer.parseInt(space3.getText()));
							setHP(Integer.parseInt(space3.getText()));
						} else { 
							setHP(character.getHP());
						}
						editHPShell.close();
					}
				});
				
				ok.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				
				editHPShell.pack();
				editHPShell.setLocation(Tools.CenterScreen(display, editHPShell));
				editHPShell.open();
			}
		});
		
		MenuItem rollHP = new MenuItem(HPMenu, SWT.CASCADE);
		rollHP.setText("Roll HP");
		rollHP.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				
			}
		});
		
		MenuItem windowsItem = new MenuItem(topMenu, SWT.CASCADE);
		windowsItem.setText("Windows");
		
		MenuItem resourcesItem = new MenuItem(topMenu, SWT.CASCADE);
		resourcesItem.setText("Resources");
		resourcesItem.setMenu(resourcesMenu);
		
		MenuItem armorItem = new MenuItem(resourcesMenu, SWT.CASCADE);
		armorItem.setText("Armor");
		armorItem.addSelectionListener(new ResourcesSelection());
		
		MenuItem weaponsItem = new MenuItem(resourcesMenu, SWT.CASCADE);
		weaponsItem.setText("Weapons");
		weaponsItem.addSelectionListener(new ResourcesSelection());
		
		MenuItem itemsItem = new MenuItem(resourcesMenu, SWT.CASCADE);
		itemsItem.setText("Items");
		itemsItem.addSelectionListener(new ResourcesSelection());
		
		
		shell.setMenuBar(topMenu);
	}
	
	/*
	 * A simple selection listener for the menu items.
	 */
	private class ResourcesSelection implements SelectionListener {

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			MenuItem item = (MenuItem) arg0.widget;
			switch(item.getText()) { 
			case "Armor":
				new ArmorsSWT();
				break;
			case "Weapons":
				new WeaponsSWT(character);
				break;
			case "Items":
				new ItemsSWT(character);
				break;
			}
		} 
		
	}
	
	/*
	 * Creates a list with all skills. Select a skill to view details.
	 */
	private void CreateSkillTable() { 
		
		final Group skillGroup = new Group(shell, SWT.NONE);
		skillGroup.setText("Skills");
		skillGroup.setLayout(new GridLayout(4, true));
		
		GridData skillListData = new GridData(GridData.FILL_BOTH);
		skillListData.widthHint = 160;
		skillListData.minimumWidth = 160;
		skillListData.verticalSpan = 2;
		
		skillGroup.setLayoutData(skillListData);
		
		final org.eclipse.swt.widgets.List skillList = new org.eclipse.swt.widgets.List(skillGroup, SWT.V_SCROLL | SWT.BORDER);
		String[] skills = {"Appraise", "Autohypnosis", "Balance", "Bluff", 
				"Climb", "Concentration", "Craft", "Decipher Script", "Diplomacy",
				"Disable Device", "Disguise", "Escape Artist", "Forgery", 
				"Gather Information", "Handle Animal", "Heal", "Hide", 
				"Intimidate", "Jump", "Knowledge (Arcana)", 
				"Knowledge (Arch/Eng)", "Knowledge (Dungeoneering)", 
				"Knowledge (Geography)", "Knowledge (History)",
				"Knowledge (Local)", "Knowledge (Nature)", 
				"Knowledge (Nobility/Royalty)", "Knowledge (The Planes)", 
				"Knowledge (Psionics)", "Knowledge (Religion)",
				"Knowledge (Custom)", "Listen", "Move Silently", "Open Lock", 
				"Perform (Act)", "Perform (Comedy)", "Perform (Dance)", 
				"Perform (Keyboard)", "Perform (Oratory)", "Perform (Percussion)", 
				"Perform (String Instrument)", "Perform (Wind Instrument)", 
				"Perform (Sing)", "Perform (Custom)", "Profession", "Psicraft", 
				"Ride", "Search", "Sense Motive", "Sleight of Hand", "Spellcraft", 
				"Spot", "Survival", "Swim", "Tumble", "Use Magic Device", "Use Psionic Device", 
				"Use Rope"
		};
		skillList.setItems(skills);
		GridData skd = new GridData(GridData.FILL_BOTH);
		skd.horizontalSpan = 4;
		skillList.setLayoutData(skd);
		
		//A Label to display the name of the selected skill.
		currentSkill = new Label(skillGroup, SWT.CENTER | SWT.BOLD | SWT.WRAP);
		GridData csd = new GridData(GridData.FILL_HORIZONTAL);
		csd.horizontalSpan = 4;
		currentSkill.setLayoutData(csd);
		currentSkill.setForeground(new Color(display, 255, 0, 0));
		
		skillList.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				currentSkill.setText(skillList.getItem(skillList.getSelectionIndex()));
				activeSkill = character.getPlayerSkills().get(skillList.getSelectionIndex());
				skillTotal.setText(Integer.toString(activeSkill.getTotal()));
				skillRanks.setText(Integer.toString(activeSkill.getRanks()));
				abilMod.setText(Integer.toString(activeSkill.getAbilityModifier()));
				miscMod.setText(Integer.toString(activeSkill.getMiscMod()));
				skillGroup.layout();
			}
		});
		
		String[] headers = {"Total", "Ranks", "Abil", "Misc."};
		for(int i = 0; i < headers.length; i++) { 
			Label lbl = new Label(skillGroup, SWT.CENTER | SWT.WRAP);
			lbl.setText(headers[i]);
			lbl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
		
		Label separator = new Label(skillGroup, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData separatorData = new GridData(GridData.FILL_HORIZONTAL);
		separatorData.horizontalSpan = 4;
		separator.setLayoutData(separatorData);
		
		skillTotal = new Label(skillGroup, SWT.BORDER | SWT.CENTER);
		skillTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		skillRanks = new Text(skillGroup, SWT.BORDER | SWT.CENTER);
		skillRanks.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		skillRanks.addListener(SWT.Verify, new Listener() { //Verify input as digits
			@Override
		    public void handleEvent(Event e) {
				String string = e.text;
				char[] chars = new char[string.length()];
				string.getChars(0, chars.length, chars, 0);
				for (int i = 0; i < chars.length; i++) {
					if (!('0' <= chars[i] && chars[i] <= '9')) {
						e.doit = false;
						return;
					}
				}
		    }
	    });
		
		/*
		 * This modify listener will total up the ability modifier, 
		 * ranks, and bonuses, and calculate the total and modifier 
		 * for the selected skill.
		 */
		skillRanks.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				if(!skillRanks.getText().isEmpty() && activeSkill != null) { 
					activeSkill.setRanks(Integer.parseInt(skillRanks.getText()));
					activeSkill.TotalSkill();
					skillTotal.setText(Integer.toString(activeSkill.getTotal()));
				}
			} 
		});
		
		abilMod = new Label(skillGroup, SWT.NONE | SWT.CENTER);
		abilMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		miscMod = new Label(skillGroup, SWT.NONE | SWT.CENTER);
		miscMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
	}
	
	/*
	 * Creates a group composite which displays the characters 
	 * max HP as well as a spinner for current HP.
	 */
	private void createHP() { 
		HP = new Group(shell, SWT.NONE);
		GridData hpData = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
		hpData.widthHint = 100;
		hpData.minimumWidth = 100;
		HP.setLayoutData(hpData);
		HP.setLayout(new GridLayout(1, false));
		
		Label currentLabel = new Label(HP, SWT.CENTER);
		currentLabel.setText("Current HP:");
		currentLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		currentHP = new Spinner(HP, SWT.BORDER);
		currentHP.setMinimum(-10);
		currentHP.setMaximum(hp);
		currentHP.setIncrement(1);
		currentHP.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		/*
		 * Sets currentHP text color to display red when character is bleeding out.
		 */
		currentHP.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				Color red = new Color(display, 255, 0, 0);
				Color black = new Color(display, 0, 0, 0);
				if(currentHP.getSelection() < 0) { 
					currentHP.setForeground(red);
				} else { 
					currentHP.setForeground(black);
				}
				character.setCurrentHP(currentHP.getSelection());
			}
		});
	}
	
	/*
	 * Sets the HP Group's text to display the players max HP.
	 */
	public void setHP(int i) { 
		hp = i;
		HP.setText("Max HP: " + Integer.toString(i));
		currentHP.setMaximum(i);
	}
	
	/*
	 * Create saves composite
	 */
	private class Saves extends Composite {
		
		Label fortTotal;
		Label fortBase;
		Label fortMod;
		Text fortMagic;
		Text fortMisc;
		Text fortTemp;
		
		Label refTotal;
		Label refBase;
		Label refMod;
		Text refMagic;
		Text refMisc;
		Text refTemp;
		
		Label willTotal;
		Label willBase;
		Label willMod;
		Text willMagic;
		Text willMisc;
		Text willTemp;
		
		String[] headers = {"", "Total", "Base", "Ability", "Magic", "Misc", "Temp"};
		
		public Saves(Composite arg0, int arg1) {
			super(arg0, arg1);
			setLayout(new GridLayout(7, true));
			CreateLabels();
		} 
		
		private void CreateLabels() { 
			
			for(int i = 0; i < headers.length; i++) { 
				Label header = new Label(this, SWT.CENTER);
				header.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				header.setText(headers[i]);
			}
			
			Label separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
			GridData separatorData = new GridData(GridData.FILL_HORIZONTAL);
			separatorData.horizontalSpan = 7;
			separator.setLayoutData(separatorData);
			
			Label fort = new Label(this, SWT.CENTER);
			fort.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fort.setText("Fortitude:");
			
			fortTotal = new Label(this, SWT.CENTER | SWT.BORDER);
			fortTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			fortBase = new Label(this, SWT.CENTER);
			fortBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			fortMod = new Label(this, SWT.CENTER);
			fortMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			fortMagic = new Text(this, SWT.CENTER | SWT.BORDER);
			fortMagic.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fortMagic.addListener(SWT.Verify, new VerifyListener());
			fortMagic.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					if(!fortMagic.getText().isEmpty()) {
						character.setFortMagic(Integer.parseInt(fortMagic.getText()));
					} else { 
						character.setFortMagic(0);
					}
				} 
			});
			
			fortMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			fortMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fortMisc.addListener(SWT.Verify, new VerifyListener());
			fortMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!fortMisc.getText().isEmpty()) { 
						character.setFortMisc(Integer.parseInt(fortMisc.getText()));
					} else { 
						character.setFortMisc(0);
					}
				} 
			});
			
			fortTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			fortTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fortTemp.addListener(SWT.Verify, new VerifyListener());
			fortTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!fortTemp.getText().isEmpty()) { 
						character.setFortTemp(Integer.parseInt(fortTemp.getText()));
					} else { 
						character.setFortTemp(0);
					}
				} 
			});
			
			
			
			Label ref = new Label(this, SWT.CENTER);
			ref.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			ref.setText("Reflex:");
			
			refTotal = new Label(this, SWT.CENTER | SWT.BORDER);
			refTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			refBase = new Label(this, SWT.CENTER);
			refBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			refMod = new Label(this, SWT.CENTER);
			refMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			refMagic = new Text(this, SWT.CENTER | SWT.BORDER);
			refMagic.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			refMagic.addListener(SWT.Verify, new VerifyListener());
			refMagic.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!refMagic.getText().isEmpty()) { 
						character.setRefMagic(Integer.parseInt(refMagic.getText()));
					} else { 
						character.setRefMagic(0);
					}
				} 
			});
			
			refMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			refMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			refMisc.addListener(SWT.Verify, new VerifyListener());
			refMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!refMisc.getText().isEmpty()) { 
						character.setRefMisc(Integer.parseInt(refMisc.getText()));
					} else { 
						character.setRefMisc(0);
					}
				} 
			});
			
			refTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			refTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			refTemp.addListener(SWT.Verify, new VerifyListener());
			refTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!refTemp.getText().isEmpty()) { 
						character.setRefTemp(Integer.parseInt(refTemp.getText()));
					} else { 
						character.setRefTemp(0);
					}
				} 
			});
			
			
			
			Label will = new Label(this, SWT.CENTER);
			will.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			will.setText("Willpower:");
			
			willTotal = new Label(this, SWT.CENTER | SWT.BORDER);
			willTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			willBase = new Label(this, SWT.CENTER);
			willBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			willMod = new Label(this, SWT.CENTER);
			willMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			willMagic = new Text(this, SWT.CENTER | SWT.BORDER);
			willMagic.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			willMagic.addListener(SWT.Verify, new VerifyListener());
			willMagic.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!willMagic.getText().isEmpty()) { 
						character.setWillMagic(Integer.parseInt(willMagic.getText()));
					} else { 
						character.setWillMagic(0);
					}
				} 
			});
			
			willMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			willMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			willMisc.addListener(SWT.Verify, new VerifyListener());
			willMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!willMisc.getText().isEmpty()) { 
						character.setWillMisc(Integer.parseInt(willMisc.getText()));
					} else { 
						character.setWillMisc(0);
					}
				} 
			});
			
			willTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			willTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			willTemp.addListener(SWT.Verify, new VerifyListener());
			willTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					
					if(!willTemp.getText().isEmpty()) { 
						character.setWillTemp(Integer.parseInt(willTemp.getText()));
					} else { 
						character.setWillTemp(0);
					}
				} 
			});
		}
	}
	
	/*
	 * A simple VerifyListener to confirm that text entry is digits.
	 */
	private class VerifyListener implements Listener { 
		@Override
	    public void handleEvent(Event e) {
			String string = e.text;
			char[] chars = new char[string.length()];
			string.getChars(0, chars.length, chars, 0);
			for (int i = 0; i < chars.length; i++) {
				if (!('0' <= chars[i] && chars[i] <= '9')) {
					e.doit = false;
					return;
				}
			}
	    }
	}
	
	private class Equipment extends Composite {
		
		private Label weapon0;
		private Label atkBonus0;
		private Label damage0;
		private Label critical0;
		private Label range0;
		private Label type0;
		private Text ammo0;
		
		public void setType(String s) { 
			type0.setText(s);
		}
		
		public void setRange(String s) { 
			range0.setText(s);
		}
		
		public void setCritical(String s) { 
			critical0.setText(s);
		}
		
		public void setDamage(String s) { 
			damage0.setText(s);
		}
		
		public void setWeapon(String s) { 
			weapon0.setText(s);
		}
		
		public void setAttackBonus(String s) { 
			atkBonus0.setText(s);
		}

		public Equipment(Composite arg0, int arg1) {
			super(arg0, arg1);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.horizontalSpan = 3;
			setLayoutData(gd);
			setLayout(new GridLayout(7, true));
			CreateLabels();
		}
		
		private void CreateLabels() { 
			String[] headers = {"Weapon", "Attack Bonus", "Damage", 
					"Critical", "Range Increment", "Type", "Ammunition"};
			
			for(int i = 0; i < headers.length; i++) { 
				Label header = new Label(this, SWT.CENTER | SWT.WRAP);
				header.setText(headers[i]);
				header.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
			
			Label divider0 = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
			GridData dv0 = new GridData(GridData.FILL_HORIZONTAL);
			dv0.horizontalSpan = 7;
			divider0.setLayoutData(dv0);
			
			weapon0 = new Label(this, SWT.CENTER | SWT.WRAP);
			weapon0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			atkBonus0 = new Label(this, SWT.CENTER);
			atkBonus0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			damage0 = new Label(this, SWT.CENTER);
			damage0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			critical0 = new Label(this, SWT.CENTER);
			critical0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			range0 = new Label(this, SWT.CENTER);
			range0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			type0 = new Label(this, SWT.CENTER);
			type0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			ammo0 = new Text(this, SWT.CENTER | SWT.BORDER);
			ammo0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			Label divider1 = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
			GridData dv1 = new GridData(GridData.FILL_HORIZONTAL);
			dv1.horizontalSpan = 7;
			divider1.setLayoutData(dv1);
		}
	}
	
	private class Basics extends Composite {
		
		Text name;
		Combo class0;
		Spinner level;
		Combo race;
		Combo size;
		Combo gender;
		Combo alignment;
		Text diety;
		Text height;
		

		public Basics(Composite arg0, int arg1) {
			super(arg0, arg1);
			this.setLayout(new GridLayout(6, true));
			CreateLabels();
		} 
		
		public void setHeight(String s) { 
			if(s != null) {
				height.setText(s);
			} else { 
				height.setText("");
			}
		}
		
		public void setDiety(String s) { 
			if(s != null) {
				diety.setText(s);
			} else { 
				diety.setText("");
			}
		}
		
		public void setAlignment(int i) { 
			alignment.select(i);
		}
		
		public void setGender(int i) { 
			gender.select(i);
		}
		
		public void setSize(int i) { 
			size.select(i);
		}
		
		public void setRace(int i) { 
			race.select(i);
		}
		
		public void setLevel(int i) { 
			level.setSelection(i);
		}
		
		public void setClass(int i) { 
			class0.select(i);
		}
		
		public void setName(String s) { 
			name.setText(s);
		}
		
		private void CreateLabels() { 
			Label nameLabel = new Label(this, SWT.NONE | SWT.CENTER);
			nameLabel.setText("Name:");
			nameLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			name = new Text(this, SWT.BORDER | SWT.CENTER);
			name.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			name.setEditable(false);
			name.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!name.getText().isEmpty()) {
						character.setPlayerName(name.getText());
					} else { 
						name.setText(character.getName());
					}
				}
			});
			
			Label classLabel = new Label(this, SWT.NONE | SWT.CENTER);
			classLabel.setText("Class:");
			classLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			class0 = new Combo(this, SWT.READ_ONLY);
			class0.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			String[] classes = {"Barbarian", "Bard", "Cleric", 
					"Druid", "Fighter", "Paladin", "Ranger", "Rogue",
					"Sorcerer", "Wizard"};
			class0.setItems(classes);
			class0.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					character.setClass0(class0.getSelectionIndex());
				}
			});
			
			Label raceLabel = new Label(this, SWT.CENTER);
			raceLabel.setText("Race:");
			raceLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			race = new Combo(this, SWT.READ_ONLY);
			race.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			String[] races = {"Human", "Dwarf", "Elf", "Gnome", "Half-Elf",
					"Half-Orc", "Halfling"};
			race.setItems(races);
			race.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					int index = race.getSelectionIndex();
					character.setRaceInt(index);
					switch (index) { 
					case 0: 
						character.setRace(new Human());
						size.select(4);
						character.setSize(4);
						break;
					case 1:
						character.setRace(new Dwarf());
						size.select(4);
						character.setSize(4);
						break;
					case 2:
						character.setRace(new Elf());
						size.select(4);
						character.setSize(4);
						break;
					case 3: 
						character.setRace(new Gnome());
						size.select(3);
						character.setSize(3);
						break;
					case 4:
						character.setRace(new HalfElf());
						size.select(4);
						character.setSize(4);
						break;
					case 5:
						character.setRace(new HalfOrc());
						size.select(4);
						character.setSize(4);
						break;
					case 6:
						character.setRace(new Halfling());
						size.select(3);
						character.setSize(3);
						break;
					}
					abil.getRaceStats(character.getRace());
					
					/*
					 * Changes the ability modifier labels and total labels
					 * according to the new race change"
					 */
					abil.chaMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCha(character, abil.chaTotal))));
					abil.conMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCon(character, abil.conTotal))));
					abil.dexMod.setText(Integer.toString(Tools.getModifier(Tools.TotalDex(character, abil.dexTotal))));
					abil.intMod.setText(Integer.toString(Tools.getModifier(Tools.TotalInt(character, abil.intTotal))));
					abil.strMod.setText(Integer.toString(Tools.getModifier(Tools.TotalStr(character, abil.strTotal))));
					abil.wisMod.setText(Integer.toString(Tools.getModifier(Tools.TotalWis(character, abil.wisTotal))));
				}
			});
			
			Label levelLabel = new Label(this, SWT.CENTER);
			levelLabel.setText("Level:");
			levelLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			level = new Spinner(this, SWT.BORDER | SWT.CENTER);
			level.setMinimum(0);
			level.setMaximum(100);
			level.setIncrement(1);
			level.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			level.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					character.setLevel(level.getSelection());
				}
			});
			
			Label sizeLabel = new Label(this, SWT.CENTER);
			sizeLabel.setText("Size:");
			sizeLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			size = new Combo(this, SWT.READ_ONLY);
			size.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			String[] sizes = {"Fine", "Diminuitive", "Tiny", "Small",
					"Medium", "Large", "Huge", "Gargantuan", "Colossal"};
			size.setItems(sizes);
			size.setEnabled(false);
			size.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					character.setSize(size.getSelectionIndex());
				}
			});
			
			Label genderLabel = new Label(this, SWT.CENTER);
			genderLabel.setText("Gender:");
			genderLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			gender = new Combo(this, SWT.READ_ONLY);
			gender.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			gender.add("Male");
			gender.add("Female");
			gender.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					character.setGender(gender.getSelectionIndex());
				}
			});
			
			Label alignmentLabel = new Label(this, SWT.CENTER);
			alignmentLabel.setText("Alignment:");
			alignmentLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			alignment = new Combo(this, SWT.READ_ONLY);
			alignment.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			String[] alignments = {"Lawful Good", "Neutral Good", "Chaotic Good", 
					"Lawful Neutral", "Neutral", "Chaotic Neutral", 
					"Lawful Evil", "Neutral Evil", "Chaotic Evil"};
			alignment.setItems(alignments);
			alignment.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					character.setAlignment(alignment.getSelectionIndex());
				}
			});
			
			Label dietyLabel = new Label(this, SWT.CENTER);
			dietyLabel.setText("Diety:");
			dietyLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			diety = new Text(this, SWT.BORDER | SWT.CENTER);
			diety.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			diety.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!diety.getText().isEmpty()) {
						character.setDiety(diety.getText());
					} else { 
						character.setDiety("");
					}
				}
			});
			
			Label heightLabel = new Label(this, SWT.CENTER);
			heightLabel.setText("Height:");
			heightLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			height = new Text(this, SWT.CENTER | SWT.BORDER);
			height.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			height.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!height.getText().isEmpty()) { 
						character.setHeight(height.getText());
					} else { 
						character.setHeight("");
					}
				}
			});
		}
	}
	
	private class Abilities extends Composite {

		private Label strTotal;
		private Text strBase;
		private Text strE;
		private Label strBonus;
		private Label strPenalty;
		private Label strMod;
		
		private Label dexTotal;
		private Text dexBase;
		private Text dexE;
		private Label dexBonus;
		private Label dexPenalty;
		private Label dexMod;
		
		private Label conTotal;
		private Text conBase;
		private Text conE;
		private Label conBonus;
		private Label conPenalty;
		private Label conMod;
		
		private Label chaTotal;
		private Text chaBase;
		private Text chaE;
		private Label chaBonus;
		private Label chaPenalty;
		private Label chaMod;
		
		private Label wisTotal;
		private Text wisBase;
		private Text wisE;
		private Label wisBonus;
		private Label wisPenalty;
		private Label wisMod;
		
		private Label intTotal;
		private Text intBase;
		private Text intE;
		private Label intBonus;
		private Label intPenalty;
		private Label intMod;
		
		private String[] headers = {"Total", "Base", "Bonus", "Racial Bonus",
				"Penalty", "Modifier"};
		
		public Abilities(Composite arg0, int arg1) {
			super(arg0, arg1);
			this.setLayout(new GridLayout(7, true));
			CreateLabels();
		} 
		
		public void getRaceStats(Race race) { 
			intBonus.setText(Integer.toString(race.getIntBonus()));
			wisBonus.setText(Integer.toString(race.getWisBonus()));
			conBonus.setText(Integer.toString(race.getConBonus()));
			chaBonus.setText(Integer.toString(race.getChaBonus()));
			dexBonus.setText(Integer.toString(race.getDexBonus()));
			strBonus.setText(Integer.toString(race.getStrBonus()));
		}
		
		private void CreateLabels() { 
			
			Label space = new Label(this, SWT.NONE);
			space.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			for(int i = 0; i < headers.length; i++) { 
				Label header = new Label(this, SWT.NONE | SWT.CENTER | SWT.WRAP);
				header.setText(headers[i]);
				header.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			}
			
			Label separator = new Label(this, SWT.HORIZONTAL | SWT.SEPARATOR);
			GridData separatorData = new GridData(GridData.FILL_HORIZONTAL);
			separatorData.horizontalSpan = 7;
			separator.setLayoutData(separatorData);
			
			Label str = new Label(this, SWT.NONE | SWT.CENTER);
			str.setText("Str:");
			str.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			strTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			strTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			strBase = new Text(this, SWT.BORDER | SWT.CENTER);
			strBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			strBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!strBase.getText().isEmpty()) { 
						character.setStr(Integer.parseInt(strBase.getText()));
						Tools.TotalStr(character, strTotal);
						strMod.setText(Integer.toString(Tools.getModifier(Tools.TotalStr(character, null))));
					} else { 
						character.setStr(0);
						Tools.TotalStr(character, strTotal);
						strMod.setText(Integer.toString(Tools.getModifier(Tools.TotalStr(character, null))));
					}
				}
			});
			
			strE = new Text(this, SWT.BORDER | SWT.CENTER);
			strE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			strE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!strE.getText().isEmpty()) { 
						System.out.println(strE.getText());
					}
				}
			});
			
			strBonus = new Label(this, SWT.NONE | SWT.CENTER);
			strBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			strPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			strPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			strMod = new Label(this, SWT.BORDER | SWT.CENTER);
			strMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			Label dex = new Label(this, SWT.NONE | SWT.CENTER);
			dex.setText("Dex:");
			dex.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			dexTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			dexTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			dexBase = new Text(this, SWT.BORDER | SWT.CENTER);
			dexBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			dexBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!dexBase.getText().isEmpty()) { 
						character.setDex(Integer.parseInt(dexBase.getText()));
						Tools.TotalDex(character, dexTotal);
						dexMod.setText(Integer.toString(Tools.getModifier(Tools.TotalDex(character, null))));
					} else { 
						character.setDex(0);
						Tools.TotalDex(character, dexTotal);
						dexMod.setText(Integer.toString(Tools.getModifier(Tools.TotalDex(character, null))));
					}
				}
			});
			
			dexE = new Text(this, SWT.BORDER | SWT.CENTER);
			dexE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			dexE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!dexE.getText().isEmpty()) { 
						System.out.println(dexE.getText());
					}
				}
			});
			
			dexBonus = new Label(this, SWT.NONE | SWT.CENTER);
			dexBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			dexPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			dexPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			dexMod = new Label(this, SWT.BORDER | SWT.CENTER);
			dexMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			
			Label con = new Label(this, SWT.NONE | SWT.CENTER);
			con.setText("Con:");
			con.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			conTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			conTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			conBase = new Text(this, SWT.BORDER | SWT.CENTER);
			conBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			conBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!conBase.getText().isEmpty()) { 
						character.setCon(Integer.parseInt(conBase.getText()));
						Tools.TotalCon(character, conTotal);
						conMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCon(character, null))));
					} else { 
						character.setCon(0);
						Tools.TotalCon(character, conTotal);
						conMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCon(character, null))));
					}
				}
			});
			
			conE = new Text(this, SWT.BORDER | SWT.CENTER);
			conE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			conE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!conE.getText().isEmpty()) { 
						System.out.println(conE.getText());
					}
				}
			});
			
			conBonus = new Label(this, SWT.NONE | SWT.CENTER);
			conBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			conPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			conPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			conMod = new Label(this, SWT.BORDER | SWT.CENTER);
			conMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			
			Label cha = new Label(this, SWT.NONE | SWT.CENTER);
			cha.setText("Cha:");
			cha.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			chaTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			chaTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			chaBase = new Text(this, SWT.BORDER | SWT.CENTER);
			chaBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			chaBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!chaBase.getText().isEmpty()) { 
						character.setCha(Integer.parseInt(chaBase.getText()));
						Tools.TotalCha(character, chaTotal);
						chaMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCha(character, null))));
					} else { 
						character.setCha(0);
						Tools.TotalCha(character, chaTotal);
						chaMod.setText(Integer.toString(Tools.getModifier(Tools.TotalCha(character, null))));
					}
				}
			});
			
			chaE = new Text(this, SWT.BORDER | SWT.CENTER);
			chaE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			chaE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!chaE.getText().isEmpty()) { 
						System.out.println(chaE.getText());
					}
				}
			});
			
			chaBonus = new Label(this, SWT.NONE | SWT.CENTER);
			chaBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			chaPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			chaPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			chaMod = new Label(this, SWT.BORDER | SWT.CENTER);
			chaMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			
			Label wis = new Label(this, SWT.NONE | SWT.CENTER);
			wis.setText("Wis:");
			wis.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			wisTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			wisTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			wisBase = new Text(this, SWT.BORDER | SWT.CENTER);
			wisBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			wisBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!wisBase.getText().isEmpty()) { 
						character.setWis(Integer.parseInt(wisBase.getText()));
						Tools.TotalWis(character, wisTotal);
						wisMod.setText(Integer.toString(Tools.getModifier(Tools.TotalWis(character, null))));
					} else { 
						character.setWis(0);
						Tools.TotalWis(character, wisTotal);
						wisMod.setText(Integer.toString(Tools.getModifier(Tools.TotalWis(character, null))));
					}
				}
			});
			
			wisE = new Text(this, SWT.BORDER | SWT.CENTER);
			wisE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			wisE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!wisE.getText().isEmpty()) { 
						System.out.println(wisE.getText());
					}
				}
			});
			
			wisBonus = new Label(this, SWT.NONE | SWT.CENTER);
			wisBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			wisPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			wisPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			wisMod = new Label(this, SWT.BORDER | SWT.CENTER);
			wisMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			
			
			Label inte = new Label(this, SWT.NONE | SWT.CENTER);
			inte.setText("Int:");
			inte.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			intTotal = new Label(this, SWT.BORDER | SWT.CENTER);
			intTotal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			intBase = new Text(this, SWT.BORDER | SWT.CENTER);
			intBase.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			intBase.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!intBase.getText().isEmpty()) { 
						character.setInt(Integer.parseInt(intBase.getText()));
						Tools.TotalInt(character, intTotal);
						intMod.setText(Integer.toString(Tools.getModifier(Tools.TotalInt(character, null))));
					} else { 
						character.setInt(0);
						Tools.TotalInt(character, intTotal);
						intMod.setText(Integer.toString(Tools.getModifier(Tools.TotalInt(character, null))));
					}
				}
			});
			
			intE = new Text(this, SWT.BORDER | SWT.CENTER);
			intE.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			intE.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					if(!intE.getText().isEmpty()) { 
						System.out.println(intE.getText());
					}
				}
			});
			
			intBonus = new Label(this, SWT.NONE | SWT.CENTER);
			intBonus.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			intPenalty = new Label(this, SWT.NONE | SWT.CENTER);
			intPenalty.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			intMod = new Label(this, SWT.BORDER | SWT.CENTER);
			intMod.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		}
	}
	
	private class RaceListener implements SelectionListener {

		@Override
		public void widgetDefaultSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void widgetSelected(SelectionEvent arg0) {
			// TODO Auto-generated method stub
			
		} 
		
	}
}
