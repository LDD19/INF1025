//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class WindowMain extends JFrame {

	private JPanel contentPane;

	public WindowMain(Index index, IndexInverse indexInv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 263, 80);
		//setBounds(100, 100, 225, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIndex = new JButton("Indexation");
		btnIndex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WindowIndex(index, indexInv).setVisible(true);
			}
		});
		btnIndex.setBounds(10, 10, 109, 20);
		contentPane.add(btnIndex);
		
		JButton btnSearch = new JButton("Recherche");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WindowRecherche recherche = new WindowRecherche(indexInv);
				recherche.setVisible(true);
			}
		});
		btnSearch.setBounds(129, 10, 109, 20);
		contentPane.add(btnSearch);
		setVisible(true);
	}
}
