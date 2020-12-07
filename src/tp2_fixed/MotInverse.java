//Frederic Achard-Groleau 20165049 et Si Da Li 20086868

package tp2_fixed;

import java.util.*;

public class MotInverse {

	public String mot;
	public LinkedList<DocumentInverse> listeDoc;
	
	public MotInverse(String nomDocument, Mot motTemp) {
		listeDoc = new LinkedList<DocumentInverse>();
		
		this.mot = motTemp.mot;
		listeDoc.addFirst(new DocumentInverse(nomDocument, motTemp.frequence));
	}
	
	public String toString() {
		String texte = mot + " : ";
		
		for(int i = 0; i < listeDoc.size() - 1; ++i) {
			texte += listeDoc.get(i).toString() + ", ";
		}	
		texte += listeDoc.get(listeDoc.size() - 1).toString();
		return texte;
	}
	//methode qui retourne une liste de documents indexes
	public String[] getContenuMots() {
		String[] texte = new String[listeDoc.size()];
		for(int i = 0; i < listeDoc.size(); ++i) {
			texte[i]  = listeDoc.get(i).toString();
		}	
		return texte;
	}
}
