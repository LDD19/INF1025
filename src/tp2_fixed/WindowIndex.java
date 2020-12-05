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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowIndex extends JFrame  {
	private JList liste, listeIndex;
	private JSplitPane splitPane1;
	private JPanel panelListe, panelIndex;
    Container contentPane;
	
	LinkedList<Document> nomDocument; 
	LinkedList<Document> indexInv;
	String[] indexes = {"Veuillez faire une selection", ""}; 
	private JPanel panelBtn;
	private JButton btnInverserIndex;
	/**
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
	
		listeIndex = new JList(indexes);
		panelIndex = new JPanel();
	
		
		liste.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(btnInverserIndex.getText() == "Inverser Index")
					if(liste.getSelectedIndex() != -1)
						listeIndex.setListData((setListe(index, liste.getSelectedIndex())));
				if(btnInverserIndex.getText() == "Index de depart")
					if(liste.getSelectedIndex() != -1)
						listeIndex.setListData((setListeInv(indexInv, liste.getSelectedIndex())));
			}
		});
		
		splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,new JScrollPane(panelListe),new JScrollPane(panelIndex));
        splitPane1.setDividerSize(10);
        splitPane1.setOneTouchExpandable(true);
        contentPane = getContentPane();
        contentPane.add(splitPane1);
        
        panelBtn = new JPanel();
        getContentPane().add(panelBtn, BorderLayout.SOUTH);
        
        btnInverserIndex = new JButton("Inverser Index");
    
        	 btnInverserIndex.addActionListener(new ActionListener() {
 	        	public void actionPerformed(ActionEvent e) {
 	        	    if(btnInverserIndex.getText() == "Inverser Index") {
	 	   			liste.setListData(setListeTitresInv(indexInv));
	 	   			liste.setSelectedIndex(0);
	 	   			listeIndex.removeAll();
	 	   			listeIndex.setListData(indexes);
	 	   			btnInverserIndex.setText("Index de depart");
 	        	    }
 	        	    else if(btnInverserIndex.getText() == "Index de depart") {
	        		liste.setListData(setListeTitres(index));
	        		liste.setSelectedIndex(0);
	 	   			listeIndex.removeAll();
	        		listeIndex.setListData(indexes);
	        		btnInverserIndex.setText("Inverser Index");
 	               }
 	        	}
 	        });
        
        panelBtn.add(btnInverserIndex);
    	panelIndex.add(listeIndex);
    	panelListe.add(liste);
		
	}
	private String[] setListeTitres(Index index){
		String[] listeAAfficher = new String[index.index.size()];
		for (int i = 0 ;i < index.index.size(); i++) {
			listeAAfficher[i] = index.index.get(i).nomDocument;
		}
		return listeAAfficher; 
	}
	private String[] setListeTitresInv(IndexInverse indexInv) {
		String[] listeAAfficher = new String[indexInv.indexInv.size()];
		for (int i = 0 ;i < indexInv.indexInv.size(); i++) {
			listeAAfficher[i] = indexInv.indexInv.get(i).mot;
		}
		return listeAAfficher;
	}
	private String[] setListe(Index index, int i) {
		String[] listeAAfficher = new String[999999];
			listeAAfficher = index.index.get(i).getContenuDocument();
		return listeAAfficher; 
	}
	private String[] setListeInv(IndexInverse indexInv, int i) {
		String[] listeAAfficher = new String[999999];
		listeAAfficher = indexInv.indexInv.get(i).getContenuMots();

		return listeAAfficher; 
	}
}
