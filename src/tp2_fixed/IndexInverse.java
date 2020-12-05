package tp2_fixed;

import java.util.*;

public class IndexInverse {

	public LinkedList<MotInverse> indexInv;
	
	public IndexInverse(Index aInverser) {
		indexInv = new LinkedList<MotInverse>();
		
		creerIndexInverse(aInverser);
	}
	
	//methode qui creer l'index inverse a partir d'un index deja mis en ordre
	public void creerIndexInverse(Index aInverser) {
		for(int i = 0; i < aInverser.index.size(); ++i) {//pour chaque liste de mots
			
			String nomDocumentTemp = aInverser.index.get(i).nomDocument;//nom du document qu'on parcours a qui appartient la liste de mots
			
			for(int j = 0; j < aInverser.index.get(i).listeMot.size(); ++j) {//pour chaque mot dans chaque liste de mots
				
				Mot motTemp = aInverser.index.get(i).listeMot.get(j);//mot courant
				
				if(indexInv.size() == 0) {//si la liste est vide, on ajoute le mot qu'on a en premiere position
					indexInv.addFirst(new MotInverse(nomDocumentTemp, motTemp));
					}
				else {//sinon on va au cas par cas
					for(int k = 0; k < indexInv.size(); ++k) {//on cherche dans tout l'index inv. deja construit
						if(indexInv.get(k).mot.equals(motTemp.mot)) {//si le mot est deja dans la liste inverse, on ajoute un nouveau document
																	 //a la fin du mot courant
							indexInv.get(k).listeDoc.addLast(new DocumentInverse(nomDocumentTemp, motTemp.frequence));
							break;
						}else if(indexInv.get(k).mot.compareTo(motTemp.mot) > 0) {//si le mot est plus petit que celui a l'index k, on l'ajoute
																				  //a l'index k pour que tous reste en ordre alphabetique
							indexInv.add(k, new MotInverse(nomDocumentTemp, motTemp));
							break;
						}else if(k == indexInv.size() - 1) {//si on est a la fin de la liste, on ajoute le mot en dernier
							indexInv.addLast(new MotInverse(nomDocumentTemp, motTemp));
							break;
						}
					}
				}
			}
		}
	}
	
	public String toString() {
		String texte = "";
		
		for(int i = 0; i < indexInv.size(); ++i) {
			texte += indexInv.get(i).toString() + "\n";
		}
		return texte;
	}
	
	//on creer une liste donnant le score, en ordre, des documents qui 
	//contiennent tous les mots dans le tableau en parametre
	public LinkedList<Score> creerScore(String[] mots) {
		if(mots.length == 0) {
			return null;
		}
		
		ListeScore liste = new ListeScore();
		
		//rempli la liste pour le premier mot entre
		for(int i = 0; i < indexInv.size(); ++i) {
			if(indexInv.get(i).mot.equals(mots[0])) {
				for(int j = 0; j < indexInv.get(i).listeDoc.size(); ++j) {
					
					String nomDocTemp = indexInv.get(i).listeDoc.get(j).nomDocument;
					int scoreTemp =  indexInv.get(i).listeDoc.get(j).frequence;
					
					liste.listeScore.addLast(new Score(nomDocTemp, scoreTemp));
				}
				break;
			}
		}
		if(mots.length == 1 || liste.listeScore.isEmpty()) {
			return liste.listeScore;
		}
		
		for(int i = 1; i < mots.length; ++i) {//pour chaque mot
			boolean motTrouve = false;
			
			for(int j = 0; j < indexInv.size(); ++j) {//on regarde dans chaque mot de index inv
				if(indexInv.get(j).mot.equals(mots[i])) {//si le mot est le meme
					motTrouve = true;
					LinkedList<Score> temp = new LinkedList<Score>();
					
					//creer une liste temp qu'on va combiner avec la liste de scores
					for(int k = 0; k < indexInv.get(j).listeDoc.size(); ++k) {
						
						String nomDocTemp = indexInv.get(j).listeDoc.get(k).nomDocument;
						int scoreTemp =  indexInv.get(j).listeDoc.get(k).frequence;
						
						temp.addLast(new Score(nomDocTemp, scoreTemp));
					}
					liste.listeScore = liste.combinerListes(temp);
					
					if(liste.listeScore.isEmpty()) {
						return liste.listeScore;
					}
				}
			}
			if(motTrouve == false) {
				liste.listeScore.clear();
				return liste.listeScore;
			}
		}	
		liste.listeScore = liste.trier();
		
		return liste.listeScore;
	}
}
