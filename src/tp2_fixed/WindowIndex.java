//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class WindowIndex extends JFrame  {
	private JList<String> liste, listeIndex;
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
		setBounds(100, 100, 1024, 768);
		
		liste = new JList<String>(setListeTitres(index)); 
		panelListe = new JPanel();
	
		listeIndex = new JList<String>(indexes);
		panelIndex = new JPanel();
	
		//comportement lorsqu'on selectionne un element dans la liste
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
		splitPane1.setResizeWeight(0.3);
        contentPane = getContentPane();
        contentPane.add(splitPane1);
        
        panelBtn = new JPanel();
        getContentPane().add(panelBtn, BorderLayout.SOUTH);
        
        btnInverserIndex = new JButton("Inverser Index");
        	//comportement des boutons qui affichent une liste inversee
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
	//methode qui retourne une liste de documents  
	private String[] setListeTitres(Index index){
		String[] listeAAfficher = new String[index.index.size()];
		for (int i = 0 ;i < index.index.size(); i++) {
			listeAAfficher[i] = index.index.get(i).nomDocument;
		}
		return listeAAfficher; 
	}
	//methode qui retourne une liste de mots
	private String[] setListeTitresInv(IndexInverse indexInv) {
		String[] listeAAfficher = new String[indexInv.indexInv.size()];
		for (int i = 0 ;i < indexInv.indexInv.size(); i++) {
			listeAAfficher[i] = indexInv.indexInv.get(i).mot;
		}
		return listeAAfficher;
	}
	//methode qui retourne une liste de mots indexe pour les documents 
	private String[] setListe(Index index, int i) {
		String[] listeAAfficher = new String[999999];
			listeAAfficher = index.index.get(i).getContenuDocument();
		return listeAAfficher; 
	}
	//methode qui retourne une liste de documents indexes pour les mots
	private String[] setListeInv(IndexInverse indexInv, int i) {
		String[] listeAAfficher = new String[999999];
		listeAAfficher = indexInv.indexInv.get(i).getContenuMots();

		return listeAAfficher; 
	}
}
