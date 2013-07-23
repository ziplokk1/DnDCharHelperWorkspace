package gui;

import java.util.ArrayList;
import java.util.List;

import main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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

import res.Tools;

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
	
	public CharScrSWT() { 
		display = Main.display;
		shell = new Shell(display);
		shell.setText("Character");
		shell.setLayout(new GridLayout(3, false));

		Basics basics = new Basics(shell, SWT.BORDER);
		basics.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		createHP();
		setHP(10);
		
		CreateSkillTable();
		
		Abilities abil = new Abilities(shell, SWT.BORDER);
		GridData abilData = new GridData(GridData.FILL_HORIZONTAL);
		abilData.horizontalSpan = 2;
		abil.setLayoutData(abilData);
		
		Saves saves = new Saves(shell, SWT.BORDER);
		saves.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		CreateMenu();
		
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
	
	private void CreateMenu() { 
		Menu topMenu = new Menu(shell, SWT.BAR);
		Menu fileMenu = new Menu(topMenu);
		Menu resourcesMenu = new Menu(topMenu);
		
		MenuItem fileItem = new MenuItem(topMenu, SWT.CASCADE);
		fileItem.setText("File");
		fileItem.setMenu(fileMenu);
		
		MenuItem newItem = new MenuItem(fileMenu, SWT.CASCADE);
		newItem.setText("New");
		
		MenuItem openItem = new MenuItem(fileMenu, SWT.CASCADE);
		openItem.setText("Open");
		
		MenuItem saveItem = new MenuItem(fileMenu, SWT.CASCADE);
		saveItem.setText("Save");
		
		MenuItem editItem = new MenuItem(topMenu, SWT.CASCADE);
		editItem.setText("Edit");
		
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
				new WeaponsSWT();
				break;
			case "Items":
				new ItemsSWT();
				break;
			}
		} 
		
	}
	
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
		
		final List<res.Skill> list = new ArrayList<res.Skill>();
		
		for(int i = 0; i < skills.length; i++) { 
			list.add(new res.Skill(skills[i]));
		}
		
		currentSkill = new Label(skillGroup, SWT.CENTER | SWT.BOLD | SWT.WRAP);
		GridData csd = new GridData(GridData.FILL_HORIZONTAL);
		csd.horizontalSpan = 4;
		currentSkill.setLayoutData(csd);
		currentSkill.setForeground(new Color(display, 255, 0, 0));
		
		skillList.addSelectionListener(new SelectionAdapter() { 
			@Override
			public void widgetSelected(SelectionEvent e) { 
				currentSkill.setText(skillList.getItem(skillList.getSelectionIndex()));
				activeSkill = list.get(skillList.getSelectionIndex());
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
	}
	
	public void setHP(int i) { 
		hp = i;
		HP.setText("HP: " + Integer.toString(i));
	}
	
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
					// TODO Auto-generated method stub
					
				} 
			});
			
			fortMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			fortMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fortMisc.addListener(SWT.Verify, new VerifyListener());
			fortMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
				} 
			});
			
			fortTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			fortTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			fortTemp.addListener(SWT.Verify, new VerifyListener());
			fortTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
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
					// TODO Auto-generated method stub
					
				} 
			});
			
			refMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			refMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			refMisc.addListener(SWT.Verify, new VerifyListener());
			refMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
				} 
			});
			
			refTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			refTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			refTemp.addListener(SWT.Verify, new VerifyListener());
			refTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
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
					// TODO Auto-generated method stub
					
				} 
			});
			
			willMisc = new Text(this, SWT.CENTER | SWT.BORDER);
			willMisc.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			willMisc.addListener(SWT.Verify, new VerifyListener());
			willMisc.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
				} 
			});
			
			willTemp = new Text(this, SWT.CENTER | SWT.BORDER);
			willTemp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			willTemp.addListener(SWT.Verify, new VerifyListener());
			willTemp.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent arg0) {
					// TODO Auto-generated method stub
					
				} 
			});
		}
	}
	
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
	
	@SuppressWarnings("unused")
	private class Equipment extends Composite {

		public Equipment(Composite arg0, int arg1) {
			super(arg0, arg1);
			
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
		
		private void CreateLabels() { 
			Label nameLabel = new Label(this, SWT.NONE | SWT.CENTER);
			nameLabel.setText("Name:");
			nameLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
			name = new Text(this, SWT.BORDER | SWT.CENTER);
			name.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			name.addListener(SWT.Modify, new Listener() { 
				@Override
				public void handleEvent(Event e) { 
					//Code
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
					//Code
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
					//Code
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
					System.out.println(level.getSelection());
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
			size.addSelectionListener(new SelectionAdapter() { 
				@Override
				public void widgetSelected(SelectionEvent e) { 
					//Code
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
					//Code
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
					//Code
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
					//Code
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
					//Code
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
						System.out.println(strBase.getText());
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
						System.out.println(dexBase.getText());
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
						System.out.println(conBase.getText());
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
						System.out.println(chaBase.getText());
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
						System.out.println(wisBase.getText());
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
						System.out.println(intBase.getText());
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
}
