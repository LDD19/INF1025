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
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class WindowIndex extends JFrame  {
	private JList liste, listeIndex;
	private JSplitPane splitPane1;
	private JPanel panelListe, panelIndex;
    Container contentPane;
	
	LinkedList<Document> nomDocument; 
	LinkedList<Document> indexInv;
	String[] indexes = {"hi", "hi2", "liste vide"}; 
	/** nomDocument.get(1).getNomDocument().toString()
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public WindowIndex(Index index, IndexInverse indexInv) {
		super("Indexation (admins seulement)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//change to 1024x768
		setBounds(100, 100, 640, 480);
		
		liste = new JList(setListeTitres(index)); 
		
		panelListe = new JPanel();
		panelListe.add(liste);
		
		listeIndex = new JList(indexes);
		panelIndex = new JPanel();
		panelIndex.add(listeIndex);
		
		liste.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				listeIndex.setListData((setListe(index)));
			}
		});
		
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,new JScrollPane(panelListe),new JScrollPane(panelIndex));
        splitPane1.setDividerSize(10);
        splitPane1.setOneTouchExpandable(true);
        contentPane = getContentPane();
        contentPane.add(splitPane1);
	}
	private String[] setListeTitres(Index index){
		String[] listeAAfficher = new String[index.index.size()];
		for (int i = 0 ;i < index.index.size(); i++) {
			listeAAfficher[i] = index.index.get(i).getNomDocument();
			System.out.println(listeAAfficher[i] + i);
		}
		return listeAAfficher; 
	}
	private String[] setListe(Index index) {
		String[] listeAAfficher = new String[index.index.size()];
		for (int i = 0 ;i < index.index.size(); i++) {
			listeAAfficher[i] = index.index.get(i).toString();
			System.out.println(listeAAfficher[i] + i);
		}
		return listeAAfficher; 
	}
}
