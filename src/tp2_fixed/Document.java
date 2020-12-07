//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

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
		
		//tant quil y a un prochain mot dans la liste
		while(iterateur.hasNext()) {
			if(iterateur.next().mot.equals(aAjouter)) {//si le mot est le meme, on incremente
				listeMot.get(index).frequence++;
				return;
			} else if(listeMot.get(index).mot.compareTo(aAjouter) > 0) {//si le mot est plus grand, on l'ajoute a la position
				listeMot.add(index, new Mot(aAjouter));
				return;
			}
			if(!iterateur.hasNext()) {//sil n'y a plus de mots, on l'ajoute a la fin
				listeMot.addLast(new Mot(aAjouter)); 
				return;
			}
			index ++;
		}
	}
	
	//methode qui retourne un tableau de tous les mots d'un document
	public String[] lireFichier(File document) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(document));
		
		String ligne = "";
		String texteLu = "";
		
		//lire le fichier
		while((ligne = reader.readLine())!= null) {
			texteLu += ligne + " ";
		}
		
		reader.close();
		
		texteLu = texteLu.replaceAll("[^\\w]+\\.|\\,|\\(|\\)|\\/", " ");//garder seulement les caracteres qu'on veut
		
		return texteLu.split(" ");
	}
	//methode qui retourne le nom du document + indexage
	public String toString() {
		String texte = nomDocument + " : ";
		
		for(int i = 0; i < listeMot.size() - 1; ++i) {
			texte += listeMot.get(i).toString() + ", ";
		}	
		texte += listeMot.get(listeMot.size() - 1).toString();
		return texte;
	}
	//methode qui retourne le contenu du document, sans le nom du document
	public String[] getContenuDocument() {
		String[] texte = new String[listeMot.size()];
		for(int i = 0; i < listeMot.size(); ++i) {
			texte[i]  = listeMot.get(i).toString();
		}	
		return texte;
	}
}
