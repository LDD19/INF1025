package tp2_fixed;

import java.util.*;

public class ListeScore {

	public LinkedList<Score> listeScore;
	
	public ListeScore(IndexInverse indexInv, String[] mots) {
		listeScore = indexInv.creerScore(mots);
	}
	
	public ListeScore() {
		listeScore = new LinkedList<Score>();
	}

	public String toString() {
		if(listeScore.isEmpty()) {
			return "Aucun document ne contient tous les mots que vous avec entre.";
		}
		
		String texte = "";
		
		for(int i = 0; i < listeScore.size() - 1; ++i) {
			texte += listeScore.get(i).toString() + "\n";
		}
		texte += listeScore.get(listeScore.size() - 1).toString();
		
		return texte;
	}
	
	//methode qui combine les frequences des documents communs et qui enleve les documents qui ne sont pas dans les deux listes
	public LinkedList<Score> combinerListes(LinkedList<Score> temp){
		boolean motTrouve = false;
		
		for(int i = 0; i < listeScore.size(); ++i) {
			motTrouve = false;
			for(int j = 0; j < temp.size(); ++j) {
				if(listeScore.get(i).nomDocument.equals(temp.get(j).nomDocument)) {//si meme document, augmenter le score
					motTrouve = true;
					listeScore.get(i).score += temp.get(j).score;
				}
			}
			if(motTrouve == false) {//si on a pas trouve le mot, on l'enleve de la liste
				listeScore.remove(i);
				i--;
			}
		}
		return listeScore;
	}
	
	public LinkedList<Score> trier(){//bubble sort
		boolean estTrie = false;
		
		while(!estTrie) {
			estTrie = true;
			for(int i = 0; i < listeScore.size() - 1; ++i) {
				if(listeScore.get(i).score < listeScore.get(i+1).score) {
					estTrie = false;
					Score temp = listeScore.get(i);
					listeScore.remove(i);
					listeScore.add(i+1, temp);
				}
			}
		}
		return listeScore;
	}
}