package view;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Affichage extends JFrame{
	
	private JButton Case = new JButton();
	private JButton Bateau = new JButton("Bateau");
	
	Affichage(){
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		
		calcPanel.add(Case);
		calcPanel.add(Bateau);
		
		
	}
	
}
