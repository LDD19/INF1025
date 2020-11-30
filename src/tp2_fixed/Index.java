package tp2_fixed;

import java.io.*;
import java.util.*;



public class Index {
	
	public LinkedList<Document> index;
	
	public Index() throws IOException {
		index = new LinkedList<Document>();
		creerIndex();
	}
	
	public void creerIndex() throws IOException {
		File dossier = new File("src/tp2_fixed/textes");//dossier ou sont tous les textes
		File[] listeTextes = dossier.listFiles();//tableau contenant tous les fichiers
		
		for(int i = 0; i < listeTextes.length; ++i) {
			index.add(new Document(listeTextes[i]));
		}
	}
	
	public String toString() {
		String texte = "";
		
		for(int i = 0; i < index.size(); ++i) {
			texte += index.get(i).toString() + "\n\n";
		}
		return texte;
	}
}