package tp2_fixed;

import java.io.IOException;

public class Tests {

	public static void main(String[] args) throws IOException {
		
		Index index = new Index();
		
		System.out.println(index.toString());
		
		IndexInverse indexInv = new IndexInverse(index);
		
		System.out.println(indexInv.toString());
		
		String[] mots = {"with", "to", "the"};//mots qu'on entre sur l'interface
		
		ListeScore liste = new ListeScore(indexInv, mots);
		
		System.out.println("Scores : \n" + liste.toString());
		
		System.out.println("inverted" + indexInv.indexInv.get(0).getContenuMots());

	}

}
