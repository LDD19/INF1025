package tp2_fixed;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;

public class WindowMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
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
				new WindowRecherche().setVisible(true);
			}
		});
		btnSearch.setBounds(129, 10, 109, 20);
		contentPane.add(btnSearch);
		setVisible(true);
	}
}
