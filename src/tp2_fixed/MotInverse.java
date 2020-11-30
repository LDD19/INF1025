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
}
