package tp2_fixed;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;

public class WindowIndex extends JFrame {
	private JList liste, listeIndex;
	private JSplitPane splitPane1, splitPane2;
	private JPanel panelListe, panelIndex;
    Container contentPane;
	
	LinkedList<Document> nomDocument; 
	LinkedList<Document> indexInv;
	String[] indexes = {"hi", "hi2"}; 
	/** nomDocument.get(1).getNomDocument().toString()
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowIndex frame = new WindowIndex();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowIndex() {
		super("Indexation (admins seulement)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//change to 1024x768
		setBounds(100, 100, 640, 480);
		
		liste = new JList(indexes); 
		panelListe = new JPanel();
		panelListe.add(liste);
		
		
		listeIndex = new JList();
		panelIndex = new JPanel();
		panelIndex.add(listeIndex);
		
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,new JScrollPane(panelListe),panelIndex);
        //splitPane1.setDividerSize(10);
        splitPane1.setOneTouchExpandable(true);
        contentPane = getContentPane();
        contentPane.add(splitPane1);
	}

}
