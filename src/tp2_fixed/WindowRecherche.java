package tp2_fixed;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;
import javax.swing.*;

public class WindowRecherche extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public WindowRecherche(IndexInverse indexInv) {
		super("Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500,500);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		JTextField input = new JTextField();
		input.setMaximumSize(new Dimension(250,10));
		input.setHorizontalAlignment(JTextField.CENTER);
		input.setAlignmentX(JTextField.CENTER_ALIGNMENT);
		
		JButton bouton = new JButton("Rechercher");
		bouton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JTextPane surface = new JTextPane();
		
		
		bouton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] mots = input.getText().split(" ");
				ListeScore scores = new ListeScore(indexInv, mots);
				surface.setText(scores.toString());
			}
		});
	
		contentPane.add(input);
		contentPane.add(bouton);
		contentPane.add(surface);
		this.add(contentPane);
	
	}
	
	

}
