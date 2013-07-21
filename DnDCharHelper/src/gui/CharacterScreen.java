package gui;

import javax.swing.JFrame;
import javax.swing.JList;

public class CharacterScreen extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2606545582107471954L;

	public CharacterScreen() { 
		setTitle("Characters");
		setSize(800, 600);
		
		CreatePlayerPanel();
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void CreatePlayerPanel() { 
		
		String[] selection = {"Mark", "Courtney", "Raney"};
		JList<String> playerList = new JList<String>(selection);
		playerList.setSelectedIndex(1);
		System.out.println(playerList.getSelectedValue());
		this.add(playerList);
	}
}
