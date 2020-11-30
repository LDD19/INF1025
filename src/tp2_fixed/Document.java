package tp2_fixed;

import java.io.*;
import java.util.*;

//classe pour stocker tous les mots d'un seul document
public class Document {
	
	public String nomDocument;
	public LinkedList<Mot> listeMot;
	
	public Document(File document) throws IOException {
		listeMot = new LinkedList<Mot>();
		
		creerDocument(document);
	}
	
	public void creerDocument (File document) throws IOException {
		nomDocument = document.getName();
		
		String[] mots = lireFichier(document);
		
		for(int i = 0; i < mots.length; ++i) {
			if(!mots[i].equals("")) {
				ajouterMot(mots[i]);
			}
		}
	}
	
	
	public void ajouterMot(String aAjouter) {
		ListIterator<Mot> iterateur = listeMot.listIterator(0);
		int index = 0;
		
		//si la liste est nulle ou que le premier mot est plus grand que le mot a ajouter, on met le mot en premiere position
		if(!iterateur.hasNext() || iterateur.next().mot.compareTo(aAjouter) > 0) {
			listeMot.addFirst(new Mot(aAjouter));
			return;
		}
		
		iterateur.previous();
		
		while(iterateur.hasNext()) {
			if(iterateur.next().mot.equals(aAjouter)) {
				listeMot.get(index).frequence++;
				return;
			} else if(listeMot.get(index).mot.compareTo(aAjouter) > 0) {
				listeMot.add(index, new Mot(aAjouter));
				return;
			}
			if(!iterateur.hasNext()) {listeMot.addLast(new Mot(aAjouter)); return;}
			index ++;
		}
	}
	
	public boolean contientMot(String aTrouver) {
		ListIterator<Mot> iterateur = listeMot.listIterator();
		
		while(iterateur.hasNext()) {
			if(iterateur.next().mot == aTrouver) {
				return true;
			}
		}
		return false;
	}
	
	
	public String[] lireFichier(File document) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(document));
		
		String ligne = "";
		String texteLu = "";
		
		//lire le fichier
		while((ligne = reader.readLine())!= null) {
			texteLu += ligne + " ";
		}
		
		texteLu = texteLu.replaceAll("[^A-z0-9]", " ");//garder seulement les characteres qu'on veut
		
		return texteLu.split(" ");
	}

	
	public String toString() {
		int index = 0; 
		String texte = "";
		ListIterator<Mot> iterateur = listeMot.listIterator();
		
		while(iterateur.hasNext()) {
			iterateur.next();
			texte += listeMot.get(index).toString() + " ";
			index++;
		}	
		return texte;
	}
}
