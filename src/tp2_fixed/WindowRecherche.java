//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WindowRecherche extends JFrame {

	private JPanel contentPane;

	public WindowRecherche(IndexInverse indexInv) {
		super("Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024, 768);
		contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		JTextField input = new JTextField("Mots a rechercher");
	
		input.setMaximumSize(new Dimension(250,10));
		input.setHorizontalAlignment(JTextField.CENTER);
		input.setAlignmentX(JTextField.CENTER_ALIGNMENT);
		
		JButton bouton = new JButton("Rechercher");
		bouton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		JTextPane surface = new JTextPane();
		//rechercher avec Enter
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					bouton.doClick();
		        }
			}
		});
		//bouton de recherche
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
		getContentPane().add(contentPane);
	}
}
